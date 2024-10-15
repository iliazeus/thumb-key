package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
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
import com.dessalines.thumbkey.utils.SwipeNWay

val KB_ES_MESSAGEASE_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("a", size = FontSizeVariant.LARGE),
                    bottomLeft =
                        KeyC(
                            KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            displayText = KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight =
                        KeyC(display = KeyDisplay.TextDisplay("v"), action = KeyAction.CommitText("v")),
                    bottom =
                        KeyC(display = KeyDisplay.TextDisplay("á"), action = KeyAction.CommitText("á")),
                    right = KeyC("-", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("n", size = FontSizeVariant.LARGE),
                    left = KeyC("+", color = ColorVariant.MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("ñ"), action = KeyAction.CommitText("ñ")),
                    right = KeyC("!", color = ColorVariant.MUTED),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("l"), action = KeyAction.CommitText("l")),
                    bottomLeft = KeyC("/", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("i", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("í"), action = KeyAction.CommitText("í")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("x"), action = KeyAction.CommitText("x")),
                    topRight = KeyC("¡", color = ColorVariant.MUTED),
                    left = KeyC("?", color = ColorVariant.MUTED),
                    right = KeyC("¿", color = ColorVariant.MUTED),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("d", size = FontSizeVariant.LARGE),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    left = KeyC("(", color = ColorVariant.MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("ü"), action = KeyAction.CommitText("ü")),
                    right = KeyC(display = KeyDisplay.TextDisplay("k"), action = KeyAction.CommitText("k")),
                ),
                KeyItemC(
                    center = KeyC("o", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("q"), action = KeyAction.CommitText("q")),
                    top = KeyC(display = KeyDisplay.TextDisplay("u"), action = KeyAction.CommitText("u")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("p"), action = KeyAction.CommitText("p")),
                    right = KeyC(display = KeyDisplay.TextDisplay("b"), action = KeyAction.CommitText("b")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("j"), action = KeyAction.CommitText("j")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("h"), action = KeyAction.CommitText("h")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("g"), action = KeyAction.CommitText("g")),
                    left = KeyC(display = KeyDisplay.TextDisplay("c"), action = KeyAction.CommitText("c")),
                ),
                KeyItemC(
                    center = KeyC("r", size = FontSizeVariant.LARGE),
                    left = KeyC(display = KeyDisplay.TextDisplay("m"), action = KeyAction.CommitText("m")),
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = KeyAction.ToggleShiftMode(true),
                            swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(true),
                            color = ColorVariant.MUTED,
                        ),
                    right = KeyC(")", color = ColorVariant.MUTED),
                    bottom =
                        KeyC(
                            KeyAction.ToggleShiftMode(false),
                            swipeReturnAction = KeyAction.ToggleCurrentWordCapitalization(false),
                        ),
                    bottomLeft = KeyC("@", color = ColorVariant.MUTED),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("t", size = FontSizeVariant.LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("y"), action = KeyAction.CommitText("y")),
                    top = KeyC(display = KeyDisplay.TextDisplay("ú"), action = KeyAction.CommitText("ú")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("ó"), action = KeyAction.CommitText("ó")),
                    right = KeyC("*", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("e", size = FontSizeVariant.LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("w"), action = KeyAction.CommitText("w")),
                    topRight = KeyC("'", color = ColorVariant.MUTED),
                    topLeft = KeyC("\"", color = ColorVariant.MUTED),
                    right = KeyC(display = KeyDisplay.TextDisplay("z"), action = KeyAction.CommitText("z")),
                    bottomRight = KeyC(":", color = ColorVariant.MUTED),
                    bottom = KeyC(".", color = ColorVariant.MUTED),
                    bottomLeft = KeyC(",", color = ColorVariant.MUTED),
                    left =
                        KeyC(display = KeyDisplay.TextDisplay("é"), action = KeyAction.CommitText("é")),
                ),
                KeyItemC(
                    center = KeyC("s", size = FontSizeVariant.LARGE),
                    swipeType = SwipeNWay.FOUR_WAY_DIAGONAL,
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("f"), action = KeyAction.CommitText("f")),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(SPACEBAR_KEY_ITEM, RETURN_KEY_ITEM),
        ),
    )

