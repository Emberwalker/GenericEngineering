package io.drakon.geneng.multiblock.tile

import cpw.mods.fml.common.registry.GameRegistry

private var isRegistered = false

public fun registerMultiTiles() {
    if (isRegistered) return

    GameRegistry.registerTileEntity(TileOven::class.java, "geneng:oven")

    isRegistered = true
}