package com.dessalines.thumbkey.keyboards

import android.view.KeyEvent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.automirrored.outlined.KeyboardReturn
import androidx.compose.material.icons.automirrored.outlined.KeyboardTab
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.Copyright
import androidx.compose.material.icons.outlined.KeyboardCapslock
import com.dessalines.thumbkey.utils.ColorVariant
import com.dessalines.thumbkey.utils.FontSizeVariant
import com.dessalines.thumbkey.utils.KeyAction
import com.dessalines.thumbkey.utils.KeyC
import com.dessalines.thumbkey.utils.KeyDisplay
import com.dessalines.thumbkey.utils.KeyItemC
import com.dessalines.thumbkey.utils.KeyboardC
import com.dessalines.thumbkey.utils.KeyboardDefinition
import com.dessalines.thumbkey.utils.KeyboardDefinitionModes
import com.dessalines.thumbkey.utils.KeyboardDefinitionSettings
import com.dessalines.thumbkey.utils.SlideType
import com.dessalines.thumbkey.utils.SwipeDirection
import com.dessalines.thumbkey.utils.SwipeNWay
import com.dessalines.thumbkey.utils.autoCapitalizeI
import com.dessalines.thumbkey.utils.autoCapitalizeIApostrophe
import com.dessalines.thumbkey.utils.getLocalCurrency

val EN_TYPESPLIT_SHORT_SPACEBAR_SHIFT_KEY_ITEM =
    KeyItemC(
        center =
            KeyC(
                action = KeyAction.CommitText(" "),
            ),
        swipeType = SwipeNWay.FOUR_WAY_CROSS,
        slideType = SlideType.MOVE_CURSOR,
        left =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_LEFT,
                        ),
                    ),
                display = null,
            ),
        right =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_RIGHT,
                        ),
                    ),
                display = null,
            ),
        top =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                action = KeyAction.ToggleShiftMode(true),
                swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(true),
                color = ColorVariant.MUTED,
            ),
        bottom =
            KeyC(
                action = KeyAction.ToggleShiftMode(false),
                swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(false),
            ),
        backgroundColor = ColorVariant.SURFACE_VARIANT,
        widthMultiplier = 3,
    )

val EN_TYPESPLIT_SHORT_RETURN_KEY_ITEM =
    KeyItemC(
        center =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.KeyboardReturn),
                action = KeyAction.IMECompleteAction,
                size = FontSizeVariant.LARGE,
                color = ColorVariant.SECONDARY,
            ),
        backgroundColor = ColorVariant.SURFACE_VARIANT,
        longPress = KeyAction.CommitText("\n"),
        top =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.KeyboardTab),
                action = KeyAction.CommitText("\t"),
                color = ColorVariant.MUTED,
            ),
    )

val EN_TYPESPLIT_SHORT_SPACEBAR_SHIFT_KEY_SHIFTED_ITEM =
    KeyItemC(
        center =
            KeyC(
                action = KeyAction.CommitText(" "),
            ),
        swipeType = SwipeNWay.FOUR_WAY_CROSS,
        slideType = SlideType.MOVE_CURSOR,
        left =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_LEFT,
                        ),
                    ),
                display = null,
            ),
        right =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_RIGHT,
                        ),
                    ),
                display = null,
            ),
        bottom =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                action = KeyAction.ToggleShiftMode(false),
                swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(false),
                color = ColorVariant.MUTED,
            ),
        top =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.KeyboardCapslock),
                capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.Copyright),
                action = KeyAction.ToggleCapsLock,
                swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(true),
                color = ColorVariant.MUTED,
            ),
        backgroundColor = ColorVariant.SURFACE_VARIANT,
        widthMultiplier = 3,
    )

val EN_TYPESPLIT_SHORT_SPACEBAR_ARROWS_KEY_ITEM =
    KeyItemC(
        center =
            KeyC(
                action = KeyAction.CommitText(" "),
            ),
        swipeType = SwipeNWay.FOUR_WAY_CROSS,
        slideType = SlideType.MOVE_CURSOR,
        left =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_LEFT,
                        ),
                    ),
                display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.ArrowBack),
                color = ColorVariant.MUTED,
            ),
        right =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_RIGHT,
                        ),
                    ),
                display = KeyDisplay.IconDisplay(Icons.AutoMirrored.Outlined.ArrowForward),
                color = ColorVariant.MUTED,
            ),
        top =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_UP,
                        ),
                    ),
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowUpward),
                color = ColorVariant.MUTED,
            ),
        bottom =
            KeyC(
                action =
                    KeyAction.SendEvent(
                        KeyEvent(
                            KeyEvent.ACTION_DOWN,
                            KeyEvent.KEYCODE_DPAD_DOWN,
                        ),
                    ),
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDownward),
                color = ColorVariant.MUTED,
            ),
        backgroundColor = ColorVariant.SURFACE_VARIANT,
        widthMultiplier = 3,
    )

