package io.drakon.geneng.util

import io.drakon.geneng.util.convenience.*
import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import java.lang.ref.WeakReference

/**
 * Standard impl of IMaskedWorldAccessor
 *
 * @author Arkan <arkan@drakon.io>
 */
public class MaskedWorldAccessor(world:World, direction: ForgeDirection,
                                 x:Int, y:Int, z:Int): IMaskedWorldAccessor(x, y, z, direction) {

    public constructor(world:World, direction: ForgeDirection, coord: Coord): this(world, direction, coord.x, coord.y, coord.z)

    private var world = WeakReference(world);

    override fun getBlock(coord: Coord): Block? {
        val w = world.get() ?: return null
        return w.getBlock(__transform(coord))
    }

    override fun getBlockMeta(coord: Coord): Int {
        val w = world.get() ?: return 0
        return w.getBlockMeta(__transform(coord))
    }

    override fun getTileEntity(coord: Coord): TileEntity? {
        val w = world.get() ?: return null
        return w.getTileEntity(__transform(coord));
    }

    override fun isAir(coord: Coord): Boolean {
        val w = world.get() ?: return false
        return w.isAir(__transform(coord))
    }

    override fun setBlock(coord: Coord, block:Block, meta:Int): Boolean {
        val w = world.get() ?: return false
        return w.setBlock(__transform(coord), block, meta)
    }

    override fun setTile(coord: Coord, te:TileEntity) {
        val w = world.get() ?: return
        w.setTile(__transform(coord), te)
    }

}