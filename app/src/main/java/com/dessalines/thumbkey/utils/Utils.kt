package com.dessalines.thumbkey.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.Resources
import android.icu.text.Normalizer2
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.core.os.ConfigurationCompat
import androidx.navigation.NavController
import com.dessalines.thumbkey.IMEService
import com.dessalines.thumbkey.MainActivity
import com.dessalines.thumbkey.R
import com.dessalines.thumbkey.db.AppSettingsViewModel
import com.dessalines.thumbkey.db.DEFAULT_KEYBOARD_LAYOUT
import com.dessalines.thumbkey.db.LayoutsUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.NumberFormat
import kotlin.enums.enumEntries
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.hypot
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

const val TAG = "com.thumbkey"

const val IME_ACTION_CUSTOM_LABEL = EditorInfo.IME_MASK_ACTION + 1
const val ANIMATION_SPEED = 300

fun accelCurve(
    offset: Float,
    threshold: Float,
    exp: Float,
): Float {
    var x = abs(offset)
    val belowThreshold = min(offset, threshold)
    x = max(0.0f, x - belowThreshold)
    return x.pow(exp) + belowThreshold
}

fun acceleratingCursorDistanceThreshold(
    offsetX: Float,
    timeOfLastAccelerationInput: Long,
    acceleration: Int,
): Int {
    // val exp = 1.0f // Slow and we can cover  1 1/2 full lines, so perfect for most.
    // val exp = 1.5f // Slow and we can cover 2 full lines, so perfect for most.
    // val exp = 2.0f // 2.0 should be the default
    // val exp = 3.0f // 3.0 should be the upper limit for this
    // Convert user's chosen acceleration of 1-50 to the amount we need.
    val exp = 1.0f + ((acceleration * 4) / 100f) // Will give us a range from 1-3
    val threshold = 2.0f // The threshold before acceleration kicks in.

    val timeDifference = System.currentTimeMillis() - timeOfLastAccelerationInput
    // Prevent division by 0 error.
    var distance =
        if (timeDifference == 0L) {
            0f
        } else {
            abs(offsetX) / timeDifference
        }

    distance = accelCurve(distance, threshold, exp)
    if (offsetX < 0) {
        // Set the value back to negative.
        // A distance of -1 will move the cursor left by 1 character
        distance *= -1
    }
    // distance = offsetX / 10
    return distance.toInt()
}

fun slideCursorDistance(
    offsetX: Float,
    timeOfLastAccelerationInput: Long,
    accelerationMode: Int,
    acceleration: Int,
): Int {
    when (accelerationMode) {
        CursorAccelerationMode.CONSTANT.ordinal -> {
            // Do the same speed every time
            val settingsSliderMaxValue = 50

            return if (abs(offsetX) > (settingsSliderMaxValue - acceleration)) {
                if (offsetX > 0) {
                    1
                } else {
                    -1
                }
            } else {
                0
            }
        }

        CursorAccelerationMode.QUADRATIC.ordinal -> return acceleratingCursorDistanceQuadratic(
            offsetX,
            timeOfLastAccelerationInput,
            acceleration,
        )

        CursorAccelerationMode.LINEAR.ordinal -> return acceleratingCursorDistanceLinear(
            offsetX,
            timeOfLastAccelerationInput,
            acceleration,
        )

        CursorAccelerationMode.THRESHOLD.ordinal -> return acceleratingCursorDistanceThreshold(
            offsetX,
            timeOfLastAccelerationInput,
            acceleration,
        )

        else -> {
            // Default to this if there is no match.
            return acceleratingCursorDistanceLinear(
                offsetX,
                timeOfLastAccelerationInput,
                acceleration,
            )
        }
    }
}

