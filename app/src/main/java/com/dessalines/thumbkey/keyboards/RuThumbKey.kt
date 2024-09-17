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

val KB_RU_THUMBKEY =
    KeyboardDefinition(
        title = "русский thumb-key",
        modes = KeyboardDefinitionModes(
            main = RuThumbKeyLayout().keyboard(),
            shifted = RuThumbKeyShiftedLayout().keyboard(),
            numeric = NumericLayout().keyboard(),
        ),
    )

open class RuThumbKeyLayout : EnThumbKeyLayout() {
    override fun keyS() =
        KeyItemC(
            center = KeyC("с", LARGE, color = PRIMARY),
            swipes = mapOf(
                RIGHT to KeyC("щ"),
                BOTTOM_RIGHT to KeyC("й"),
                BOTTOM to KeyC("э"),
            ),
        )

    override fun keyR() =
        KeyItemC(
            center = KeyC("р", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_VERTICAL,
            swipes = mapOf(
                BOTTOM to KeyC("х"),
            ),
        )

    override fun keyO() =
        KeyItemC(
            center = KeyC("а", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(
                BOTTOM_LEFT to KeyC("ж"),
            ),
        )

    override fun keyN() =
        KeyItemC(
            center = KeyC("н", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                RIGHT to KeyC("м"),
                BOTTOM to KeyC("л"),
            ),
        )

    override fun keyH() =
        KeyItemC(
            center = KeyC("в", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("я"),
                TOP to KeyC("ы"),
                TOP_RIGHT to KeyC("ь"),
                RIGHT to KeyC("п"),
                BOTTOM_RIGHT to KeyC("у"),
                BOTTOM to KeyC("з"),
                BOTTOM_LEFT to KeyC("г"),
                LEFT to KeyC("к"),
            ),
        )

    override fun keyA() =
        KeyItemC(
            center = KeyC("е", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                LEFT to KeyC("ф"),
                TOP to KeyC(
                    action = ToggleShiftMode(true),
                    swipeReturnAction = ToggleCurrentWordCapitalization(true),
                    icon = Icons.Outlined.ArrowDropUp,
                    color = MUTED,
                ),
                BOTTOM to KeyC(
                    action = ToggleShiftMode(false),
                    swipeReturnAction = ToggleCurrentWordCapitalization(false),
                    icon = Icons.Outlined.ArrowDropDown,
                    color = MUTED,
                ),
            ),
        )

    override fun keyT() =
        KeyItemC(
            center = KeyC("т", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_RIGHT to KeyC("ч"),
                TOP to KeyC("ш"),
                RIGHT to KeyC("ъ"),
            ),
        )

    override fun keyI() =
        KeyItemC(
            center = KeyC("и", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP to KeyC("б"),
                RIGHT to KeyC("ц"),
                TOP_LEFT to KeyC("\"", color = MUTED),
                TOP_RIGHT to KeyC("'", color = MUTED),
                BOTTOM_RIGHT to KeyC("-", color = MUTED),
                BOTTOM to KeyC(".", color = MUTED),
                BOTTOM_LEFT to KeyC("*", color = MUTED),
                LEFT to KeyC(",", color = MUTED),
            ),
        )

    override fun keyE() =
        KeyItemC(
            center = KeyC("о", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("д"),
                BOTTOM to KeyC("ю"),
                RIGHT to KeyC("ё"),
            ),
        )
}

open class RuThumbKeyShiftedLayout : RuThumbKeyLayout() {
    override fun keyS() =
        KeyItemC(
            center = KeyC("С", LARGE, color = PRIMARY),
            swipes = mapOf(
                RIGHT to KeyC("Щ"),
                BOTTOM_RIGHT to KeyC("Й"),
                BOTTOM to KeyC("Э"),
            ),
        )

    override fun keyR() =
        KeyItemC(
            center = KeyC("Р", LARGE, color = PRIMARY),
            swipeType = TWO_WAY_VERTICAL,
            swipes = mapOf(
                BOTTOM to KeyC("Х"),
            ),
        )

    override fun keyO() =
        KeyItemC(
            center = KeyC("А", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_DIAGONAL,
            swipes = mapOf(
                BOTTOM_LEFT to KeyC("Ж"),
            ),
        )

    override fun keyN() =
        KeyItemC(
            center = KeyC("Н", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                RIGHT to KeyC("М"),
                BOTTOM to KeyC("Л"),
            ),
        )

    override fun keyH() =
        KeyItemC(
            center = KeyC("В", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("Я"),
                TOP to KeyC("Ы"),
                TOP_RIGHT to KeyC("Ь"),
                RIGHT to KeyC("П"),
                BOTTOM_RIGHT to KeyC("У"),
                BOTTOM to KeyC("З"),
                BOTTOM_LEFT to KeyC("Г"),
                LEFT to KeyC("К"),
            ),
        )

    override fun keyA() =
        KeyItemC(
            center = KeyC("Е", LARGE, color = PRIMARY),
            swipeType = FOUR_WAY_CROSS,
            swipes = mapOf(
                LEFT to KeyC("Ф"),
                TOP to KeyC(
                    action = ToggleCapsLock,
                    swipeReturnAction = ToggleCurrentWordCapitalization(true),
                    icon = Icons.Outlined.KeyboardCapslock,
                    capsModeIcon = Icons.Outlined.Copyright,
                    color = MUTED,
                ),
                BOTTOM to KeyC(
                    action = ToggleShiftMode(false),
                    swipeReturnAction = ToggleCurrentWordCapitalization(false),
                    icon = Icons.Outlined.ArrowDropDown,
                    color = MUTED,
                ),
            ),
        )

    override fun keyT() =
        KeyItemC(
            center = KeyC("Т", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_RIGHT to KeyC("Ч"),
                TOP to KeyC("Ш"),
                RIGHT to KeyC("Ъ"),
            ),
        )

    override fun keyI() =
        KeyItemC(
            center = KeyC("И", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP to KeyC("Б"),
                RIGHT to KeyC("Ц"),
                TOP_LEFT to KeyC("\"", color = MUTED),
                TOP_RIGHT to KeyC("'", color = MUTED),
                BOTTOM_RIGHT to KeyC("-", color = MUTED),
                BOTTOM to KeyC(".", color = MUTED),
                BOTTOM_LEFT to KeyC("*", color = MUTED),
                LEFT to KeyC(",", color = MUTED),
            ),
        )

    override fun keyE() =
        KeyItemC(
            center = KeyC("О", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("Д"),
                BOTTOM to KeyC("Ю"),
                RIGHT to KeyC("Ё"),
            ),
        )
}
