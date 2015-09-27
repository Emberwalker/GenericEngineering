package io.drakon.geneng.multiblock

import blusunrize.immersiveengineering.api.MultiblockHandler
import io.drakon.geneng.util.const.log

/**
 * Package functionality.
 *
 * @author Arkan <arkan@drakon.io>
 */

private var hasRegisteredMBs = false

public fun registerMultiblocks() {
    if (hasRegisteredMBs) {
        log.warn("Someone called registerMultiblocks a second (or more) time...")
        return
    }
    MultiblockHandler.registerMultiblock(MultiblockOven)
    //MultiblockHandler.registerMultiblock(MultiblockSmeltery)

    hasRegisteredMBs = true
}
