package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.FontSizeVariant
import com.dessalines.thumbkey.utils.KeyAction
import com.dessalines.thumbkey.utils.KeyC
import com.dessalines.thumbkey.utils.KeyItemC
import com.dessalines.thumbkey.utils.KeyboardC
import com.dessalines.thumbkey.utils.SwipeDirection
import com.dessalines.thumbkey.utils.getLocalCurrency

val NUMERIC_KEYBOARD =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("1"),
                            size = FontSizeVariant.LARGE,
                        ),
                    swipes =
                        buildMap {
                            put(
                                SwipeDirection.BOTTOM_LEFT,
                                KeyC(
                                    KeyAction.CommitText("$"),
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
                    center =
                        KeyC(
                            KeyAction.CommitText("2"),
                            size = FontSizeVariant.LARGE,
                        ),
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
                    center =
                        KeyC(
                            KeyAction.CommitText("3"),
                            size = FontSizeVariant.LARGE,
                        ),
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
            ),
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("4"),
                            size = FontSizeVariant.LARGE,
                        ),
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
                    center =
                        KeyC(
                            KeyAction.CommitText("5"),
                            size = FontSizeVariant.LARGE,
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("6"),
                            size = FontSizeVariant.LARGE,
                        ),
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
            ),
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("7"),
                            size = FontSizeVariant.LARGE,
                        ),
                    topLeft =
                        KeyC(
                            KeyAction.CommitText("~"),
                        ),
                    bottomRight =
                        KeyC(
                            KeyAction.CommitText(":"),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("<"),
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("8"),
                            size = FontSizeVariant.LARGE,
                        ),
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
                            KeyAction.CommitText("-"),
                        ),
                    bottom =
                        KeyC(
                            KeyAction.CommitText("."),
                        ),
                    bottomLeft =
                        KeyC(
                            KeyAction.CommitText("*"),
                        ),
                    left =
                        KeyC(
                            KeyAction.CommitText(","),
                        ),
                ),
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("9"),
                            size = FontSizeVariant.LARGE,
                        ),
                    top =
                        KeyC(
                            KeyAction.CommitText("&"),
                        ),
                    topRight =
                        KeyC(
                            KeyAction.CommitText("°"),
                        ),
                    bottomRight =
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
            ),
            listOf(
                KeyItemC(
                    center =
                        KeyC(
                            KeyAction.CommitText("0"),
                            size = FontSizeVariant.LARGE,
                        ),
                    widthMultiplier = 2,
                ),
                SPACEBAR_SKINNY_KEY_ITEM,
                RETURN_KEY_ITEM,
            ),
        ),
    )
