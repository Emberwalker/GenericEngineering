package io.drakon.geneng.block

import blusunrize.immersiveengineering.common.util.Lib
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EnumCreatureType
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.IBlockAccess

/**
 * Multiblock block... block?
 */
object BlockMultiblock: Block(Material.iron) {

    override fun getSubBlocks(item: Item, tabs: CreativeTabs, list: MutableList<Any?>) {
        list.add(ItemStack(item, 1, 0))
    }

    override fun canCreatureSpawn(type: EnumCreatureType?, world: IBlockAccess?, x: Int, y: Int, z: Int): Boolean {
        return false
    }

    override fun isToolEffective(type: String?, metadata: Int): Boolean {
        if (Lib.TOOL_HAMMER.equals(type)) return true
        return super.isToolEffective(type, metadata)
    }

    override fun hasTileEntity(metadata: Int): Boolean {
        return true
    }
}