fun acceleratingCursorDistanceLinear(
    offsetX: Float,
    timeOfLastAccelerationInput: Long,
    acceleration: Int,
): Int {
    val accelerationCurve = ((acceleration * 6) / 100f) // Will give us a range from 0-3
    val timeDifference = System.currentTimeMillis() - timeOfLastAccelerationInput
    // Prevent division by 0 error.
    var distance =
        if (timeDifference == 0L) {
            0f
        } else {
            abs(offsetX) / timeDifference
        }

    distance *= accelerationCurve
    if (offsetX < 0) {
        // Set the value back to negative.
        // A distance of -1 will move the cursor left by 1 character
        distance *= -1
    }

    return distance.toInt()
}

fun acceleratingCursorDistanceQuadratic(
    offsetX: Float,
    timeOfLastAccelerationInput: Long,
    acceleration: Int,
): Int {
    val accelerationCurve = 0.1f + ((acceleration * 6) / 1000f) // Will give us a range from 0.1-0.4
    val timeDifference = System.currentTimeMillis() - timeOfLastAccelerationInput
    // Prevent division by 0 error.
    var distance =
        if (timeDifference == 0L) {
            0f
        } else {
            abs(offsetX) / timeDifference
        }

    // Quadratic equation to make the swipe acceleration work along a curve.
    // val accelerationCurve = 0.3f // Fast and almost perfect.
    // var accelerationCurve = 0.2f // Fast and almost perfect.
    // var accelerationCurve = 0.1f // Slowish and moves almost a full line at a time.
    // var accelerationCurve = 0.01f // is slow, only 1 char at a time.
    distance = accelerationCurve * distance.pow(2)
    if (offsetX < 0) {
        // Set the value back to negative.
        // A distance of -1 will move the cursor left by 1 character
        distance *= -1
    }

    return distance.toInt()
}

@Composable
fun colorVariantToColor(colorVariant: ColorVariant): Color =
    when (colorVariant) {
        ColorVariant.SURFACE -> MaterialTheme.colorScheme.surface
        ColorVariant.SURFACE_VARIANT -> MaterialTheme.colorScheme.surfaceVariant
        ColorVariant.PRIMARY -> MaterialTheme.colorScheme.primary
        ColorVariant.SECONDARY -> MaterialTheme.colorScheme.secondary
        ColorVariant.MUTED -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.5F)
    }

fun fontSizeVariantToFontSize(
    fontSizeVariant: FontSizeVariant,
    keySize: Dp,
    isUpperCase: Boolean,
): Dp {
    val divFactor =
        when (fontSizeVariant) {
            FontSizeVariant.LARGE -> 2.5f
            FontSizeVariant.SMALL -> 5f
            FontSizeVariant.SMALLEST -> 8f
        }

    // Make uppercase letters slightly smaller
    val upperCaseFactor =
        if (isUpperCase) {
            0.8f
        } else {
            1f
        }

    return keySize.times(upperCaseFactor).div(divFactor)
}

val Dp.toPx get() = (this * Resources.getSystem().displayMetrics.density).value
val Float.pxToSp
    get() =
        TextUnit(
            this / Resources.getSystem().displayMetrics.scaledDensity,
            TextUnitType.Sp,
        )

fun keyboardPositionToAlignment(position: KeyboardPosition): Alignment =
    when (position) {
        KeyboardPosition.Right -> Alignment.BottomEnd
        KeyboardPosition.Center -> Alignment.BottomCenter
        KeyboardPosition.Left -> Alignment.BottomStart
    }

fun swipeDirection(
    key: KeyItemC,
    x: Float,
    y: Float,
    minSwipeLength: Int,
): SwipeDirection? {
    val swipeLength = hypot(x, y)
    if (swipeLength < minSwipeLength) return null

    var bestDir: SwipeDirection? = null
    var bestCosine: Float = 0.0f

    for (dir in enumEntries<SwipeDirection>()) {
        if (key.getSwipe(dir) == null) continue

        var dirVec = dir.vector()
        val dotProduct = dirVec.x * x + dirVec.y * y
        val cosine = dotProduct / (swipeLength * hypot(dirVec.x, dirVec.y))
        if (cosine <= 0) continue

        if (cosine > bestCosine) {
            bestDir = dir
            bestCosine = cosine
        }
    }

    return bestDir
}

