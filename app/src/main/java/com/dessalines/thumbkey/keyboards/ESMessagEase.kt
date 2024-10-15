@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val KB_ES_MESSAGEASE_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("a", size = LARGE),
                    bottomLeft =
                        KeyC(
                            KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            displayText = KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            color = MUTED,
                        ),
                    bottomRight =
                        KeyC(display = KeyDisplay.TextDisplay("v"), action = CommitText("v")),
                    bottom =
                        KeyC(display = KeyDisplay.TextDisplay("á"), action = CommitText("á")),
                    right = KeyC("-", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("n", size = LARGE),
                    left = KeyC("+", color = MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("ñ"), action = CommitText("ñ")),
                    right = KeyC("!", color = MUTED),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("l"), action = CommitText("l")),
                    bottomLeft = KeyC("/", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("i", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("í"), action = CommitText("í")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("x"), action = CommitText("x")),
                    topRight = KeyC("¡", color = MUTED),
                    left = KeyC("?", color = MUTED),
                    right = KeyC("¿", color = MUTED),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("d", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("(", color = MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("ü"), action = CommitText("ü")),
                    right = KeyC(display = KeyDisplay.TextDisplay("k"), action = CommitText("k")),
                ),
                KeyItemC(
                    center = KeyC("o", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("q"), action = CommitText("q")),
                    top = KeyC(display = KeyDisplay.TextDisplay("u"), action = CommitText("u")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("p"), action = CommitText("p")),
                    right = KeyC(display = KeyDisplay.TextDisplay("b"), action = CommitText("b")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("j"), action = CommitText("j")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("h"), action = CommitText("h")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("g"), action = CommitText("g")),
                    left = KeyC(display = KeyDisplay.TextDisplay("c"), action = CommitText("c")),
                ),
                KeyItemC(
                    center = KeyC("r", size = LARGE),
                    left = KeyC(display = KeyDisplay.TextDisplay("m"), action = CommitText("m")),
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    right = KeyC(")", color = MUTED),
                    bottom =
                        KeyC(
                            ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                        ),
                    bottomLeft = KeyC("@", color = MUTED),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("t", size = LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("y"), action = CommitText("y")),
                    top = KeyC(display = KeyDisplay.TextDisplay("ú"), action = CommitText("ú")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("ó"), action = CommitText("ó")),
                    right = KeyC("*", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("e", size = LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("w"), action = CommitText("w")),
                    topRight = KeyC("'", color = MUTED),
                    topLeft = KeyC("\"", color = MUTED),
                    right = KeyC(display = KeyDisplay.TextDisplay("z"), action = CommitText("z")),
                    bottomRight = KeyC(":", color = MUTED),
                    bottom = KeyC(".", color = MUTED),
                    bottomLeft = KeyC(",", color = MUTED),
                    left =
                        KeyC(display = KeyDisplay.TextDisplay("é"), action = CommitText("é")),
                ),
                KeyItemC(
                    center = KeyC("s", size = LARGE),
                    swipeType = FOUR_WAY_DIAGONAL,
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("f"), action = CommitText("f")),
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
                    center = KeyC("A", size = LARGE),
                    bottomLeft =
                        KeyC(
                            KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            displayText = KB_ES_MESSAGEASE_CURRENCY_SYMBOL,
                            color = MUTED,
                        ),
                    bottomRight = KeyC("V"),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("Á"), action = CommitText("Á")),
                    right = KeyC("-", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("N", size = LARGE),
                    left = KeyC("+", color = MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ñ"), action = CommitText("Ñ")),
                    right = KeyC("!", color = MUTED),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("L"), action = CommitText("L")),
                    bottomLeft = KeyC("/", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("I", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("Í"), action = CommitText("Í")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("X"), action = CommitText("X")),
                    topRight = KeyC("¡", color = MUTED),
                    left = KeyC("?", color = MUTED),
                    right = KeyC("¿", color = MUTED),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("D", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("(", color = MUTED),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ü"), action = CommitText("Ü")),
                    right = KeyC(display = KeyDisplay.TextDisplay("K"), action = CommitText("K")),
                ),
                KeyItemC(
                    center = KeyC("O", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("Q"), action = CommitText("Q")),
                    top = KeyC(display = KeyDisplay.TextDisplay("U"), action = CommitText("U")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("P"), action = CommitText("P")),
                    right = KeyC(display = KeyDisplay.TextDisplay("B"), action = CommitText("B")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("J"), action = CommitText("J")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("H"), action = CommitText("H")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("G"), action = CommitText("G")),
                    left = KeyC(display = KeyDisplay.TextDisplay("C"), action = CommitText("C")),
                ),
                KeyItemC(
                    center = KeyC("R", size = LARGE),
                    left = KeyC(display = KeyDisplay.TextDisplay("M"), action = CommitText("M")),
                    bottom =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                            action = ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                            color = MUTED,
                        ),
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.KeyboardCapslock),
                            capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.Copyright),
                            action = ToggleCapsLock,
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    right = KeyC(")", color = MUTED),
                    bottomLeft = KeyC("@", color = MUTED),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("T", size = LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("Y"), action = CommitText("Y")),
                    top = KeyC(display = KeyDisplay.TextDisplay("Ú"), action = CommitText("Ú")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("Ó"), action = CommitText("Ó")),
                    right = KeyC("*", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("E", size = LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("W"), action = CommitText("W")),
                    topRight = KeyC("'", color = MUTED),
                    topLeft = KeyC("\"", color = MUTED),
                    right = KeyC(display = KeyDisplay.TextDisplay("Z"), action = CommitText("Z")),
                    bottomRight = KeyC(":", color = MUTED),
                    bottom = KeyC(".", color = MUTED),
                    bottomLeft = KeyC(",", color = MUTED),
                    left = KeyC("É"),
                ),
                KeyItemC(
                    center = KeyC("S", size = LARGE),
                    swipeType = FOUR_WAY_DIAGONAL,
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("F"), action = CommitText("F")),
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
