package io.drakon.geneng.util.convenience

import io.drakon.geneng.util.Coord
import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

/**
 * World extension methods.
 *
 * @author Arkan <arkan@drakon.io>
 */

public fun World.getBlock(coord:Coord): Block? {
    return this.getBlock(coord.x, coord.y, coord.z)
}

public fun World.getBlockMeta(coord: Coord): Int {
    return this.getBlockMetadata(coord.x, coord.y, coord.z)
}

public fun World.getTileEntity(coord:Coord): TileEntity? {
    return this.getTileEntity(coord.x, coord.y, coord.z)
}