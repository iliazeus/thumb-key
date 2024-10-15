@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

val KB_EN_MESSAGEASE_NUMERIC =
    KeyboardC(
        listOf(
            listOf(
                KeyItemC(
                    center = KeyC("1", size = LARGE),
                    swipes =
                        buildMap {
                            put(
                                SwipeDirection.BOTTOM_LEFT,
                                KeyC(
                                    CommitText("$"),
                                ),
                            )
                            put(
                                SwipeDirection.RIGHT,
                                KeyC(
                                    CommitText("-"),
                                ),
                            )
                            getLocalCurrency()?.let {
                                if (it !in setOf("$", "£", "€")) {
                                    put(
                                        SwipeDirection.BOTTOM_RIGHT,
                                        KeyC(
                                            CommitText(it),
                                        ),
                                    )
                                }
                            }
                        },
                ),
                KeyItemC(
                    center = KeyC("2", size = LARGE),
                    topLeft =
                        KeyC(
                            CommitText("`"),
                        ),
                    top =
                        KeyC(
                            CommitText("^"),
                        ),
                    topRight =
                        KeyC(
                            CommitText("´"),
                        ),
                    right =
                        KeyC(
                            CommitText("!"),
                        ),
                    bottomRight =
                        KeyC(
                            CommitText("\\"),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText("/"),
                        ),
                    left =
                        KeyC(
                            CommitText("+"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("3", size = LARGE),
                    left =
                        KeyC(
                            CommitText("?"),
                        ),
                    bottomRight =
                        KeyC(
                            CommitText("€"),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText("£"),
                        ),
                    bottom =
                        KeyC(
                            CommitText("="),
                        ),
                ),
                EMOJI_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("4", size = LARGE),
                    topLeft =
                        KeyC(
                            CommitText("{"),
                        ),
                    topRight =
                        KeyC(
                            CommitText("%"),
                        ),
                    bottomRight =
                        KeyC(
                            CommitText("_"),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText("["),
                        ),
                    left =
                        KeyC(
                            CommitText("("),
                        ),
                ),
                KeyItemC(
                    center = KeyC("5", size = LARGE),
                    top =
                        KeyC(
                            CommitText("¬"),
                        ),
                ),
                KeyItemC(
                    center = KeyC("6", size = LARGE),
                    topLeft =
                        KeyC(
                            CommitText("|"),
                        ),
                    topRight =
                        KeyC(
                            CommitText("}"),
                        ),
                    right =
                        KeyC(
                            CommitText(")"),
                        ),
                    bottomRight =
                        KeyC(
                            CommitText("]"),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText("@"),
                        ),
                ),
                ABC_KEY_ITEM,
            ),
            listOf(
                KeyItemC(
                    center = KeyC("7", size = LARGE),
                    topLeft =
                        KeyC(
                            CommitText("~"),
                        ),
                    left =
                        KeyC(
                            CommitText("<"),
                        ),
                    right =
                        KeyC(
                            CommitText("*"),
                        ),
                    bottomRight = KeyC("\t", displayText = "⇥"),
                ),
                KeyItemC(
                    center = KeyC("8", size = LARGE),
                    topLeft =
                        KeyC(
                            CommitText("\""),
                        ),
                    topRight =
                        KeyC(
                            CommitText("'"),
                        ),
                    bottomRight =
                        KeyC(
                            CommitText(":"),
                        ),
                    bottom =
                        KeyC(
                            CommitText("."),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText(","),
                        ),
                ),
                KeyItemC(
                    center = KeyC("9", size = LARGE),
                    top =
                        KeyC(
                            CommitText("&"),
                        ),
                    topRight =
                        KeyC(
                            CommitText("°"),
                        ),
                    right =
                        KeyC(
                            CommitText(">"),
                        ),
                    bottomLeft =
                        KeyC(
                            CommitText(";"),
                        ),
                    left =
                        KeyC(
                            CommitText("#"),
                        ),
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
