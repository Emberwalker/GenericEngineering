package io.drakon.geneng.util

import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection

/**
 * Dummy accessor for manuals and such.
 *
 * @author Arkan <arkan@drakon.io>
 */
class DummyWorldAccessor: IMaskedWorldAccessor(0, 0, 0, ForgeDirection.NORTH) {
    override fun getBlock(coord: Coord): Block? {
        return null
    }

    override fun getBlockMeta(coord: Coord): Int {
        return 0
    }

    override fun getTileEntity(coord: Coord): TileEntity? {
        return null
    }

    override fun isAir(coord: Coord): Boolean {
        return false
    }

    override fun setBlock(coord: Coord, block: Block, meta: Int): Boolean {
        return false
    }

    override fun setTile(coord: Coord, te: TileEntity) {
        return
    }
}