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

public fun World.isAir(coord: Coord): Boolean {
    return this.isAirBlock(coord.x, coord.y, coord.z)
}

public fun World.setBlock(coord: Coord, block: Block, meta: Int):Boolean {
    return this.setBlock(coord.x, coord.y, coord.z, block, meta, 3)
}

public fun World.setTile(coord: Coord, te:TileEntity) {
    this.setTileEntity(coord.x, coord.y, coord.z, te)
}