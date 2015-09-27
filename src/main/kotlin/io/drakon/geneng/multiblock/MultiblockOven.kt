package io.drakon.geneng.multiblock

import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection.*

import blusunrize.immersiveengineering.api.MultiblockHandler.IMultiblock
import blusunrize.immersiveengineering.common.IEContent
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDecoration

import io.drakon.geneng.util.const.log
import io.drakon.geneng.util.convenience.*
import net.minecraftforge.common.util.ForgeDirection

/**
 * Moar food, in moar space!
 *
 * @author Arkan <arkan@drakon.io>
 */
public object MultiblockOven : IMultiblock {

    private final val structure = Array(3, {Array(4, {arrayOfNulls<ItemStack>(2)})})

    // Populate structure
    // "slices" are linear along the structure.
    init {
        for (h in structure.indices) {
            for (slice in structure[h].indices) {
                for (w in structure[h][slice].indices) {
                    when (slice) {
                        0, 3 -> structure[h][slice][w] = ItemStack(IEContent.blockMetalDecoration, 1, BlockMetalDecoration.META_lightEngineering)
                        1, 2 -> when(h) {
                            0 -> structure[h][slice][w] = ItemStack(IEContent.blockMetalDecoration, 1, BlockMetalDecoration.META_scaffolding)
                            2 -> structure[h][slice][w] = ItemStack(IEContent.blockMetalDecoration, 1, BlockMetalDecoration.META_radiator)
                        }
                    }
                }
            }
        }
    }

    override fun getTotalMaterials(): Array<ItemStack>? {
        return arrayOf(
                ItemStack(IEContent.blockMetalDecoration, 18, BlockMetalDecoration.META_lightEngineering),
                ItemStack(IEContent.blockMetalDecoration, 4, BlockMetalDecoration.META_scaffolding),
                ItemStack(IEContent.blockMetalDecoration, 4, BlockMetalDecoration.META_radiator)
        )
    }

    override fun getStructureManual(): Array<Array<Array<ItemStack?>>> {
        return structure
    }

    override fun isBlockTrigger(blk: Block, meta: Int): Boolean {
        return blk == IEContent.blockMetalDecoration && meta == BlockMetalDecoration.META_radiator
    }

    override fun createStructure(world: World, x: Int, y: Int, z: Int, side: Int, plr: EntityPlayer): Boolean {
        // The top is too awkward to work with. So is the bottom. As is the unknown actually.
        if (getOrientation(side) in listOf(DOWN, UP, UNKNOWN)) return false

        // Find which radiator we are...a
        // Using the side, we know we're one of two blocks.
        val corner = object { var x=x; var y=y; var z=z }
        var facing = getOrientation(side) // Direction from input face to output face; structure extends this way
        var siding:ForgeDirection // Direction the structure extends towards from the given corner
        when (facing) {
            EAST, WEST -> {
                if (world.getBlock(x,y,z+1) == IEContent.blockMetalDecoration && world.getBlockMetadata(x,y,z+1) == BlockMetalDecoration.META_lightEngineering) {
                    corner.z += 1
                    siding = NORTH
                } else if (world.getBlock(x,y,z-1) == IEContent.blockMetalDecoration && world.getBlockMetadata(x,y,z-1) == BlockMetalDecoration.META_lightEngineering) {
                    corner.z -= 1
                    siding = SOUTH
                } else return false
            }
            NORTH, SOUTH -> {
                if (world.getBlock(x-1,y,z) == IEContent.blockMetalDecoration && world.getBlockMetadata(x-1,y,z) == BlockMetalDecoration.META_lightEngineering) {
                    corner.x -= 1
                    siding = EAST
                } else if (world.getBlock(x+1,y,z) == IEContent.blockMetalDecoration && world.getBlockMetadata(x+1,y,z) == BlockMetalDecoration.META_lightEngineering) {
                    corner.x += 1
                    siding = WEST
                } else return false
            }
            else -> return false // Derp?
        }
        sendMessageToPlayer(plr, corner.toString())
        sendMessageToPlayer(plr, siding.name())
        val valid = check(world, corner.x, corner.y, corner.z, facing, siding)
        sendMessageToPlayer(plr, valid.toString())
        return false // TODO
    }

    private fun check(w:World, x: Int, y: Int, z: Int, facing:ForgeDirection, siding:ForgeDirection): Boolean {
        // TODO
        return false
    }

}