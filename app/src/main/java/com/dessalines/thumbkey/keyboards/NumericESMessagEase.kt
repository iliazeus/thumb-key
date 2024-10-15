package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.FontSizeVariant
import com.dessalines.thumbkey.utils.KeyAction
import com.dessalines.thumbkey.utils.KeyC
import com.dessalines.thumbkey.utils.KeyDisplay
import com.dessalines.thumbkey.utils.KeyItemC
import com.dessalines.thumbkey.utils.KeyboardC
import com.dessalines.thumbkey.utils.getLocalCurrency

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
                    center = KeyC("1", size = FontSizeVariant.LARGE),
                    right = KeyC(display = KeyDisplay.TextDisplay("-"), action = KeyAction.CommitText("-")),
                    bottomLeft = KeyC(KB_ES_MESSAGEASE_CURRENCY_SYMBOL),
                ),
                KeyItemC(
                    center = KeyC("2", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("`"), action = KeyAction.CommitText("`")),
                    top = KeyC(display = KeyDisplay.TextDisplay("^"), action = KeyAction.CommitText("^")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("´"), action = KeyAction.CommitText("´")),
                    right = KeyC(display = KeyDisplay.TextDisplay("!"), action = KeyAction.CommitText("!")),
                    bottomRight = KeyC("\\"),
                    bottomLeft = KeyC("/"),
                    left = KeyC(display = KeyDisplay.TextDisplay("+"), action = KeyAction.CommitText("+")),
                ),
                KeyItemC(
                    center = KeyC("3", size = FontSizeVariant.LARGE),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("¡"), action = KeyAction.CommitText("¡")),
                    left = KeyC(display = KeyDisplay.TextDisplay("?"), action = KeyAction.CommitText("?")),
                    right = KeyC(display = KeyDisplay.TextDisplay("¿"), action = KeyAction.CommitText("¿")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("€"), action = KeyAction.CommitText("€")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("£"), action = KeyAction.CommitText("£")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("="), action = KeyAction.CommitText("=")),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("4", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("{"), action = KeyAction.CommitText("{")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("%"), action = KeyAction.CommitText("%")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("_"), action = KeyAction.CommitText("_")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("["), action = KeyAction.CommitText("[")),
                    left = KeyC(display = KeyDisplay.TextDisplay("("), action = KeyAction.CommitText("(")),
                ),
                KeyItemC(
                    center = KeyC("5", size = FontSizeVariant.LARGE),
                    top = KeyC("¬"),
                ),
                KeyItemC(
                    center = KeyC("6", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("|"), action = KeyAction.CommitText("|")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("}"), action = KeyAction.CommitText("}")),
                    right = KeyC(display = KeyDisplay.TextDisplay(")"), action = KeyAction.CommitText(")")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay("]"), action = KeyAction.CommitText("]")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay("@"), action = KeyAction.CommitText("@")),
                ),
                ABC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("7", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("~"), action = KeyAction.CommitText("~")),
                    top = KeyC(display = KeyDisplay.TextDisplay("¨"), action = KeyAction.CommitText("¨")),
                    left = KeyC(display = KeyDisplay.TextDisplay("<"), action = KeyAction.CommitText("<")),
                    right = KeyC(display = KeyDisplay.TextDisplay("*"), action = KeyAction.CommitText("*")),
                ),
                KeyItemC(
                    center = KeyC("8", size = FontSizeVariant.LARGE),
                    topLeft = KeyC(display = KeyDisplay.TextDisplay("\""), action = KeyAction.CommitText("\"")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("'"), action = KeyAction.CommitText("'")),
                    bottomRight = KeyC(display = KeyDisplay.TextDisplay(":"), action = KeyAction.CommitText(":")),
                    bottom = KeyC(display = KeyDisplay.TextDisplay("."), action = KeyAction.CommitText(".")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay(","), action = KeyAction.CommitText(",")),
                ),
                KeyItemC(
                    center = KeyC("9", size = FontSizeVariant.LARGE),
                    top = KeyC(display = KeyDisplay.TextDisplay("&"), action = KeyAction.CommitText("&")),
                    topRight = KeyC(display = KeyDisplay.TextDisplay("°"), action = KeyAction.CommitText("°")),
                    right = KeyC(display = KeyDisplay.TextDisplay(">"), action = KeyAction.CommitText(">")),
                    bottomLeft = KeyC(display = KeyDisplay.TextDisplay(";"), action = KeyAction.CommitText(";")),
                    left = KeyC(display = KeyDisplay.TextDisplay("#"), action = KeyAction.CommitText("#")),
                ),
                BACKSPACE_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("0", size = FontSizeVariant.LARGE),
                    widthMultiplier = 2,
                ),
                SPACEBAR_SKINNY_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )
