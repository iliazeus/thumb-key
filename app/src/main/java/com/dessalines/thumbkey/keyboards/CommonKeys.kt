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

val ABC_OR_NUMERIC_SWIPES =
    mapOf(
        TOP to KeyC(Copy, Icons.Outlined.ContentCopy, color = MUTED),
        TOP_LEFT to KeyC(SelectAll, Icons.Outlined.SelectAll, color = MUTED),
        TOP_RIGHT to KeyC(Cut, Icons.Outlined.ContentCut, color = MUTED),
        LEFT to KeyC(Undo, Icons.AutoMirrored.Outlined.Undo, color = MUTED),
        RIGHT to KeyC(Redo, Icons.AutoMirrored.Outlined.Redo, color = MUTED),
        BOTTOM to KeyC(Paste, Icons.Outlined.ContentPaste, color = MUTED),
    )

val ABC_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleNumericMode(false), Icons.Outlined.Abc, LARGE, color = PRIMARY),
        swipeType = EIGHT_WAY,
        swipes = ABC_OR_NUMERIC_SWIPES,
        backgroundColor = SURFACE_VARIANT,
    )

val NUMERIC_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleNumericMode(true), Icons.Outlined.Numbers, LARGE, color = SECONDARY),
        swipeType = EIGHT_WAY,
        swipes = ABC_OR_NUMERIC_SWIPES,
        backgroundColor = SURFACE_VARIANT,
    )

val EMOJI_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleEmojiMode(true), Icons.Outlined.Mood, LARGE, color = SECONDARY),
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

val EMOJI_BACK_KEY_ITEM =
    KeyItemC(
        center = KeyC(ToggleEmojiMode(false), Icons.Outlined.Abc, LARGE, color = PRIMARY),
        backgroundColor = SURFACE_VARIANT,
    )

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

val SPACEBAR_KEY_ITEM =
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
        widthMultiplier = 3,
    )
val SPACEBAR_SKINNY_KEY_ITEM = SPACEBAR_KEY_ITEM.copy(widthMultiplier = 1)
val SPACEBAR_DOUBLE_KEY_ITEM = SPACEBAR_KEY_ITEM.copy(widthMultiplier = 2)

val SPACEBAR_PROGRAMMING_KEY_ITEM =
    KeyItemC(
        center = KeyC(" "),
        swipeType = FOUR_WAY_CROSS,
        slideType = MOVE_CURSOR,
        swipes = mapOf(
            LEFT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_LEFT), icon = null),
            RIGHT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_RIGHT), icon = null),
            TOP to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_UP), icon = null),
            BOTTOM to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_DOWN), icon = null),
        ),
        backgroundColor = SURFACE_VARIANT,
        widthMultiplier = 3,
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

val SPACEBAR_TYPESPLIT_MIDDLE_KEY_ITEM =
    KeyItemC(
        center = KeyC(" "),
        swipeType = FOUR_WAY_CROSS,
        slideType = MOVE_CURSOR,
        swipes = mapOf(
            LEFT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_LEFT), icon = null),
            RIGHT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_RIGHT), icon = null),
            TOP to KeyC("'", color = MUTED),
            BOTTOM to KeyC(",", color = MUTED),
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
    )
val SPACEBAR_TYPESPLIT_BOTTOM_KEY_ITEM =
    SPACEBAR_TYPESPLIT_MIDDLE_KEY_ITEM.copy(
        swipeType = SwipeNWay.EIGHT_WAY,
        swipes = mapOf(
            LEFT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_LEFT), icon = null),
            RIGHT to KeyC(KeyEvent(ACTION_DOWN, KEYCODE_DPAD_RIGHT), icon = null),
            TOP to KeyC("-", color = MUTED),
            BOTTOM to KeyC(".", color = MUTED),
            BOTTOM_LEFT to KeyC("*", color = MUTED),
        ),
    )

val SPACEBAR_ALL_SYMBOLS =
    SPACEBAR_TYPESPLIT_MIDDLE_KEY_ITEM.copy(
        swipes = mapOf(
            LEFT to KeyC(",", color = MUTED),
            RIGHT to KeyC("'", color = MUTED),
            TOP to KeyC("-", color = MUTED),
            BOTTOM to KeyC(".", color = MUTED),
        ),
    )
