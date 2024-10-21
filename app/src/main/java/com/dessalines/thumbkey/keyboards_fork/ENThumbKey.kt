@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards.fork

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.keyboards.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*

val FORK_KB_EN_THUMBKEY: KeyboardDefinition =
    KeyboardDefinition(
        // initial whitespace to raise to the top of the list in settings
        title = " english thumb-key double-control",
        modes =
            KeyboardDefinitionModes(
                main = EnThumbKeyCtx(shifted = false).keyboard(),
                shifted = EnThumbKeyCtx(shifted = true).keyboard(),
                numeric = FORK_NUMERIC_KEYBOARD,
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )

private data class EnThumbKeyCtx(
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
            center = KeyC(sh("s"), size = LARGE),
            longPress = CommitText("1"),
            topLeft = KeyC(sh("(", ":("), color = MUTED),
            bottomRight = KeyC(sh("w")),
        )

    fun kR() =
        KeyItemC(
            center = KeyC(sh("r"), size = LARGE),
            longPress = CommitText("2"),
            bottom = KeyC(sh("g")),
        )

    fun kO() =
        KeyItemC(
            center = KeyC(sh("o"), size = LARGE),
            longPress = CommitText("3"),
            topRight = KeyC(sh(")", ":)"), color = MUTED),
            bottomLeft = KeyC(sh("u")),
        )

    fun kN() =
        KeyItemC(
            center = KeyC(sh("n"), size = LARGE),
            longPress = CommitText("4"),
            right = KeyC(sh("m")),
        )

    fun kH() =
        KeyItemC(
            center = KeyC(sh("h"), size = LARGE),
            longPress = CommitText("5"),
            topLeft = KeyC(sh("j")),
            top = KeyC(sh("q")),
            topRight = KeyC(sh("b")),
            right = KeyC(sh("p")),
            bottomRight = KeyC(sh("y")),
            bottom = KeyC(sh("x")),
            bottomLeft = KeyC(sh("v")),
            left = KeyC(sh("k")),
        )

    fun kA() =
        KeyItemC(
            center = KeyC(sh("a"), size = LARGE),
            longPress = CommitText("6"),
            left = KeyC(sh("l")),
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
            center = KeyC(sh("t"), size = LARGE),
            longPress = CommitText("7"),
            topRight = KeyC(sh("c")),
        )

    fun kI() =
        KeyItemC(
            center = KeyC(sh("i"), size = LARGE),
            longPress = CommitText("8"),
            top = KeyC(sh("f")),
            topLeft = KeyC("\"", color = MUTED),
            topRight = KeyC("'", color = MUTED),
            right = KeyC(sh("z")),
            bottomRight = KeyC("-", color = MUTED),
            bottom = KeyC(".", color = MUTED),
            bottomLeft = KeyC(";", color = MUTED),
            left = KeyC(",", color = MUTED),
        )

    fun kE() =
        KeyItemC(
            center = KeyC(sh("e"), size = LARGE),
            longPress = CommitText("9"),
            topLeft = KeyC(sh("d")),
        )

    private fun sh(s: String) = if (shifted) s.uppercase() else s.lowercase()

    private fun <T> sh(
        a: T,
        b: T,
    ) = if (shifted) b else a
}
