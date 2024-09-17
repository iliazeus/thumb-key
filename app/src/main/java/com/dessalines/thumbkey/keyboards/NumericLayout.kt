@file:Suppress(
    "ktlint:standard:no-wildcard-imports",
    "ktlint:standard:multiline-expression-wrapping",
)

package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeDirection.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

open class NumericLayout : BaseLayout() {
    @Suppress("ktlint:standard:no-multi-spaces")
    open fun keyboard() =
        KeyboardC(
            listOf(
                listOf(keyEmoji(),     key1(), key2(),     key3(),      keyEmoji()),
                listOf(keyAbc(),       key4(), key5(),     key6(),      keyAbc()),
                listOf(keyBackspace(), key7(), key8(),     key9(),      keyBackspace()),
                listOf(keyReturn(),    key0(width = 2),    keySpace(),  keyReturn()),
            ),
        )

    open fun key1() =
        KeyItemC(
            center = KeyC("1", LARGE, color = PRIMARY),
            swipes = buildMap {
                put(BOTTOM_LEFT, KeyC("$"))
                getLocalCurrency()?.let {
                    if (it !in setOf("$", "£", "€")) put(BOTTOM_RIGHT, KeyC(it))
                }
            },
        )

    open fun key2() =
        KeyItemC(
            center = KeyC("2", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("`"),
                TOP to KeyC("^"),
                TOP_RIGHT to KeyC("´"),
                RIGHT to KeyC("!"),
                BOTTOM_RIGHT to KeyC("\\"),
                BOTTOM_LEFT to KeyC("/"),
                LEFT to KeyC("+"),
            ),
        )

    open fun key3() =
        KeyItemC(
            center = KeyC("3", LARGE, color = PRIMARY),
            swipes = mapOf(
                LEFT to KeyC("?"),
                BOTTOM_RIGHT to KeyC("€"),
                BOTTOM_LEFT to KeyC("£"),
                BOTTOM to KeyC("="),
            ),
        )

    open fun key4() =
        KeyItemC(
            center = KeyC("4", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("{"),
                TOP_RIGHT to KeyC("%"),
                BOTTOM_RIGHT to KeyC("_"),
                BOTTOM_LEFT to KeyC("["),
                LEFT to KeyC("("),
            ),
        )

    open fun key5() =
        KeyItemC(
            center = KeyC("5", LARGE, color = PRIMARY),
        )

    open fun key6() =
        KeyItemC(
            center = KeyC("6", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("|"),
                TOP_RIGHT to KeyC("}"),
                RIGHT to KeyC(")"),
                BOTTOM_RIGHT to KeyC("]"),
                BOTTOM_LEFT to KeyC("@"),
            ),
        )

    open fun key7() =
        KeyItemC(
            center = KeyC("7", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("~"),
                BOTTOM_RIGHT to KeyC(":"),
                BOTTOM_LEFT to KeyC("<"),
            ),
        )

    open fun key8() =
        KeyItemC(
            center = KeyC("8", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP_LEFT to KeyC("\""),
                TOP_RIGHT to KeyC("'"),
                BOTTOM_RIGHT to KeyC("-"),
                BOTTOM to KeyC("."),
                BOTTOM_LEFT to KeyC("*"),
                LEFT to KeyC(","),
            ),
        )

    open fun key9() =
        KeyItemC(
            center = KeyC("9", LARGE, color = PRIMARY),
            swipes = mapOf(
                TOP to KeyC("&"),
                TOP_RIGHT to KeyC("°"),
                BOTTOM_RIGHT to KeyC(">"),
                BOTTOM_LEFT to KeyC(";"),
                LEFT to KeyC("#"),
            ),
        )

    open fun key0(width: Int = 1) =
        KeyItemC(
            center = KeyC("0", LARGE, color = PRIMARY),
            widthMultiplier = width,
        )
}
