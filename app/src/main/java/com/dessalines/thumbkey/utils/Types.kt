package com.dessalines.thumbkey.utils

import android.view.KeyEvent
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.dessalines.thumbkey.R

data class KeyboardDefinitionModes(
    val main: KeyboardC,
    val shifted: KeyboardC,
    val numeric: KeyboardC,
)

data class KeyboardDefinitionSettings(
    val autoCapitalizers: AutoCapitalizers = arrayOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KeyboardDefinitionSettings

        return autoCapitalizers.contentEquals(other.autoCapitalizers)
    }

    override fun hashCode(): Int = autoCapitalizers.contentHashCode()
}

data class KeyboardDefinition(
    val title: String,
    val modes: KeyboardDefinitionModes,
    val settings: KeyboardDefinitionSettings = KeyboardDefinitionSettings(),
)

// Almost a 4x4 grid, but the bottom is mostly spacebar
data class KeyboardC(
    val arr: List<List<KeyItemC>>,
)

data class KeyItemC(
    val center: KeyC,
    val swipes: Map<SwipeDirection, KeyC>? = null,
    val nextTapActions: List<KeyAction>? = null,
    val widthMultiplier: Int = 1,
    val backgroundColor: ColorVariant = ColorVariant.SURFACE,
    val swipeType: SwipeNWay = SwipeNWay.EIGHT_WAY,
    val slideType: SlideType = SlideType.NONE,
    val longPress: KeyAction? = null,
)

data class KeyC(
    val action: KeyAction,
    val size: FontSizeVariant = FontSizeVariant.SMALL,
    val color: ColorVariant = ColorVariant.SECONDARY,
    val swipeReturnAction: KeyAction? = null,
    val display: KeyDisplay? =
        when (action) {
            is KeyAction.CommitText -> KeyDisplay.TextDisplay(action.text)
            else -> null
        },
    val capsModeDisplay: KeyDisplay? = null,
) {
    constructor(
        action: KeyAction,
        icon: ImageVector?,
        size: FontSizeVariant = FontSizeVariant.SMALL,
        color: ColorVariant = ColorVariant.SECONDARY,
        capsModeIcon: ImageVector? = null,
        swipeReturnAction: KeyAction? = null,
        display: KeyDisplay? = if (icon != null) KeyDisplay.IconDisplay(icon) else null,
        capsModeDisplay: KeyDisplay? = if (capsModeIcon != null) KeyDisplay.IconDisplay(capsModeIcon) else null,
    ) : this(
        action,
        size,
        color,
        swipeReturnAction,
        display,
        capsModeDisplay,
    )

    constructor(
        event: KeyEvent,
        icon: ImageVector?,
        size: FontSizeVariant = FontSizeVariant.SMALL,
        color: ColorVariant = ColorVariant.SECONDARY,
        capsModeIcon: ImageVector? = null,
        swipeReturnAction: KeyAction? = null,
        display: KeyDisplay? = if (icon != null) KeyDisplay.IconDisplay(icon) else null,
        capsModeDisplay: KeyDisplay? = if (capsModeIcon != null) KeyDisplay.IconDisplay(capsModeIcon) else null,
    ) : this(
        KeyAction.SendEvent(event),
        size,
        color,
        swipeReturnAction,
        display,
        capsModeDisplay,
    )

    constructor(
        text: String,
        size: FontSizeVariant = FontSizeVariant.SMALL,
        color: ColorVariant = ColorVariant.SECONDARY,
        action: KeyAction = KeyAction.CommitText(text),
        swipeReturnAction: KeyAction? = null,
        display: KeyDisplay? = KeyDisplay.TextDisplay(text),
        capsModeDisplay: KeyDisplay? = null,
    ) : this(action, size, color, swipeReturnAction, display, capsModeDisplay)

    constructor(
        text: String,
        event: KeyEvent,
        size: FontSizeVariant = FontSizeVariant.SMALL,
        color: ColorVariant = ColorVariant.SECONDARY,
        swipeReturnAction: KeyAction? = null,
        display: KeyDisplay? = KeyDisplay.TextDisplay(text),
        capsModeDisplay: KeyDisplay? = null,
    ) : this(KeyAction.SendEvent(event), size, color, swipeReturnAction, display, capsModeDisplay)
}

sealed class KeyDisplay {
    class TextDisplay(
        val text: String,
    ) : KeyDisplay()

