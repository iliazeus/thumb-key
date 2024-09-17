@file:Suppress(
    "ktlint:standard:no-wildcard-imports",
    "ktlint:standard:multiline-expression-wrapping",
)

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeDirection.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val KB_EN_THUMBKEY =
    KeyboardDefinition(
        title = "english thumb-key",
        modes =
            KeyboardDefinitionModes(
                main = kbMain(),
                shifted = kbShifted(),
                numeric = NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )

val KB_EN_THUMBKEY_MAIN = kbMain()

fun kbMain() =
    KeyboardC(
        listOf(
            listOf(keyS(), keyR(), keyO(), EMOJI_KEY_ITEM),
            listOf(keyN(), keyH(), keyA(), NUMERIC_KEY_ITEM),
            listOf(keyT(), keyI(), keyE(), BACKSPACE_KEY_ITEM),
            listOf(SPACEBAR_KEY_ITEM, RETURN_KEY_ITEM),
        ),
    )

fun kbShifted() =
    KeyboardC(
        listOf(
            listOf(keyShiftS(), keyShiftR(), keyShiftO(), EMOJI_KEY_ITEM),
            listOf(keyShiftN(), keyShiftH(), keyShiftA(), NUMERIC_KEY_ITEM),
            listOf(keyShiftT(), keyShiftI(), keyShiftE(), BACKSPACE_KEY_ITEM),
            listOf(SPACEBAR_KEY_ITEM, RETURN_KEY_ITEM),
        ),
    )

fun keyS() =
    KeyItemC(
        center = KeyC("s", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(BOTTOM_RIGHT to KeyC("w")),
    )

fun keyShiftS() =
    KeyItemC(
        center = KeyC("S", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(BOTTOM_RIGHT to KeyC("W")),
    )

fun keyR() =
    KeyItemC(
        center = KeyC("r", LARGE, color = PRIMARY),
        swipeType = TWO_WAY_VERTICAL,
        swipes = mapOf(BOTTOM to KeyC("g")),
    )

fun keyShiftR() =
    KeyItemC(
        center = KeyC("R", LARGE, color = PRIMARY),
        swipeType = TWO_WAY_VERTICAL,
        swipes = mapOf(BOTTOM to KeyC("G")),
    )

fun keyO() =
    KeyItemC(
        center = KeyC("o", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(BOTTOM_LEFT to KeyC("u")),
    )

fun keyShiftO() =
    KeyItemC(
        center = KeyC("O", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(BOTTOM_LEFT to KeyC("U")),
    )

fun keyN() =
    KeyItemC(
        center = KeyC("n", LARGE, color = PRIMARY),
        swipeType = TWO_WAY_HORIZONTAL,
        swipes = mapOf(RIGHT to KeyC("m")),
    )

fun keyShiftN() =
    KeyItemC(
        center = KeyC("N", LARGE, color = PRIMARY),
        swipeType = TWO_WAY_HORIZONTAL,
        swipes = mapOf(RIGHT to KeyC("M")),
    )

fun keyH() =
    KeyItemC(
        center = KeyC("h", LARGE, color = PRIMARY),
        swipes = mapOf(
            TOP_LEFT to KeyC("j"),
            TOP to KeyC("q"),
            TOP_RIGHT to KeyC("b"),
            RIGHT to KeyC("p"),
            BOTTOM_RIGHT to KeyC("y"),
            BOTTOM to KeyC("x"),
            BOTTOM_LEFT to KeyC("v"),
            LEFT to KeyC("k"),
        ),
    )

fun keyShiftH() =
    KeyItemC(
        center = KeyC("H", LARGE, color = PRIMARY),
        swipes = mapOf(
            TOP_LEFT to KeyC("J"),
            TOP to KeyC("Q"),
            TOP_RIGHT to KeyC("B"),
            RIGHT to KeyC("P"),
            BOTTOM_RIGHT to KeyC("Y"),
            BOTTOM to KeyC("X"),
            BOTTOM_LEFT to KeyC("V"),
            LEFT to KeyC("K"),
        ),
    )

fun keyA() =
    KeyItemC(
        center = KeyC("a", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_CROSS,
        swipes = mapOf(
            LEFT to KeyC("l"),
            TOP to KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                action = ToggleShiftMode(true),
                swipeReturnAction = ToggleCurrentWordCapitalization(true),
                color = MUTED,
            ),
            BOTTOM to KeyC(
                action = ToggleShiftMode(false),
                swipeReturnAction = ToggleCurrentWordCapitalization(false),
            ),
        ),
    )

fun keyShiftA() =
    KeyItemC(
        center = KeyC("A", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_CROSS,
        swipes = mapOf(
            LEFT to KeyC("L"),
            BOTTOM to KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                action = ToggleShiftMode(false),
                swipeReturnAction = ToggleCurrentWordCapitalization(false),
                color = MUTED,
            ),
            TOP to KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.KeyboardCapslock),
                capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.Copyright),
                action = ToggleCapsLock,
                swipeReturnAction = ToggleCurrentWordCapitalization(true),
                color = MUTED,
            ),
        ),
    )

fun keyT() =
    KeyItemC(
        center = KeyC("t", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(TOP_RIGHT to KeyC("c")),
    )

fun keyShiftT() =
    KeyItemC(
        center = KeyC("T", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(TOP_RIGHT to KeyC("C")),
    )

fun keyI() =
    KeyItemC(
        center = KeyC("i", LARGE, color = PRIMARY),
        swipes = mapOf(
            TOP to KeyC("f"),
            TOP_RIGHT to KeyC("'", color = MUTED),
            RIGHT to KeyC("z"),
            BOTTOM_RIGHT to KeyC("-", color = MUTED),
            BOTTOM to KeyC(".", color = MUTED),
            BOTTOM_LEFT to KeyC("*", color = MUTED),
        ),
    )

fun keyShiftI() =
    KeyItemC(
        center = KeyC("I", LARGE, color = PRIMARY),
        swipes = mapOf(
            TOP to KeyC("F"),
            TOP_RIGHT to KeyC("'", color = MUTED),
            RIGHT to KeyC("Z"),
            BOTTOM_RIGHT to KeyC("-", color = MUTED),
            BOTTOM to KeyC(".", color = MUTED),
            BOTTOM_LEFT to KeyC("*", color = MUTED),
        ),
    )

fun keyE() =
    KeyItemC(
        center = KeyC("e", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(TOP_LEFT to KeyC("d")),
    )

fun keyShiftE() =
    KeyItemC(
        center = KeyC("E", LARGE, color = PRIMARY),
        swipeType = FOUR_WAY_DIAGONAL,
        swipes = mapOf(TOP_LEFT to KeyC("D")),
    )