fun performKeyAction(
    action: KeyAction,
    ime: IMEService,
    autoCapitalize: Boolean,
    keyboardSettings: KeyboardDefinitionSettings,
    onToggleShiftMode: (enable: Boolean) -> Unit,
    onToggleNumericMode: (enable: Boolean) -> Unit,
    onToggleEmojiMode: (enable: Boolean) -> Unit,
    onToggleCapsLock: () -> Unit,
    onAutoCapitalize: (enable: Boolean) -> Unit,
    onSwitchLanguage: () -> Unit,
    onSwitchPosition: () -> Unit,
) {
    when (action) {
        is KeyAction.CommitText -> {
            val text = action.text
            Log.d(TAG, "committing key text: $text")
            ime.ignoreNextCursorMove()
            ime.currentInputConnection.commitText(
                text,
                1,
            )

            if (autoCapitalize) {
                autoCapitalize(
                    ime = ime,
                    onAutoCapitalize = onAutoCapitalize,
                    autocapitalizers = keyboardSettings.autoCapitalizers,
                )
            } else { // To return to MAIN mode after a shifted key action.
                onAutoCapitalize(false)
            }
        }

        is KeyAction.SendEvent -> {
            val ev = action.event
            Log.d(TAG, "sending key event: $ev")
            ime.currentInputConnection.sendKeyEvent(ev)
        }

        is KeyAction.DeleteWordBeforeCursor -> {
            Log.d(TAG, "deleting last word")
            deleteWordBeforeCursor(ime)
        }

        is KeyAction.DeleteWordAfterCursor -> {
            Log.d(TAG, "deleting next word")
            deleteWordAfterCursor(ime)
        }

        is KeyAction.ReplaceLastText -> {
            Log.d(TAG, "replacing last word")
            val text = action.text

            ime.ignoreNextCursorMove()
            ime.currentInputConnection.deleteSurroundingText(action.trimCount, 0)
            ime.currentInputConnection.commitText(
                text,
                1,
            )
            if (autoCapitalize) {
                autoCapitalize(
                    ime = ime,
                    onAutoCapitalize = onAutoCapitalize,
                    autocapitalizers = keyboardSettings.autoCapitalizers,
                )
            }
        }

        is KeyAction.ComposeLastKey -> {
            Log.d(TAG, "composing last key")
            val text = action.text
            val textBefore = ime.currentInputConnection.getTextBeforeCursor(1, 0)

            // Unicode combining characters
            // these use their Unicode name, with `COMBINING` removed:
            val diaeresis = '\u0308'
            val acuteAccent = '\u0301'
            val graveAccent = '\u0300'
            val circumflexAccent = '\u0302'
            val tilde = '\u0303'
            val ringAbove = '\u030A'
            val breve = '\u0306'
            val hookAbove = '\u0309'
            val dotBelow = '\u0323'
            val caron = '\u030C'

            // for these ones the actual Unicode name is way too unwieldy:
            val dakuten = '\u3099'
            val handakuten = '\u309A'

            fun tryCombine(
                char: Char,
                text: CharSequence?,
            ): CharSequence? {
                if (text == null) return null
                val normalizer = Normalizer2.getNFCInstance()
                val combined = normalizer.normalize(char.toString() + text.first())
                if (combined.length == text.length) {
                    return combined
                } else {
                    return text
                }
            }

            // the general principle for these rules
            // is to rely on tryCombine() as much as possible,
            // only using explicit mappings for exceptional cases

            // there may be when() expressions with only a single else clause
            // there are intentionally here to simplify diffs
            // in case more rules are added later

            val textNew =
                when (text) {
                    "\"" ->
                        when (textBefore) {
                            " " -> "\""
                            "'" -> "\""
                            else -> tryCombine(diaeresis, textBefore)
                        }

                    "'" ->
                        when (textBefore) {
                            "'" -> "”"
                            " " -> "'"
                            "\"" -> "'"
                            else -> tryCombine(acuteAccent, textBefore)
                        }

                    "`" ->
                        when (textBefore) {
                            "`" -> " “"
                            " " -> "`"
                            else -> tryCombine(graveAccent, textBefore)
                        }

                    "^" ->
                        when (textBefore) {
                            " " -> "^"
                            else -> tryCombine(circumflexAccent, textBefore)
                        }

                    "~" ->
                        when (textBefore) {
                            " " -> "~"
                            else -> tryCombine(tilde, textBefore)
                        }

                    "°" ->
                        when (textBefore) {
                            "o" -> "ø"
                            "O" -> "Ø"
                            " " -> "°"
                            else -> tryCombine(ringAbove, textBefore)
                        }

                    "˘" ->
                        when (textBefore) {
                            " " -> "˘"
                            else -> tryCombine(breve, textBefore)
                        }

                    "!" ->
                        when (textBefore) {
                            "a" -> "æ"
                            "A" -> "Æ"
                            "æ" -> "ą"
                            "Æ" -> "Ą"
                            "c" -> "ç"
                            "C" -> "Ç"
                            "e" -> "ę"
                            "E" -> "Ę"
                            "l" -> "ł"
                            "L" -> "Ł"
                            "o" -> "œ"
                            "O" -> "Œ"
                            "s" -> "ß"
                            "S" -> "ẞ"
                            "z" -> "ż"
                            "Z" -> "Ż"
                            "!" -> "¡"
                            "?" -> "¿"
                            "`" -> " “"
                            "´" -> "”"
                            "\"" -> " “"
                            "'" -> "”"
                            "<" -> "«"
                            ">" -> "»"
                            " " -> "!"
                            else -> textBefore
                        }

                    "\$" ->
                        when (textBefore) {
                            "c", "C" -> "¢"
                            "e", "E" -> "€"
                            "f", "F" -> "₣"
                            "l", "L" -> "£"
                            "y", "Y" -> "¥"
                            "w", "W" -> "₩"
                            " " -> "\$"
                            else -> textBefore
                        }

                    "゛" ->
                        when (textBefore) {
                            "あ" -> "ぁ"
                            "い" -> "ぃ"
                            "う" -> "ぅ"
                            "え" -> "ぇ"
                            "お" -> "ぉ"
                            "ぅ" -> "ゔ"
                            "が" -> "ゕ"
                            "げ" -> "ゖ"
                            "づ" -> "っ"
                            "ば" -> "ぱ"
                            "び" -> "ぴ"
                            "ぶ" -> "ぷ"
                            "べ" -> "ぺ"
                            "ぼ" -> "ぽ"
                            "や" -> "ゃ"
                            "ゆ" -> "ゅ"
                            "よ" -> "ょ"
                            "わ" -> "ゎ"
                            "ゝ" -> "ゞ"
                            "ア" -> "ァ"
                            "イ" -> "ィ"
                            "ウ" -> "ゥ"
                            "エ" -> "ェ"
                            "オ" -> "ォ"
                            "ゥ" -> "ヴ"
                            "ガ" -> "ヵ"
                            "ゲ" -> "ヶ"
                            "ヅ" -> "ッ"
                            "バ" -> "パ"
                            "ビ" -> "ピ"
                            "ブ" -> "プ"
                            "ベ" -> "ペ"
                            "ボ" -> "ポ"
                            "ヤ" -> "ャ"
                            "ユ" -> "ュ"
                            "ヨ" -> "ョ"
                            "ワ" -> "ヷ"
                            "ヰ" -> "ヸ"
                            "ヱ" -> "ヹ"
                            "ヲ" -> "ヺ"
                            "ヷ" -> "ヮ"
                            "ヽ" -> "ヾ"
                            else -> tryCombine(dakuten, textBefore)
                        }

                    "?" ->
                        when (textBefore) {
                            else -> tryCombine(hookAbove, textBefore)
                        }

                    "*" ->
                        when (textBefore) {
                            else -> tryCombine(dotBelow, textBefore)
                        }

                    "ˇ" ->
                        when (textBefore) {
                            "d" -> "ď"
                            "l" -> "ľ"
                            "t" -> "ť"
                            "L" -> "Ľ"
                            " " -> "ˇ"
                            else -> tryCombine(caron, textBefore)
                        }

                    else -> throw IllegalStateException("Invalid key modifier")
                }

            if (textNew != textBefore) {
                ime.currentInputConnection.deleteSurroundingText(1, 0)
                ime.currentInputConnection.commitText(textNew, 1)
            }
        }

        is KeyAction.ToggleShiftMode -> {
            val enable = action.enable
            Log.d(TAG, "Toggling Shifted: $enable")
            onToggleShiftMode(enable)
        }

        is KeyAction.ToggleNumericMode -> {
            val enable = action.enable
            Log.d(TAG, "Toggling Numeric: $enable")
            onToggleNumericMode(enable)
        }

        is KeyAction.ToggleEmojiMode -> {
            val enable = action.enable
            Log.d(TAG, "Toggling Emoji: $enable")
            onToggleEmojiMode(enable)
        }

        KeyAction.GotoSettings -> {
            val mainActivityIntent = Intent(ime, MainActivity::class.java)
            mainActivityIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            mainActivityIntent.putExtra("startRoute", "settings")
            ime.startActivity(mainActivityIntent)
        }

        KeyAction.IMECompleteAction -> {
            // A lot of apps like discord and slack use weird IME actions,
            // so its best to only check the none case
            when (val imeAction = getImeActionCode(ime)) {
                IME_ACTION_CUSTOM_LABEL -> {
                    ime.currentInputConnection.performEditorAction(ime.currentInputEditorInfo.actionId)
                }

                EditorInfo.IME_ACTION_NONE -> {
                    ime.currentInputConnection.sendKeyEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_ENTER,
                        ),
                    )
                }

                else -> {
                    ime.currentInputConnection.performEditorAction(imeAction)
                }
            }
        }

        KeyAction.ToggleCapsLock -> onToggleCapsLock()
        KeyAction.SelectAll -> {
            // Check here for the action #s:
            // https://developer.android.com/reference/android/R.id
            ime.currentInputConnection.performContextMenuAction(android.R.id.selectAll)
        }

        KeyAction.Cut -> {
            if (ime.currentInputConnection.getSelectedText(0).isNullOrEmpty()) {
                // Nothing selected, so cut all the text
                ime.currentInputConnection.performContextMenuAction(android.R.id.selectAll)
                // Wait a bit for the select all to complete.
                val delayInMillis = 100L
                Handler(Looper.getMainLooper()).postDelayed({
                    ime.currentInputConnection.performContextMenuAction(android.R.id.cut)
                }, delayInMillis)
            } else {
                ime.currentInputConnection.performContextMenuAction(android.R.id.cut)
            }
        }

        KeyAction.Copy -> {
            if (ime.currentInputConnection.getSelectedText(0).isNullOrEmpty()) {
                // Nothing selected, so copy all the text
                ime.currentInputConnection.performContextMenuAction(android.R.id.selectAll)
                // Wait a bit for the select all to complete.
                val delayInMillis = 100L
                Handler(Looper.getMainLooper()).postDelayed({
                    ime.currentInputConnection.performContextMenuAction(android.R.id.copy)
                }, delayInMillis)
            } else {
                ime.currentInputConnection.performContextMenuAction(android.R.id.copy)
            }

            val message = ime.getString(R.string.copy)
            Toast.makeText(ime, message, Toast.LENGTH_SHORT).show()
        }

        KeyAction.Paste -> {
            ime.currentInputConnection.performContextMenuAction(android.R.id.paste)
        }

        KeyAction.Undo -> {
            ime.currentInputConnection.sendKeyEvent(
                KeyEvent(0, 0, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_Z, 0, KeyEvent.META_CTRL_ON),
            )
        }

        KeyAction.Redo -> {
            ime.currentInputConnection.sendKeyEvent(
                KeyEvent(
                    0,
                    0,
                    KeyEvent.ACTION_DOWN,
                    KeyEvent.KEYCODE_Z,
                    0,
                    (KeyEvent.META_CTRL_ON or KeyEvent.META_SHIFT_ON),
                ),
            )
        }

        KeyAction.SwitchLanguage -> onSwitchLanguage()
        KeyAction.SwitchPosition -> onSwitchPosition()
        KeyAction.SwitchIME -> {
            val imeManager =
                ime.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imeManager.showInputMethodPicker()
        }

        KeyAction.SwitchIMEVoice -> {
            val imeManager =
                ime.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val list: List<InputMethodInfo> = imeManager.enabledInputMethodList
            for (el in list) {
                for (i in 0 until el.subtypeCount) {
                    if (el.getSubtypeAt(i).mode != "voice") continue
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        ime.switchInputMethod(el.id)
                    } else {
                        ime.window.window?.let { window ->
                            @Suppress("DEPRECATION")
                            imeManager.setInputMethod(window.attributes.token, el.id)
                        }
                    }
                }
            }
        }

        is KeyAction.ToggleCurrentWordCapitalization -> {
            val maxLength = 100
            val wordBorderCharacters = ".,;:!?\"'()-—[]{}<>/\\|#$%^_+=~`"
            val textBeforeCursor = ime.currentInputConnection.getTextBeforeCursor(maxLength, 0)
            if (!textBeforeCursor.isNullOrEmpty()) {
                val startWordIndex =
                    textBeforeCursor
                        .toString()
                        .indexOfLast { it.isWhitespace() || wordBorderCharacters.contains(it) }
                        .plus(1)
                if (startWordIndex < textBeforeCursor.length) {
                    val replacementText =
                        if (action.toggleUp) {
                            if (textBeforeCursor[startWordIndex].isUpperCase()) {
                                textBeforeCursor.substring(startWordIndex).uppercase()
                            } else {
                                textBeforeCursor
                                    .substring(startWordIndex, startWordIndex + 1)
                                    .uppercase() + textBeforeCursor.substring(startWordIndex + 1)
                            }
                        } else {
                            textBeforeCursor.substring(startWordIndex).lowercase()
                        }
                    ime.currentInputConnection.deleteSurroundingText(
                        textBeforeCursor.length - startWordIndex,
                        0,
                    )
                    ime.currentInputConnection.commitText(replacementText, 1)
                }
            }
        }
    }
}

