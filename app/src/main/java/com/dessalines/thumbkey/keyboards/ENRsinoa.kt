@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*

val KB_EN_RSINOA_MAIN =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("r", size = LARGE),
                    bottomRight = KeyC("c"),
                ),
                KeyItemC(
                    center = KeyC("s", size = LARGE),
                    bottom = KeyC("k"),
                    right = KeyC("z"),
                ),
                KeyItemC(
                    center = KeyC("i", size = LARGE),
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    bottom =
                        KeyC(
                            ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                        ),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("n", size = LARGE),
                    right = KeyC("l"),
                    bottom = KeyC("v"),
                    top = KeyC("x"),
                ),
                KeyItemC(
                    center = KeyC("o", size = LARGE),
                    topRight = KeyC("f"),
                    topLeft = KeyC("p"),
                    bottomRight = KeyC("d"),
                    bottomLeft = KeyC("g"),
                ),
                KeyItemC(
                    center = KeyC("a", size = LARGE),
                    left = KeyC("u"),
                    bottom = KeyC("y"),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("h", size = LARGE),
                    top = KeyC("j"),
                    right = KeyC("m"),
                ),
                KeyItemC(
                    center = KeyC("t", size = LARGE),
                    topRight = KeyC("w"),
                    topLeft = KeyC("b"),
                    bottomRight = KeyC(",", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("e", size = LARGE),
                    topRight = KeyC("q"),
                    topLeft = KeyC("'", color = MUTED),
                    bottom = KeyC(".", color = MUTED),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(
                SPACEBAR_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_EN_RSINOA_SHIFTED =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("R", size = LARGE),
                    bottomRight = KeyC("C"),
                ),
                KeyItemC(
                    center = KeyC("S", size = LARGE),
                    bottom = KeyC("K"),
                    right = KeyC("Z"),
                ),
                KeyItemC(
                    center = KeyC("I", size = LARGE),
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
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("N", size = LARGE),
                    right = KeyC("L"),
                    bottom = KeyC("V"),
                    top = KeyC("X"),
                ),
                KeyItemC(
                    center = KeyC("O", size = LARGE),
                    topRight = KeyC("F"),
                    topLeft = KeyC("P"),
                    bottomRight = KeyC("D"),
                    bottomLeft = KeyC("G"),
                ),
                KeyItemC(
                    center = KeyC("A", size = LARGE),
                    left = KeyC("U"),
                    bottom = KeyC("Y"),
                ),
                NUMERIC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("H", size = LARGE),
                    top = KeyC("J"),
                    right = KeyC("M"),
                ),
                KeyItemC(
                    center = KeyC("T", size = LARGE),
                    topRight = KeyC("W"),
                    topLeft = KeyC("B"),
                    bottomRight = KeyC(",", color = MUTED),
                ),
                KeyItemC(
                    center = KeyC("E", size = LARGE),
                    topRight = KeyC("Q"),
                    topLeft = KeyC("'", color = MUTED),
                    bottom = KeyC(".", color = MUTED),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(
                SPACEBAR_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )

val KB_EN_RSINOA: KeyboardDefinition =
    KeyboardDefinition(
        title = "english rsinoa",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_RSINOA_MAIN,
                shifted = KB_EN_RSINOA_SHIFTED,
                numeric = NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
