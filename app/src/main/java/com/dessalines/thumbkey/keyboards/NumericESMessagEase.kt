@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

// this val is so we can can use mapOf in the key with currency symbol
val KB_ES_MESSAGEASE_CURRENCY_SYMBOL: String =
    getLocalCurrency()?.let {
        if (it !in setOf("$", "£", "€")) {
            it
        } else {
            "$"
        }
    }!!

val KB_ES_MESSAGEASE_NUMERIC =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("1", size = LARGE),
                    right = KeyC(display = KeyDisplay.TextDisplay("-"), action = CommitText("-")),
                    bottomLeft = KeyC(KB_ES_MESSAGEASE_CURRENCY_SYMBOL),
                ),
                KeyItemC(
                    center = KeyC("2", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("`"), action = CommitText("`")),
                    top = KeyC(display = KeyDisplay.TextDisplay("^"), action = CommitText("^")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("´"), action = CommitText("´")),
                    right = KeyC(display = KeyDisplay.TextDisplay("!"), action = CommitText("!")),
                    bottomRight = KeyC("\\"),
                    bottomLeft = KeyC("/"),
                    left = KeyC(display = KeyDisplay.TextDisplay("+"), action = CommitText("+")),
                ),
                KeyItemC(
                    center = KeyC("3", size = LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("¡"), action = CommitText("¡")),
                    left = KeyC(display = KeyDisplay.TextDisplay("?"), action = CommitText("?")),
                    right = KeyC(display = KeyDisplay.TextDisplay("¿"), action = CommitText("¿")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("€"), action = CommitText("€")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("£"), action = CommitText("£")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("="), action = CommitText("=")),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("4", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("{"), action = CommitText("{")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("%"), action = CommitText("%")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("_"), action = CommitText("_")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("["), action = CommitText("[")),
                    left = KeyC(display = KeyDisplay.TextDisplay("("), action = CommitText("(")),
                ),
                KeyItemC(
                    center = KeyC("5", size = LARGE),
                    top = KeyC("¬"),
                ),
                KeyItemC(
                    center = KeyC("6", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("|"), action = CommitText("|")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("}"), action = CommitText("}")),
                    right = KeyC(display = KeyDisplay.TextDisplay(")"), action = CommitText(")")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("]"), action = CommitText("]")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("@"), action = CommitText("@")),
                ),
                ABC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("7", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("~"), action = CommitText("~")),
                    top = KeyC(display = KeyDisplay.TextDisplay("¨"), action = CommitText("¨")),
                    left = KeyC(display = KeyDisplay.TextDisplay("<"), action = CommitText("<")),
                    right = KeyC(display = KeyDisplay.TextDisplay("*"), action = CommitText("*")),
                ),
                KeyItemC(
                    center = KeyC("8", size = LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("\""), action = CommitText("\"")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("'"), action = CommitText("'")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay(":"), action = CommitText(":")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("."), action = CommitText(".")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay(","), action = CommitText(",")),
                ),
                KeyItemC(
                    center = KeyC("9", size = LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("&"), action = CommitText("&")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("°"), action = CommitText("°")),
                    right = KeyC(display = KeyDisplay.TextDisplay(">"), action = CommitText(">")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay(";"), action = CommitText(";")),
                    left = KeyC(display = KeyDisplay.TextDisplay("#"), action = CommitText("#")),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("0", size = LARGE),
                    widthMultiplier = 2,
                ),
                SPACEBAR_SKINNY_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )
