package io.drakon.geneng.util

import net.minecraft.block.Block
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.common.util.ForgeDirection

/**
 * Position- and facing-independant world accessor
 *
 * @author Arkan <arkan@drakon.io>
 */
public abstract class IMaskedWorldAccessor(protected val x:Int, protected val y:Int, protected val z:Int,
                                           public val direction: ForgeDirection) {

    /*
     * Okay so this logic is hard to get. Positive x is forward, positive z is right.
     * I know that doesn't match MC, deal with it. It's an internal system.
     */

    /**
     * Transforms the given coordinate. Mostly for private use, but accessible for the edge cases.
     *
     * @param coord Coordinate relative to structure start point
     * @return Absolute position in the world
     */
    public fun __transform(coord: Coord): Coord {
        when (direction) {
            ForgeDirection.UP -> throw IllegalArgumentException() // Pass
            ForgeDirection.DOWN -> throw IllegalArgumentException() // Pass
            ForgeDirection.NORTH -> return Coord(x - coord.x, y + coord.y, z + coord.z) // z-
            ForgeDirection.SOUTH -> return Coord(x + coord.x, y + coord.y, z - coord.z) // z+
            ForgeDirection.EAST -> return Coord(x - coord.z, y + coord.y, z - coord.x) // x+
            ForgeDirection.WEST -> return Coord(x + coord.z, y + coord.y, z + coord.x) // x-
            else -> throw IllegalArgumentException() // Wot.
        }
    }

    public abstract fun getBlock(coord: Coord): Block?

    public abstract fun getBlockMeta(coord: Coord): Int

    public abstract fun getTileEntity(coord: Coord): TileEntity?

    public abstract fun isAir(coord: Coord): Boolean

    public abstract fun setBlock(coord: Coord, block: Block, meta:Int = 0): Boolean

    public abstract fun setTile(coord: Coord, te: TileEntity)

}