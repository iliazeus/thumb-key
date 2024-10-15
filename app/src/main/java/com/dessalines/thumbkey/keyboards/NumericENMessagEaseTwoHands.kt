package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.ColorVariant
import com.dessalines.thumbkey.utils.FontSizeVariant
import com.dessalines.thumbkey.utils.KeyAction
import com.dessalines.thumbkey.utils.KeyC
import com.dessalines.thumbkey.utils.KeyItemC
import com.dessalines.thumbkey.utils.KeyboardC
import com.dessalines.thumbkey.utils.SwipeDirection
import com.dessalines.thumbkey.utils.getLocalCurrency

val KB_EN_MESSAGEASE_TWO_HANDS_NUMERIC =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("1", size = FontSizeVariant.LARGE),
                    swipes =
                        buildMap {
                            put(
                                SwipeDirection.BOTTOM_LEFT,
                                KeyC(
                                    KeyAction.CommitText("$"),
                                ),
                            )
                            put(
                                SwipeDirection.RIGHT,
                                KeyC(
                                    KeyAction.CommitText("-"),
                                ),
                            )
                            getLocalCurrency()?.let {
                                if (it !in setOf("$", "£", "€")) {
                                    put(
                                        SwipeDirection.BOTTOM_RIGHT,
                                        KeyC(
                                            KeyAction.CommitText(it),
                                        ),
                                    )
                                }
                            }
                        },
                ),
                KeyItemC(
                    center = KeyC("2", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("`"),
                        ),
                    top =
                        KeyC(
                            KeyAction.CommitText("^"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("´"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText("!"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("\\"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("/"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("+"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("3", size = FontSizeVariant.LARGE),
                    left =
                        KeyC(
                            KeyAction.CommitText("?"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("€"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("£"),
                        ),
                    bottom =
                        KeyC(
                            KeyAction.CommitText("="),
                        ),
                ),
                EMOJI_KEY_ITEM,
                KeyItemC(
                    center = KeyC("1", size = FontSizeVariant.LARGE),
                    swipes =
                        buildMap {
                            put(
                                SwipeDirection.BOTTOM_LEFT,
                                KeyC(
                                    KeyAction.CommitText("$"),
                                ),
                            )
                            put(
                                SwipeDirection.RIGHT,
                                KeyC(
                                    KeyAction.CommitText("-"),
                                ),
                            )
                            getLocalCurrency()?.let {
                                if (it !in setOf("$", "£", "€")) {
                                    put(
                                        SwipeDirection.BOTTOM_RIGHT,
                                        KeyC(
                                            KeyAction.CommitText(it),
                                        ),
                                    )
                                }
                            }
                        },
                ),
                KeyItemC(
                    center = KeyC("2", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("`"),
                        ),
                    top =
                        KeyC(
                            KeyAction.CommitText("^"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("´"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText("!"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("\\"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("/"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("+"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("3", size = FontSizeVariant.LARGE),
                    left =
                        KeyC(
                            KeyAction.CommitText("?"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("€"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("£"),
                        ),
                    bottom =
                        KeyC(
                            KeyAction.CommitText("="),
                        ),
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC("4", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("{"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("%"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("_"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("["),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("("),
                        ),
                ),
                KeyItemC(
                    center = KeyC("5", size = FontSizeVariant.LARGE),
                    top =
                        KeyC(
                            KeyAction.CommitText("¬"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("6", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("|"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("}"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText(")"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("]"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("@"),
                        ),
                ),
                ABC_KEY_ITEM,
                KeyItemC(
                    center = KeyC("4", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("{"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("%"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("_"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("["),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("("),
                        ),
                ),
                KeyItemC(
                    center = KeyC("5", size = FontSizeVariant.LARGE),
                    top =
                        KeyC(
                            KeyAction.CommitText("¬"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("6", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("|"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("}"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText(")"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText("]"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("@"),
                        ),
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC("7", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("~"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("<"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText("*"),
                        ),
                    bottomRight = KeyC("\t", displayText = "⇥"),
                ),
                KeyItemC(
                    center = KeyC("8", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("\""),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("'"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText(":"),
                        ),
                    bottom =
                        KeyC(
                            KeyAction.CommitText("."),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText(","),
                        ),
                ),
                KeyItemC(
                    center = KeyC("9", size = FontSizeVariant.LARGE),
                    top =
                        KeyC(
                            KeyAction.CommitText("&"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("°"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText(">"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText(";"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("#"),
                        ),
                ),
                BACKSPACE_KEY_ITEM,
                KeyItemC(
                    center = KeyC("7", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("~"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("<"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText("*"),
                        ),
                    bottomRight = KeyC("\t", displayText = "⇥"),
                ),
                KeyItemC(
                    center = KeyC("8", size = FontSizeVariant.LARGE),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("\""),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("'"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText(":"),
                        ),
                    bottom =
                        KeyC(
                            KeyAction.CommitText("."),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText(","),
                        ),
                ),
                KeyItemC(
                    center = KeyC("9", size = FontSizeVariant.LARGE),
                    top =
                        KeyC(
                            KeyAction.CommitText("&"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("°"),
                        ),
                    right =
                        KeyC(
                            KeyAction.CommitText(">"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText(";"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText("#"),
                        ),
                ),
            ),
            listOf(
                KeyItemC(
                    center = KeyC("0", size = FontSizeVariant.LARGE),
                    widthMultiplier = 2,
                ),
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText(" "),
                        ),
                    nextTapActions =
                        listOf(
                            KeyAction.ReplaceLastText(". ", trimCount = 1),
                            KeyAction.ReplaceLastText(", "),
                            KeyAction.ReplaceLastText("? "),
                            KeyAction.ReplaceLastText("! "),
                            KeyAction.ReplaceLastText(": "),
                        ),
                    backgroundColor = ColorVariant.SURFACE_VARIANT,
                ),
                RETURN_KEY_ITEM,
                KeyItemC(
                    center = KeyC("0", size = FontSizeVariant.LARGE),
                    widthMultiplier = 2,
                ),
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText(" "),
                        ),
                    nextTapActions =
                        listOf(
                            KeyAction.ReplaceLastText(". ", trimCount = 1),
                            KeyAction.ReplaceLastText(", "),
                            KeyAction.ReplaceLastText("? "),
                            KeyAction.ReplaceLastText("! "),
                            KeyAction.ReplaceLastText(": "),
                        ),
                    backgroundColor = ColorVariant.SURFACE_VARIANT,
                ),
            ),
        ),
    )
