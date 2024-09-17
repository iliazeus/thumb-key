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
        title = "english thumb-key double-control",
        modes =
            KeyboardDefinitionModes(
                main = EnThumbKeyLayout().keyboard(),
                shifted = EnThumbKeyShiftedLayout().keyboard(),
                numeric = NumericLayout().keyboard(),
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )

open class EnThumbKeyLayout : BaseLayout() {
    @Suppress("ktlint:standard:no-multi-spaces")
    open fun keyboard() =
        KeyboardC(
            listOf(
                listOf(keyEmoji(),     keyS(), keyR(), keyO(), keyEmoji()),
                listOf(keyNum(),       keyN(), keyH(), keyA(), keyNum()),
                listOf(keyBackspace(), keyT(), keyI(), keyE(), keyBackspace()),
                listOf(keyReturn(),    keySpace(width = 3),    keyReturn()),
            ),
        )

    open fun keyS() =
        KeyItemC(
            center = KeyC("s", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(BOTTOM_RIGHT to KeyC("w")),
        )

    open fun keyR() =
        KeyItemC(
            center = KeyC("r", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_VERTICAL,
            swipes = mapOf(BOTTOM to KeyC("g")),
        )

    open fun keyO() =
        KeyItemC(
            center = KeyC("o", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(BOTTOM_LEFT to KeyC("u")),
        )

    open fun keyN() =
        KeyItemC(
            center = KeyC("n", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_HORIZONTAL,
            swipes = mapOf(RIGHT to KeyC("m")),
        )

    open fun keyH() =
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

    open fun keyA() =
        KeyItemC(
            center = KeyC("a", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                LEFT to KeyC("l"),
                TOP to KeyC(
                    action = ToggleShiftMode(true),
                    icon = Icons.Outlined.ArrowDropUp,
                    swipeReturnAction = ToggleCurrentWordCapitalization(true),
                    color = MUTED,
                ),
                BOTTOM to KeyC(
                    action = ToggleShiftMode(false),
                    swipeReturnAction = ToggleCurrentWordCapitalization(false),
                ),
            ),
        )

    open fun keyT() =
        KeyItemC(
            center = KeyC("t", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(TOP_RIGHT to KeyC("c")),
        )

    open fun keyI() =
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

    open fun keyE() =
        KeyItemC(
            center = KeyC("e", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(TOP_LEFT to KeyC("d")),
        )
}

open class EnThumbKeyShiftedLayout : EnThumbKeyLayout() {
    override fun keyS() =
        KeyItemC(
            center = KeyC("S", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(BOTTOM_RIGHT to KeyC("W")),
        )

    override fun keyR() =
        KeyItemC(
            center = KeyC("R", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_VERTICAL,
            swipes = mapOf(BOTTOM to KeyC("G")),
        )

    override fun keyO() =
        KeyItemC(
            center = KeyC("O", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(BOTTOM_LEFT to KeyC("U")),
        )

    override fun keyN() =
        KeyItemC(
            center = KeyC("N", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_HORIZONTAL,
            swipes = mapOf(RIGHT to KeyC("M")),
        )

    override fun keyH() =
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

    override fun keyA() =
        KeyItemC(
            center = KeyC("A", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                LEFT to KeyC("L"),
                BOTTOM to KeyC(
                    action = ToggleShiftMode(false),
                    icon = Icons.Outlined.ArrowDropDown,
                    swipeReturnAction = ToggleCurrentWordCapitalization(false),
                    color = MUTED,
                ),
                TOP to KeyC(
                    action = ToggleCapsLock,
                    icon = Icons.Outlined.KeyboardCapslock,
                    capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.Copyright),
                    swipeReturnAction = ToggleCurrentWordCapitalization(true),
                    color = MUTED,
                ),
            ),
        )

    override fun keyT() =
        KeyItemC(
            center = KeyC("T", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(TOP_RIGHT to KeyC("C")),
        )

    override fun keyI() =
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

    override fun keyE() =
        KeyItemC(
            center = KeyC("E", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(TOP_LEFT to KeyC("D")),
        )
}