val SPACEBAR_ALL_DIRECTIONS =
    SPACEBAR_TYPESPLIT_MIDDLE_KEY_ITEM.copy(
        swipes = mapOf(
            LEFT to KeyC("←", KeyEvent(ACTION_DOWN, KEYCODE_DPAD_LEFT), color = MUTED),
            RIGHT to KeyC("→", KeyEvent(ACTION_DOWN, KEYCODE_DPAD_RIGHT), color = MUTED),
            TOP to KeyC("↑", KeyEvent(ACTION_DOWN, KEYCODE_DPAD_UP), color = MUTED),
            BOTTOM to KeyC("↓", KeyEvent(ACTION_DOWN, KEYCODE_DPAD_DOWN), color = MUTED),
        ),
    )

val BACKSPACE_TYPESPLIT_KEY_ITEM =
    KeyItemC(
        center = KeyC(
            event = KeyEvent(ACTION_DOWN, KEYCODE_DEL),
            icon = Icons.AutoMirrored.Outlined.KeyboardBackspace,
            size = LARGE,
            color = SECONDARY,
        ),
        swipeType = FOUR_WAY_CROSS,
        slideType = DELETE,
        swipes = mapOf(
            LEFT to KeyC(DeleteWordBeforeCursor, display = null),
            RIGHT to KeyC(DeleteWordAfterCursor, display = null),
            TOP to KeyC(ToggleShiftMode(true), Icons.Outlined.ArrowDropUp, color = SECONDARY),
        ),
        widthMultiplier = 3,
        backgroundColor = SURFACE_VARIANT,
    )
val BACKSPACE_TYPESPLIT_SHIFTED_KEY_ITEM =
    BACKSPACE_TYPESPLIT_KEY_ITEM.copy(
        swipes = mapOf(
            LEFT to KeyC(DeleteWordBeforeCursor, display = null),
            RIGHT to KeyC(DeleteWordAfterCursor, display = null),
            TOP to KeyC(
                display = IconDisplay(Icons.Outlined.KeyboardCapslock),
                capsModeDisplay = IconDisplay(Icons.Outlined.Copyright),
                action = ToggleCapsLock,
                color = SECONDARY,
            ),
            BOTTOM to KeyC(ToggleShiftMode(false), Icons.Outlined.ArrowDropDown, color = SECONDARY),
        ),
    )

val SPACEBAR_FRENCH_KEY_ITEM =
    SPACEBAR_KEY_ITEM.copy(
        nextTapActions = listOf(
            ReplaceLastText(", ", trimCount = 1),
            ReplaceLastText(". "),
            ReplaceLastText(" ? "),
            ReplaceLastText(" ! ", trimCount = 3),
            ReplaceLastText(" : ", trimCount = 3),
            ReplaceLastText(" ; ", trimCount = 3),
        ),
    )

val SPACEBAR_FRENCH_SKINNY_KEY_ITEM = SPACEBAR_FRENCH_KEY_ITEM.copy(widthMultiplier = 1)

val SPACEBAR_FRENCH_TYPESPLIT_MIDDLE_KEY_ITEM =
    SPACEBAR_TYPESPLIT_MIDDLE_KEY_ITEM.copy(
        nextTapActions = listOf(
            ReplaceLastText(", ", trimCount = 1),
            ReplaceLastText(". "),
            ReplaceLastText(" ? "),
            ReplaceLastText(" ! ", trimCount = 3),
            ReplaceLastText(" : ", trimCount = 3),
            ReplaceLastText(" ; ", trimCount = 3),
        ),
    )

val SPACEBAR_FRENCH_TYPESPLIT_BOTTOM_KEY_ITEM =
    SPACEBAR_TYPESPLIT_BOTTOM_KEY_ITEM.copy(
        nextTapActions = listOf(
            ReplaceLastText(", ", trimCount = 1),
            ReplaceLastText(". "),
            ReplaceLastText(" ? "),
            ReplaceLastText(" ! ", trimCount = 3),
            ReplaceLastText(" : ", trimCount = 3),
            ReplaceLastText(" ; ", trimCount = 3),
        ),
    )

val SPACEBAR_FARSI_KEY_ITEM =
    SPACEBAR_KEY_ITEM.copy(
        nextTapActions = listOf(
            ReplaceLastText("، ", trimCount = 1),
            ReplaceLastText(". "),
            ReplaceLastText("؟ "),
            ReplaceLastText("! "),
            ReplaceLastText(": "),
            ReplaceLastText("؛ "),
        ),
    )

val SPACEBAR_FARSI_SKINNY_KEY_ITEM = SPACEBAR_FARSI_KEY_ITEM.copy(widthMultiplier = 1)

val SPACEBAR_ZERO_KEY_ITEM = SPACEBAR_KEY_ITEM.copy(longPress = CommitText("0"))