/**
 * Returns the current IME action, or IME_FLAG_NO_ENTER_ACTION if there is none.
 */
fun getImeActionCode(ime: IMEService): Int {
    val ei = ime.currentInputEditorInfo

    return if ((ei.imeOptions and EditorInfo.IME_FLAG_NO_ENTER_ACTION) != 0) {
        EditorInfo.IME_ACTION_NONE
    } else if (ei.actionLabel != null) {
        IME_ACTION_CUSTOM_LABEL
    } else {
        // Note: this is different from editorInfo.actionId, hence "ImeOptionsActionId"
        ei.imeOptions and EditorInfo.IME_MASK_ACTION
    }
}

/**
 * Returns the correct keyboard mode
 */
fun getKeyboardMode(
    ime: IMEService,
    autoCapitalize: Boolean,
): KeyboardMode {
    val inputType = ime.currentInputEditorInfo.inputType and (InputType.TYPE_MASK_CLASS)

    return if (listOf(
            InputType.TYPE_CLASS_NUMBER,
            InputType.TYPE_CLASS_PHONE,
        ).contains(inputType)
    ) {
        KeyboardMode.NUMERIC
    } else {
        if (autoCapitalize && !isUriOrEmailOrPasswordField(ime) && autoCapitalizeCheck(ime)) {
            KeyboardMode.SHIFTED
        } else {
            KeyboardMode.MAIN
        }
    }
}

