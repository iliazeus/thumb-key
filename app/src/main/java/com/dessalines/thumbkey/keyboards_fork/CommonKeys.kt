@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards.fork

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.*
import androidx.compose.material.icons.outlined.*
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*

fun specialActionKeyItem(center: KeyC) =
    KeyItemC(
        backgroundColor = SURFACE_VARIANT,
        center = center,
        top =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.Language),
                action = SwitchLanguage,
                color = MUTED,
            ),
        left =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.LinearScale),
                action = MoveKeyboard.Left,
                color = MUTED,
            ),
        right =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.LinearScale),
                action = MoveKeyboard.Right,
                color = MUTED,
            ),
    )

val FORK_EMOJI_KEY_ITEM =
    specialActionKeyItem(
        center =
            KeyC(
                display = KeyDisplay.IconDisplay(Icons.Outlined.Mood),
                action = ToggleEmojiMode(true),
                size = LARGE,
                color = SECONDARY,
            ),
    )
