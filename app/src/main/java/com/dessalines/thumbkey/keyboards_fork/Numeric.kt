@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards.fork

import com.dessalines.thumbkey.keyboards.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*

val FORK_NUMERIC_KEYBOARD = NumericCtx(getLocalCurrency()).keyboard()

private data class NumericCtx(
    val localCurrency: String?,
) {
    @Suppress("ktlint:standard:no-multi-spaces")
    fun keyboard() =
        KeyboardC(
            listOf(
                listOf(kEmoji(), k1(), k2(), k3(),   kEmoji()),
                listOf(kAbc(),   k4(), k5(), k6(),   kAbc()),
                listOf(kBksp(),  k7(), k8(), k9(),   kBksp()),
                listOf(kRet(),    kWide0(),  kSpc(), kRet()),
            ),
        )

    fun kEmoji() = FORK_EMOJI_KEY_ITEM

    fun kAbc() = ABC_KEY_ITEM

    fun kBksp() = BACKSPACE_KEY_ITEM

    fun kSpc() = SPACEBAR_SKINNY_KEY_ITEM

    fun kRet() = RETURN_KEY_ITEM

    fun k1() =
        KeyItemC(
            center = KeyC("1", size = LARGE),
            bottomLeft = KeyC("$"),
            bottomRight =
                when (localCurrency) {
                    null, "$", "£", "€" -> null
                    else -> KeyC(localCurrency)
                },
        )

    fun k2() =
        KeyItemC(
            center = KeyC("2", size = LARGE),
            topLeft = KeyC("`"),
            top = KeyC("^"),
            topRight = KeyC("`"),
            right = KeyC("!"),
            bottomRight = KeyC("\\"),
            bottomLeft = KeyC("/"),
            left = KeyC("+"),
        )

    fun k3() =
        KeyItemC(
            center = KeyC("3", size = LARGE),
            left = KeyC("?"),
            bottomRight = KeyC("€"),
            bottomLeft = KeyC("£"),
            bottom = KeyC("="),
        )

    fun k4() =
        KeyItemC(
            center = KeyC("4", size = LARGE),
            topLeft = KeyC("{"),
            topRight = KeyC("%"),
            bottomRight = KeyC("_"),
            bottomLeft = KeyC("["),
            left = KeyC("("),
        )

    fun k5() =
        KeyItemC(
            center = KeyC("5", size = LARGE),
        )

    fun k6() =
        KeyItemC(
            center = KeyC("6", size = LARGE),
            topLeft = KeyC("|"),
            topRight = KeyC("}"),
            right = KeyC(")"),
            bottomRight = KeyC("]"),
            bottomLeft = KeyC("@"),
        )

    fun k7() =
        KeyItemC(
            center = KeyC("7", size = LARGE),
            topLeft = KeyC("~"),
            bottomRight = KeyC(":"),
            bottomLeft = KeyC("<"),
        )

    fun k8() =
        KeyItemC(
            center = KeyC("8", size = LARGE),
            topLeft = KeyC("\""),
            topRight = KeyC("'"),
            bottomRight = KeyC("-"),
            bottom = KeyC("."),
            bottomLeft = KeyC("*"),
            left = KeyC(","),
        )

    fun k9() =
        KeyItemC(
            center = KeyC("9", size = LARGE),
            top = KeyC("&"),
            topRight = KeyC("°"),
            bottomRight = KeyC(">"),
            bottomLeft = KeyC(";"),
            left = KeyC("#"),
        )

    fun kWide0() =
        KeyItemC(
            center = KeyC("0", size = LARGE),
            widthMultiplier = 2,
        )
}