private fun autoCapitalize(
    ime: IMEService,
    onAutoCapitalize: (enable: Boolean) -> Unit,
    autocapitalizers: AutoCapitalizers,
) {
    // Run language specific autocapitalizers
    autocapitalizers.forEach { fn ->
        fn(ime)
    }

    if (autoCapitalizeCheck(ime)) {
        onAutoCapitalize(true)
    } else {
        onAutoCapitalize(false)
    }
}

fun autoCapitalizeCheck(ime: IMEService): Boolean = ime.currentInputConnection.getCursorCapsMode(ime.currentInputEditorInfo.inputType) > 0

/**
 * Avoid capitalizing or switching to shifted mode in certain edit boxes
 */
fun isUriOrEmailOrPasswordField(ime: IMEService): Boolean {
    val inputType = ime.currentInputEditorInfo.inputType and (InputType.TYPE_MASK_VARIATION)
    return listOf(
        InputType.TYPE_TEXT_VARIATION_URI,
        InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS,
        InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS,
        InputType.TYPE_TEXT_VARIATION_PASSWORD,
        InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD,
        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD,
        InputType.TYPE_NUMBER_VARIATION_PASSWORD,
    ).contains(inputType) ||
        ime.currentInputEditorInfo.inputType == EditorInfo.TYPE_NULL
}

