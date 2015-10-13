package io.drakon.geneng.util.convenience

import net.minecraft.util.StatCollector

/**
 * Sneaky String extensions.
 *
 * @author Arkan <arkan@drakon.io>
 */

public fun String.i18n(): String {
    return StatCollector.translateToLocal(this)
}