val KB_ES_MESSAGEASE_SHIFTED =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("A", size = FontSizeVariant.LARGE),
                    bottomLeft =
                        KeyC(
                            KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            displayText = KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            color = ColorVariant.MUTED,
                        ),
                    bottomRight = KeyC("V"),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("Á"), action = KeyAction.CommitText("Á")),
                    right = KeyC("-", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("N", size = FontSizeVariant.LARGE),
                    left = KeyC("+", color = ColorVariant.MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ñ"), action = KeyAction.CommitText("Ñ")),
                    right = KeyC("!", color = ColorVariant.MUTED),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("L"), action = KeyAction.CommitText("L")),
                    bottomLeft = KeyC("/", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("I", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("Í"), action = KeyAction.CommitText("Í")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("X"), action = KeyAction.CommitText("X")),
                    topRight = KeyC("¡", color = ColorVariant.MUTED),
                    left = KeyC("?", color = ColorVariant.MUTED),
                    right = KeyC("¿", color = ColorVariant.MUTED),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("D", size = FontSizeVariant.LARGE),
                    swipeType = SwipeNWay.FOUR_WAY_CROSS,
                    left = KeyC("(", color = ColorVariant.MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ü"), action = KeyAction.CommitText("Ü")),
                    right = KeyC(display = KeyDisplay.TextDisplay("K"), action = KeyAction.CommitText("K")),
                ),
                KeyItemC(
                    center = KeyC("O", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("Q"), action = KeyAction.CommitText("Q")),
                    top = KeyC(display = KeyDisplay.TextDisplay("U"), action = KeyAction.CommitText("U")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("P"), action = KeyAction.CommitText("P")),
                    right = KeyC(display = KeyDisplay.TextDisplay("B"), action = KeyAction.CommitText("B")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("J"), action = KeyAction.CommitText("J")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("H"), action = KeyAction.CommitText("H")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("G"), action = KeyAction.CommitText("G")),
                    left = KeyC(display = KeyDisplay.TextDisplay("C"), action = KeyAction.CommitText("C")),
                ),
                KeyItemC(
                    center = KeyC("R", size = FontSizeVariant.LARGE),
                    left = KeyC(display = KeyDisplay.TextDisplay("M"), action = KeyAction.CommitText("M")),
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
                    right = KeyC(")", color = ColorVariant.MUTED),
                    bottomLeft = KeyC("@", color = ColorVariant.MUTED),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("T", size = FontSizeVariant.LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("Y"), action = KeyAction.CommitText("Y")),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ú"), action = KeyAction.CommitText("Ú")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("Ó"), action = KeyAction.CommitText("Ó")),
                    right = KeyC("*", color = ColorVariant.MUTED),
                ),
                KeyItemC(
                    center = KeyC("E", size = FontSizeVariant.LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("W"), action = KeyAction.CommitText("W")),
                    topRight = KeyC("'", color = ColorVariant.MUTED),
                    topLeft = KeyC("\"", color = ColorVariant.MUTED),
                    right = KeyC(display = KeyDisplay.TextDisplay("Z"), action = KeyAction.CommitText("Z")),
                    bottomRight = KeyC(":", color = ColorVariant.MUTED),
                    bottom = KeyC(".", color = ColorVariant.MUTED),
                    bottomLeft = KeyC(",", color = ColorVariant.MUTED),
                    left = KeyC("É"),
                ),
                KeyItemC(
                    center = KeyC("S", size = FontSizeVariant.LARGE),
                    swipeType = SwipeNWay.FOUR_WAY_DIAGONAL,
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("F"), action = KeyAction.CommitText("F")),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(
                SPACEBAR_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_ES_MESSAGEASE: KeyboardDefinition =
    KeyboardDefinition(
        title = "español messagease",
        modes =
            KeyboardDefinitionModes(
                main = KB_ES_MESSAGEASE_MAIN,
                shifted = KB_ES_MESSAGEASE_SHIFTED,
                numeric = KB_ES_MESSAGEASE_NUMERIC,
            ),
    )