fun isPasswordField(ime: IMEService): Boolean {
    val inputType = ime.currentInputEditorInfo.inputType and (InputType.TYPE_MASK_VARIATION)
    return listOf(
        InputType.TYPE_TEXT_VARIATION_PASSWORD,
        InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD,
        InputType.TYPE_NUMBER_VARIATION_PASSWORD,
    ).contains(inputType) ||
        ime.currentInputEditorInfo.inputType == EditorInfo.TYPE_NULL
}

fun deleteWordBeforeCursor(ime: IMEService) {
    val wordsBeforeCursor = ime.currentInputConnection.getTextBeforeCursor(9999, 0)

    val pattern = Regex("(\\w+\\W?|[^\\s\\w]+)?\\s*$")
    val lastWordLength = wordsBeforeCursor?.let { pattern.find(it)?.value?.length } ?: 0

    ime.currentInputConnection.deleteSurroundingText(lastWordLength, 0)
}

fun deleteWordAfterCursor(ime: IMEService) {
    val wordsAfterCursor = ime.currentInputConnection.getTextAfterCursor(9999, 0)

    val pattern = Regex("^\\s?(\\w+\\W?|[^\\s\\w]+|\\s+)")
    val nextWordLength = wordsAfterCursor?.let { pattern.find(it)?.value?.length } ?: 0

    ime.currentInputConnection.deleteSurroundingText(0, nextWordLength)
}

