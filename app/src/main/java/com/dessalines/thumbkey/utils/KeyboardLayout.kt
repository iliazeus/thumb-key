@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.utils

import com.dessalines.thumbkey.keyboards.*

// Make sure new keyboards are added AT THE END of this list, and have a higher index.
// DO NOT put them in the middle of the list!
enum class KeyboardLayout(
    val keyboardDefinition: KeyboardDefinition,
) {
    ENThumbKey(KB_EN_THUMBKEY),
    RUThumbKey(KB_RU_THUMBKEY),
}
