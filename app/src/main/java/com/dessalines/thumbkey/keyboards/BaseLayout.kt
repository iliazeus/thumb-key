@file:Suppress(
    "ktlint:standard:no-wildcard-imports",
    "ktlint:standard:multiline-expression-wrapping",
)

package com.dessalines.thumbkey.keyboards

import android.view.KeyEvent
import android.view.KeyEvent.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.*
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.KeyDisplay.*
import com.dessalines.thumbkey.utils.SlideType.*
import com.dessalines.thumbkey.utils.SwipeDirection.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

open class BaseLayout {
    open fun keyAbc() =
        KeyItemC(
            center = KeyC(ToggleNumericMode(false), Icons.Outlined.Abc, LARGE, color = PRIMARY),
            swipeType = EIGHT_WAY,
            swipes = mapOf(
                TOP to KeyC(Copy, Icons.Outlined.ContentCopy, color = MUTED),
                TOP_LEFT to KeyC(SelectAll, Icons.Outlined.SelectAll, color = MUTED),
                TOP_RIGHT to KeyC(Cut, Icons.Outlined.ContentCut, color = MUTED),
                LEFT to KeyC(Undo, Icons.AutoMirrored.Outlined.Undo, color = MUTED),
                RIGHT to KeyC(Redo, Icons.AutoMirrored.Outlined.Redo, color = MUTED),
                BOTTOM to KeyC(Paste, Icons.Outlined.ContentPaste, color = MUTED),
            ),
            backgroundColor = SURFACE_VARIANT,
        )

    fun keyNum() = NUMERIC_KEY_ITEM

    open fun keyEmoji() =
        KeyItemC(
            center = KeyC(ToggleEmojiMode(true), Icons.Outlined.Mood, LARGE, color = SECONDARY),
            longPress = GotoSettings,
            swipeType = FOUR_WAY_CROSS,
            swipes =
                mapOf(
                    TOP to KeyC(SwitchLanguage, Icons.Outlined.Language, color = MUTED),
                    BOTTOM to KeyC(SwitchIME, Icons.Outlined.Keyboard, color = MUTED),
                    LEFT to KeyC(SwitchPositionLeft, Icons.Outlined.LinearScale, color = MUTED),
                    RIGHT to KeyC(SwitchPositionRight, Icons.Outlined.LinearScale, color = MUTED),
                ),
            backgroundColor = SURFACE_VARIANT,
        )

    fun keyEmojiBack() = EMOJI_BACK_KEY_ITEM

    fun keyBackspace() = BACKSPACE_KEY_ITEM

    open fun keySpace(width: Int = 1) =
        KeyItemC(
            center = KeyC(" "),
            swipeType = FOUR_WAY_CROSS,
            slideType = MOVE_CURSOR,
            swipes = mapOf(
                LEFT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_LEFT), icon = null),
                RIGHT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_RIGHT), icon = null),
            ),
            nextTapActions = listOf(
                ReplaceLastText(", ", trimCount = 1),
                ReplaceLastText(". "),
                ReplaceLastText("? "),
                ReplaceLastText("! "),
                ReplaceLastText(": "),
                ReplaceLastText("; "),
            ),
            backgroundColor = SURFACE_VARIANT,
            widthMultiplier = width,
        )

    fun keyReturn() = RETURN_KEY_ITEM
}

// TODO: these are needed elsewhere

val BACKSPACE_KEY_ITEM =
    KeyItemC(
        center = KeyC(
            event = KeyEvent(ACTION_DOWN, KEYCODE_DEL),
            icon = Icons.AutoMirrored.Outlined.KeyboardBackspace,
            size = LARGE,
            color = SECONDARY,
        ),
        swipeType = TWO_WAY_HORIZONTAL,
        slideType = DELETE,
        swipes = mapOf(
            LEFT to KeyC(DeleteWordBeforeCursor, display = null),
            RIGHT to KeyC(DeleteWordAfterCursor, display = null),
        ),
        backgroundColor = SURFACE_VARIANT,
        longPress = DeleteWordBeforeCursor,
    )

val EMOJI_BACK_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleEmojiMode(false), Icons.Outlined.Abc, LARGE, color = PRIMARY),
        backgroundColor = SURFACE_VARIANT,
    )

val NUMERIC_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleNumericMode(true), Icons.Outlined.Numbers, LARGE, color = SECONDARY),
        swipeType = EIGHT_WAY,
        swipes = mapOf(
            TOP to KeyC(Copy, Icons.Outlined.ContentCopy, color = MUTED),
            TOP_LEFT to KeyC(SelectAll, Icons.Outlined.SelectAll, color = MUTED),
            TOP_RIGHT to KeyC(Cut, Icons.Outlined.ContentCut, color = MUTED),
            LEFT to KeyC(Undo, Icons.AutoMirrored.Outlined.Undo, color = MUTED),
            RIGHT to KeyC(Redo, Icons.AutoMirrored.Outlined.Redo, color = MUTED),
            BOTTOM to KeyC(Paste, Icons.Outlined.ContentPaste, color = MUTED),
        ),
        backgroundColor = SURFACE_VARIANT,
    )

val RETURN_KEY_ITEM =
    KeyItemC(
        center = KeyC(
            action = IMECompleteAction,
            icon = Icons.AutoMirrored.Outlined.KeyboardReturn,
            size = LARGE,
            color = SECONDARY,
        ),
        backgroundColor = SURFACE_VARIANT,
        longPress = CommitText("\n"),
    )