fun buildTapActions(keyItem: KeyItemC): List<KeyAction> {
    val mutable = mutableListOf(keyItem.center.action)
    mutable.addAll(keyItem.nextTapActions.orEmpty())
    return mutable.toList()
}

fun doneKeyAction(
    scope: CoroutineScope,
    action: KeyAction,
    pressed: MutableState<Boolean>,
    releasedKey: MutableState<String?>,
    animationHelperSpeed: Int,
) {
    pressed.value = false
    scope.launch {
        delay(animationHelperSpeed.toLong())
        releasedKey.value = null
    }
    releasedKey.value =
        when (action) {
            is KeyAction.CommitText -> {
                action.text
            }

            else -> {
                null
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(
    text: String,
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showBack: Boolean = true,
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = text,
            )
        },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = { navController.navigate("settings") }) {
                    Icon(
                        Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = stringResource(R.string.settings),
                    )
                }
            }
        },
    )
}

fun openLink(
    url: String,
    ctx: Context,
) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    ctx.startActivity(intent)
}

fun Int.toBool() = this == 1

fun Boolean.toInt() = this.compareTo(false)

/**
 * The layouts there are whats stored in the DB, a string comma set of title index numbers
 */
fun keyboardLayoutsSetFromDbIndexString(layouts: String?): Set<KeyboardLayout> =
    layouts?.split(",")?.map { KeyboardLayout.entries[it.trim().toInt()] }?.toSet()
        ?: setOf(
            KeyboardLayout.entries[DEFAULT_KEYBOARD_LAYOUT],
        )

