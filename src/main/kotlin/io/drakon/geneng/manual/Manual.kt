package io.drakon.geneng.manual

import blusunrize.immersiveengineering.api.ManualHelper
import blusunrize.immersiveengineering.api.ManualPageMultiblock
import cpw.mods.fml.relauncher.Side
import cpw.mods.fml.relauncher.SideOnly
import io.drakon.geneng.lib.constants.OVEN_MANUAL_NAME
import io.drakon.geneng.lib.constants.OVEN_MANUAL_TEXT
import io.drakon.geneng.multiblock.MultiblockOven
import io.drakon.geneng.util.const.log
import io.drakon.geneng.util.convenience.i18n

/**
 * Manual helper functions
 *
 * @author Arkan <arkan@drakon.io>
 */

private var hasRegisteredManPages = false

@Suppress("UNREACHABLE_CODE")
@SideOnly(Side.CLIENT)
public fun registerManPages() {
    // TODO: Manual pages are borkbork right now
    return

    if (hasRegisteredManPages) {
        log.warn("Someone called registerManPages again...")
        return
    }

    val man = ManualHelper.getManual()
    ManualHelper.addEntry(OVEN_MANUAL_NAME.i18n(), ManualHelper.CAT_MACHINES,
            ManualPageMultiblock(man, OVEN_MANUAL_TEXT.i18n(), MultiblockOven))
}