val KB_EN_TYPESPLIT_SHORT_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC( // A
                    center =
                        KeyC(
                            action = KeyAction.CommitText("a"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("x"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("-"),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("z"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("'"),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
                KeyItemC( // E
                    center =
                        KeyC(
                            action = KeyAction.CommitText("e"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("."),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("g"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("u"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("y"),
                        ),
                ), // done
                EMOJI_KEY_ITEM,
                KeyItemC( // T
                    center =
                        KeyC(
                            action = KeyAction.CommitText("t"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("d"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText(","),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("r"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("l"),
                        ),
                ), // done
                KeyItemC( // S
                    center =
                        KeyC(
                            action = KeyAction.CommitText("s"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("*"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("b"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("c"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("\""),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
            ),
            listOf(
                KeyItemC( // i
                    center =
                        KeyC(
                            action = KeyAction.CommitText("i"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText(":"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("("),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("q"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("9"),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
                KeyItemC( // o
                    center =
                        KeyC(
                            action = KeyAction.CommitText("o"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("!"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("j"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("k"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("p"),
                        ),
                ), // done
                NUMERIC_KEY_ITEM,
                KeyItemC( // n
                    center =
                        KeyC(
                            action = KeyAction.CommitText("n"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("f"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("?"),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("w"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("m"),
                        ),
                ), // done
                KeyItemC( // h
                    center =
                        KeyC(
                            action = KeyAction.CommitText("h"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    left =
                        KeyC(
                            action = KeyAction.CommitText(";"),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText(")"),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("v"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("0"),
                            color = ColorVariant.MUTED,
                        ),
                ),
            ),
            listOf(
                BACKSPACE_KEY_ITEM,
                EN_TYPESPLIT_SHORT_SPACEBAR_SHIFT_KEY_ITEM,
                EN_TYPESPLIT_SHORT_RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_EN_TYPESPLIT_SHORT_SHIFTED =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC( // A
                    center =
                        KeyC(
                            action = KeyAction.CommitText("A"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("X"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("-"),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("Z"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("'"),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
                KeyItemC( // E
                    center =
                        KeyC(
                            action = KeyAction.CommitText("E"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("."),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("G"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("U"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("Y"),
                        ),
                ), // done
                EMOJI_KEY_ITEM,
                KeyItemC( // T
                    center =
                        KeyC(
                            action = KeyAction.CommitText("T"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("D"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText(","),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("R"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("L"),
                        ),
                ), // done
                KeyItemC( // S
                    center =
                        KeyC(
                            action = KeyAction.CommitText("S"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("*"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("B"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("C"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("\""),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
            ),
            listOf(
                KeyItemC( // i
                    center =
                        KeyC(
                            action = KeyAction.CommitText("I"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText(":"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("("),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("Q"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("9"),
                            color = ColorVariant.MUTED,
                        ),
                ), // done
                KeyItemC( // o
                    center =
                        KeyC(
                            action = KeyAction.CommitText("O"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("!"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("J"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("K"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("P"),
                        ),
                ), // done
                NUMERIC_KEY_ITEM,
                KeyItemC( // n
                    center =
                        KeyC(
                            action = KeyAction.CommitText("N"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    right =
                        KeyC(
                            action = KeyAction.CommitText("F"),
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("?"),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("W"),
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("M"),
                        ),
                ), // done
                KeyItemC( // h
                    center =
                        KeyC(
                            action = KeyAction.CommitText("H"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    left =
                        KeyC(
                            action = KeyAction.CommitText(";"),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText(")"),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("V"),
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("0"),
                            color = ColorVariant.MUTED,
                        ),
                ),
            ),
            listOf(
                BACKSPACE_KEY_ITEM,
                EN_TYPESPLIT_SHORT_SPACEBAR_SHIFT_KEY_SHIFTED_ITEM,
                EN_TYPESPLIT_SHORT_RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_EN_TYPESPLIT_SHORT_NUMERIC =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("1"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("#"),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("'"),
                            color = ColorVariant.MUTED,
                        ),
                    topRight =
                        KeyC(
                            action = KeyAction.CommitText("%"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("-"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomLeft =
                        KeyC(
                            action = KeyAction.CommitText("<"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(
                            action = KeyAction.CommitText("@"),
                            color = ColorVariant.MUTED,
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("2"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("\\"),
                            color = ColorVariant.MUTED,
                        ),
                    topRight =
                        KeyC(
                            action = KeyAction.CommitText("´"),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText("."),
                            color = ColorVariant.MUTED,
                        ),
                    bottomLeft =
                        KeyC(
                            action = KeyAction.CommitText("="),
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(
                            action = KeyAction.CommitText("+"),
                            color = ColorVariant.MUTED,
                        ),
                ),
                EMOJI_KEY_ITEM,
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("3"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("`"),
                            color = ColorVariant.MUTED,
                        ),
                    topRight =
                        KeyC(
                            action = KeyAction.CommitText("/"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText(","),
                            color = ColorVariant.MUTED,
                        ),
                    bottomLeft =
                        KeyC(
                            action = KeyAction.CommitText("_"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(
                            action = KeyAction.CommitText("|"),
                            color = ColorVariant.MUTED,
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("4"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("^"),
                            color = ColorVariant.MUTED,
                        ),
                    top =
                        KeyC(
                            action = KeyAction.CommitText("\""),
                            color = ColorVariant.MUTED,
                        ),
                    topRight =
                        KeyC(
                            action = KeyAction.CommitText("~"),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText("*"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomLeft =
                        KeyC(
                            action = KeyAction.CommitText("&"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(
                            action = KeyAction.CommitText(">"),
                            color = ColorVariant.MUTED,
                        ),
                ),
            ),
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("5"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("{"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText("("),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText(":"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomLeft =
                        KeyC(
                            action = KeyAction.CommitText("["),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("9"),
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("6"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText("!"),
                            color = ColorVariant.MUTED,
                        ),
                ),
                ABC_KEY_ITEM,
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("7"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    swipes =
                        buildMap {
                            put(
                                SwipeDirection.TOP_LEFT,
                                KeyC(
                                    action = KeyAction.CommitText("$"),
                                    color = ColorVariant.MUTED,
                                ),
                            )
                            put(
                                SwipeDirection.TOP_RIGHT,
                                KeyC(
                                    action = KeyAction.CommitText("€"),
                                    color = ColorVariant.MUTED,
                                ),
                            )
                            put(
                                SwipeDirection.LEFT,
                                KeyC(
                                    action = KeyAction.CommitText("?"),
                                    color = ColorVariant.MUTED,
                                ),
                            )
                            put(
                                SwipeDirection.BOTTOM_LEFT,
                                KeyC(
                                    action = KeyAction.CommitText("£"),
                                    color = ColorVariant.MUTED,
                                ),
                            )
                            getLocalCurrency()?.let {
                                if (it !in setOf("$", "£", "€")) {
                                    put(
                                        SwipeDirection.BOTTOM_RIGHT,
                                        KeyC(
                                            action = KeyAction.CommitText(it),
                                            color = ColorVariant.MUTED,
                                        ),
                                    )
                                }
                            }
                        },
                ),
                KeyItemC(
                    center =
                        KeyC(
                            action = KeyAction.CommitText("8"),
                            size = FontSizeVariant.LARGE,
                            color = ColorVariant.PRIMARY,
                        ),
                    topRight =
                        KeyC(
                            action = KeyAction.CommitText("}"),
                            color = ColorVariant.MUTED,
                        ),
                    right =
                        KeyC(
                            action = KeyAction.CommitText(")"),
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(
                            action = KeyAction.CommitText("]"),
                            color = ColorVariant.MUTED,
                        ),
                    topLeft =
                        KeyC(
                            action = KeyAction.CommitText("°"),
                            color = ColorVariant.MUTED,
                        ),
                    left =
                        KeyC(
                            action = KeyAction.CommitText(";"),
                            color = ColorVariant.MUTED,
                        ),
                    bottom =
                        KeyC(
                            action = KeyAction.CommitText("0"),
                        ),
                ),
            ),
            listOf(
                BACKSPACE_KEY_ITEM,
                EN_TYPESPLIT_SHORT_SPACEBAR_ARROWS_KEY_ITEM,
                EN_TYPESPLIT_SHORT_RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_EN_TYPESPLIT_SHORT: KeyboardDefinition =
    KeyboardDefinition(
        title = "english type-split short",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_TYPESPLIT_SHORT_MAIN,
                shifted = KB_EN_TYPESPLIT_SHORT_SHIFTED,
                numeric = KB_EN_TYPESPLIT_SHORT_NUMERIC,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
