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

val NUMERIC_KEYBOARD =
    KeyboardC(
        listOf(
            listOf(key1(), key2(), key3(), EMOJI_KEY_ITEM),
            listOf(key4(), key5(), key6(), ABC_KEY_ITEM),
            listOf(key7(), key8(), key9(), BACKSPACE_KEY_ITEM),
            listOf(key0(), SPACEBAR_SKINNY_KEY_ITEM, RETURN_KEY_ITEM),
        ),
    )

fun key1() =
    KeyItemC(
        center = KeyC("1", LARGE, color = PRIMARY),
        swipes = buildMap {
            put(BOTTOM_LEFT, KeyC("$"))
            getLocalCurrency()?.let {
                if (it !in setOf("$", "£", "€")) put(BOTTOM_RIGHT, KeyC(it))
            }
        },
    )

fun key2() =
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

fun key3() =
    KeyItemC(
        center = KeyC("3", LARGE, color = PRIMARY),
        swipes = mapOf(
            LEFT to KeyC("?"),
            BOTTOM_RIGHT to KeyC("€"),
            BOTTOM_LEFT to KeyC("£"),
            BOTTOM to KeyC("="),
        ),
    )

fun key4() =
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

fun key5() =
    KeyItemC(
        center = KeyC("5", LARGE, color = PRIMARY),
    )

fun key6() =
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

fun key7() =
    KeyItemC(
        center = KeyC("7", LARGE, color = PRIMARY),
        swipes = mapOf(
            TOP_LEFT to KeyC("~"),
            BOTTOM_RIGHT to KeyC(":"),
            BOTTOM_LEFT to KeyC("<"),
        ),
    )

fun key8() =
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

fun key9() =
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

fun key0() =
    KeyItemC(
        center = KeyC("0", LARGE, color = PRIMARY),
        widthMultiplier = 2,
    )
