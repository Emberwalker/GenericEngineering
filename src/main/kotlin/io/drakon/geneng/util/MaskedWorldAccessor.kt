package io.drakon.geneng.util

import io.drakon.geneng.util.const.log
import io.drakon.geneng.util.convenience.*
import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection
import net.minecraftforge.common.util.ForgeDirection.*
import java.lang.ref.WeakReference

/**
 * Position- and facing-independant world accessor
 *
 * @author Arkan <arkan@drakon.io>
 */
public class MaskedWorldAccessor(world:World, private val direction: ForgeDirection,
                                 private val x:Int, private val y:Int, private val z:Int) {

    public constructor(world:World, direction: ForgeDirection, coord: Coord): this(world, direction, coord.x, coord.y, coord.z)

    private var world = WeakReference(world);

    /*
     * Okay so this logic is hard to get. Positive x is forward, positive z is right.
     * I know that doesn't match MC, deal with it. It's an internal system.
     */

    private fun transform(coord: Coord): Coord {
        when (direction) {
            UP -> throw IllegalArgumentException() // Pass
            DOWN -> throw IllegalArgumentException() // Pass
            NORTH -> return Coord(x - coord.x, y + coord.y, z + coord.z) // z-
            SOUTH -> return Coord(x + coord.x, y + coord.y, z - coord.z) // z+
            EAST -> return Coord(x - coord.z, y + coord.y, z - coord.x) // x+
            WEST -> return Coord(x + coord.z, y + coord.y, z + coord.x) // x-
            else -> throw IllegalArgumentException() // Wot.
        }
    }

    public fun getBlock(coord: Coord): Block? {
        val w = world.get() ?: return null
        return w.getBlock(transform(coord))
    }

    public fun getBlockMeta(coord: Coord): Int {
        val w = world.get() ?: return 0
        return w.getBlockMeta(transform(coord))
    }

    public fun getTileEntity(coord: Coord): TileEntity? {
        val w = world.get() ?: return null
        return w.getTileEntity(transform(coord));
    }

    public fun isAir(coord: Coord): Boolean {
        val w = world.get() ?: return false
        return w.isAir(transform(coord))
    }

}