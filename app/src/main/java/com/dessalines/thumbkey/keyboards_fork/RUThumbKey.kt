@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards.fork

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.keyboards.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val FORK_KB_RU_THUMBKEY: KeyboardDefinition =
    KeyboardDefinition(
        // initial whitespace to raise to the top of the list in settings
        title = " русский thumb-key double-control",
        modes =
            KeyboardDefinitionModes(
                main = RuThumbKeyCtx(shifted = false).keyboard(),
                shifted = RuThumbKeyCtx(shifted = true).keyboard(),
                numeric = FORK_NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )

private data class RuThumbKeyCtx(
    val shifted: Boolean,
) {
    @Suppress("ktlint:standard:no-multi-spaces")
    fun keyboard() =
        KeyboardC(
            listOf(
                listOf(kEmoji(), kS(), kR(), kO(), kEmoji()),
                listOf(kNum(),   kN(), kH(), kA(), kNum()),
                listOf(kBksp(),  kT(), kI(), kE(), kBksp()),
                listOf(kRet(),     kSpace(),       kRet()),
            ),
        )

    fun kEmoji() = FORK_EMOJI_KEY_ITEM

    fun kNum() = NUMERIC_KEY_ITEM

    fun kBksp() = BACKSPACE_KEY_ITEM

    fun kSpace() = SPACEBAR_KEY_ITEM.copy(longPress = CommitText("0"))

    fun kRet() = RETURN_KEY_ITEM

    fun kS() =
        KeyItemC(
            center = KeyC(sh("с"), size = LARGE),
            longPress = CommitText("1"),
            swipeType = EIGHT_WAY,
            topLeft = KeyC(sh("(", ":("), color = MUTED),
            right = KeyC(sh("щ")),
            bottomRight = KeyC(sh("й")),
            bottom = KeyC(sh("э")),
        )

    fun kR() =
        KeyItemC(
            center = KeyC(sh("р"), size = LARGE),
            longPress = CommitText("2"),
            swipeType = TWO_WAY_VERTICAL,
            bottom = KeyC(sh("х")),
        )

    fun kO() =
        KeyItemC(
            center = KeyC(sh("а"), size = LARGE),
            longPress = CommitText("3"),
            swipeType = FOUR_WAY_DIAGONAL,
            topRight = KeyC(sh(")", ":)"), color = MUTED),
            bottomLeft = KeyC(sh("ж")),
        )

    fun kN() =
        KeyItemC(
            center = KeyC(sh("н"), size = LARGE),
            longPress = CommitText("4"),
            swipeType = FOUR_WAY_CROSS,
            right = KeyC(sh("м")),
            bottom = KeyC(sh("л")),
        )

    fun kH() =
        KeyItemC(
            center = KeyC(sh("в"), size = LARGE),
            longPress = CommitText("5"),
            topLeft = KeyC(sh("я")),
            top = KeyC(sh("ы")),
            topRight = KeyC(sh("ь")),
            right = KeyC(sh("п")),
            bottomRight = KeyC(sh("у")),
            bottom = KeyC(sh("з")),
            bottomLeft = KeyC(sh("г")),
            left = KeyC(sh("к")),
        )

    fun kA() =
        KeyItemC(
            center = KeyC(sh("е"), size = LARGE),
            longPress = CommitText("6"),
            swipeType = FOUR_WAY_CROSS,
            left = KeyC(sh("ф")),
            top =
                if (!shifted) {
                    KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                        action = ToggleShiftMode(true),
                        swipeReturnAction = ToggleCurrentWordCapitalization(true),
                        color = MUTED,
                    )
                } else {
                    KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.KeyboardCapslock),
                        capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.Copyright),
                        action = ToggleCapsLock,
                        swipeReturnAction = ToggleCurrentWordCapitalization(true),
                        color = MUTED,
                    )
                },
            bottom =
                if (!shifted) {
                    KeyC(
                        ToggleShiftMode(false),
                        swipeReturnAction = ToggleCurrentWordCapitalization(false),
                    )
                } else {
                    KeyC(
                        display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                        action = ToggleShiftMode(false),
                        swipeReturnAction = ToggleCurrentWordCapitalization(false),
                        color = MUTED,
                    )
                },
        )

    fun kT() =
        KeyItemC(
            center = KeyC(sh("т"), size = LARGE),
            longPress = CommitText("7"),
            topRight = KeyC(sh("ч")),
            top = KeyC(sh("ш")),
            right = KeyC(sh("ъ")),
        )

    fun kI() =
        KeyItemC(
            center = KeyC(sh("и"), size = LARGE),
            longPress = CommitText("8"),
            top = KeyC(sh("б")),
            topLeft = KeyC("\"", color = MUTED),
            topRight = KeyC("'", color = MUTED),
            right = KeyC(sh("ц")),
            bottomRight = KeyC("-", color = MUTED),
            bottom = KeyC(".", color = MUTED),
            bottomLeft = KeyC(";", color = MUTED),
            left = KeyC(",", color = MUTED),
        )

    fun kE() =
        KeyItemC(
            center = KeyC(sh("о"), size = LARGE),
            longPress = CommitText("9"),
            topLeft = KeyC(sh("д")),
            bottom = KeyC(sh("ю")),
            right = KeyC(sh("ё")),
        )

    private fun sh(s: String) = if (shifted) s.uppercase() else s.lowercase()

    private fun <T> sh(
        a: T,
        b: T,
    ) = if (shifted) b else a
}