fun Context.getPackageInfo(): PackageInfo =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
    } else {
        packageManager.getPackageInfo(packageName, 0)
    }

fun Context.getVersionCode(): Int =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        getPackageInfo().longVersionCode.toInt()
    } else {
        @Suppress("DEPRECATION")
        getPackageInfo().versionCode
    }

/**
 * The debug and app IME names act strange, so you need to check both
 */
fun Context.getImeNames(): List<String> =
    listOf(
        "$packageName/com.dessalines.thumbkey.IMEService",
        "$packageName/.IMEService",
    )

fun startSelection(ime: IMEService): Selection {
    val cursorPosition =
        ime.currentInputConnection
            .getTextBeforeCursor(
                Integer.MAX_VALUE,
                0,
            )?.length
    cursorPosition?.let {
        return Selection(it, it, true)
    }
    return Selection()
}

fun getLocalCurrency(): String? =
    ConfigurationCompat.getLocales(Resources.getSystem().configuration)[0]?.let {
        NumberFormat
            .getCurrencyInstance(
                it,
            ).currency
            ?.symbol
    }

fun lastColKeysToFirst(board: KeyboardC): KeyboardC {
    val newArr =
        board.arr.map { row ->
            if (row.isNotEmpty()) {
                listOf(row.last()) + row.dropLast(1)
            } else {
                row
            }
        }
    return KeyboardC(newArr)
}

fun circularDirection(
    positions: List<Offset>,
    circleCompletionTolerance: Float,
): CircularDirection? {
    val center = positions.reduce(Offset::plus) / positions.count().toFloat()
    val radii = positions.map { it.getDistanceTo(center) }
    val maxRadius = radii.reduce { acc, it -> if (it > acc) it else acc }
    // This is similar to accepting an ellipse with aspect ratio 3:1
    val minRadius = maxRadius / 3
    val similarRadii =
        radii.all {
            it in minRadius..maxRadius
        }

    if (!similarRadii) {
        return null
    }
    val spannedAngle =
        positions
            .asSequence()
            .map { it - center } // transform center into origin
            .windowed(2)
            .map { (a, b) ->
                val (xa, ya) = a
                val (xb, yb) = b
                // angle between two vectors
                atan2(
                    xa * yb - ya * xb,
                    xa * xb + ya * yb,
                )
            }.sum()

    val averageRadius = (minRadius + maxRadius) / 2
    // The threshold is a full circumference minus the arc with length equal to the tolerance
    val angleThreshold = 2 * PI * (1 - circleCompletionTolerance / averageRadius)
    return when {
        spannedAngle >= angleThreshold -> CircularDirection.Clockwise
        spannedAngle <= -angleThreshold -> CircularDirection.Counterclockwise
        else -> null
    }
}

fun Offset.getDistanceTo(other: Offset) = (other - this).getDistance()

fun updateLayouts(
    appSettingsViewModel: AppSettingsViewModel,
    layoutsState: Set<KeyboardLayout>,
) {
    appSettingsViewModel.updateLayouts(
        LayoutsUpdate(
            id = 1,
            // Set the current to the first
            keyboardLayout = layoutsState.first().ordinal,
            keyboardLayouts =
                layoutsState
                    .map { it.ordinal }
                    .joinToString(),
        ),
    )
}