    class IconDisplay(
        val icon: ImageVector,
    ) : KeyDisplay()
}

sealed class KeyAction {
    class CommitText(
        val text: String,
    ) : KeyAction()

    class SendEvent(
        val event: KeyEvent,
    ) : KeyAction()

    class ReplaceLastText(
        val text: String,
        val trimCount: Int = 2,
    ) : KeyAction()

    class ToggleShiftMode(
        val enable: Boolean,
    ) : KeyAction()

    class ToggleCurrentWordCapitalization(
        val toggleUp: Boolean,
    ) : KeyAction()

    class ToggleNumericMode(
        val enable: Boolean,
    ) : KeyAction()

    class ToggleEmojiMode(
        val enable: Boolean,
    ) : KeyAction()

    class ComposeLastKey(
        val text: String,
    ) : KeyAction()

    data object DeleteWordBeforeCursor : KeyAction()

    data object DeleteWordAfterCursor : KeyAction()

    data object GotoSettings : KeyAction()

    data object IMECompleteAction : KeyAction()

    data object ToggleCapsLock : KeyAction()

    data object SelectAll : KeyAction()

    data object Cut : KeyAction()

    data object Copy : KeyAction()

    data object Paste : KeyAction()

    data object Undo : KeyAction()

    data object Redo : KeyAction()

    data object SwitchLanguage : KeyAction()

    data object SwitchPosition : KeyAction()

    data object SwitchPositionLeft : KeyAction()

    data object SwitchPositionRight : KeyAction()

    data object SwitchIME : KeyAction()

    data object SwitchIMEVoice : KeyAction()
}

enum class CursorAccelerationMode(
    @StringRes val resId: Int,
) {
    LINEAR(R.string.slide_cursor_acceleration_linear),
    QUADRATIC(R.string.slide_cursor_acceleration_quadratic),
    THRESHOLD(R.string.slide_cursor_acceleration_threshold_acceleration),
    CONSTANT(R.string.slide_cursor_acceleration_constant),
}

enum class KeyboardMode {
    MAIN,
    SHIFTED,
    NUMERIC,
    EMOJI,
}

enum class SwipeDirection {
    LEFT,
    TOP_LEFT,
    TOP,
    TOP_RIGHT,
    RIGHT,
    BOTTOM_RIGHT,
    BOTTOM,
    BOTTOM_LEFT,
}

enum class ColorVariant {
    PRIMARY,
    SECONDARY,
    SURFACE,
    SURFACE_VARIANT,
    MUTED,
}

enum class FontSizeVariant {
    LARGE,
    SMALL,
    SMALLEST,
}

enum class ThemeMode(
    @StringRes val resId: Int,
) {
    System(R.string.system),
    Light(R.string.light),
    Dark(R.string.dark),
}

enum class ThemeColor(
    @StringRes val resId: Int,
) {
    Dynamic(R.string.dynamic),
    Green(R.string.green),
    Pink(R.string.pink),
    Srcery(R.string.srcery),
    Blue(R.string.blue),
    Dracula(R.string.dracula),
    Twilight(R.string.twilight),
    HighContrast(R.string.high_contrast),
    HighContrastColorful(R.string.high_contrast_colorful),
    Ancom(R.string.ancom),
    Matrix(R.string.matrix),
}

enum class KeyboardPosition(
    @StringRes val resId: Int,
) {
    Center(R.string.center),
    Right(R.string.right),
    Left(R.string.left),
}

enum class SwipeNWay {
    EIGHT_WAY,
    FOUR_WAY_CROSS,
    FOUR_WAY_DIAGONAL,
    TWO_WAY_VERTICAL,
    TWO_WAY_HORIZONTAL,
}

enum class SlideType {
    NONE,
    MOVE_CURSOR,
    DELETE,
}

data class Selection(
    var start: Int,
    var end: Int,
    var active: Boolean,
) {
    constructor() : this (0, 0, false)

    fun left() {
        end -= 1
    }

    fun left(index: Int) {
        end -= index
    }

    fun right() {
        end += 1
    }

    fun right(index: Int) {
        end += index
    }
}

enum class CircularDirection {
    Clockwise,
    Counterclockwise,
}

enum class CircularDragAction(
    @StringRes val resId: Int,
) {
    OppositeCase(R.string.send_oppsite_case),
    Numeric(R.string.send_numeric),
}
