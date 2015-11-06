package io.drakon.geneng.client.render

import blusunrize.immersiveengineering.client.models.ModelIEObj
import blusunrize.immersiveengineering.client.render.TileRenderIE
import blusunrize.immersiveengineering.common.IEContent
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalMultiblocks
import blusunrize.immersiveengineering.common.util.chickenbones.Matrix4
import io.drakon.geneng.multiblock.tile.TileOven
import net.minecraft.client.renderer.Tessellator
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.IIcon
import net.minecraftforge.common.util.ForgeDirection

object TileRenderOven: TileRenderIE() {

    private class OvenModel: ModelIEObj("geneng:models/oven.obj") {
        override fun getBlockIcon(): IIcon? {
            return IEContent.blockMetalMultiblocks.getIcon(0, BlockMetalMultiblocks.META_lightningRod) // TODO
        }
    }

    private final val model = OvenModel()

    override fun renderStatic(rawTE: TileEntity, tes: Tessellator, translation: Matrix4, rotation: Matrix4) {
        val tile = rawTE as TileOven
        if (tile.getFacing() in setOf(ForgeDirection.NORTH, ForgeDirection.SOUTH)) {
            translation.translate(0.0,0.0,0.0) // TODO
        } else {
            translation.translate(0.0,0.0,0.0) // TODO
        }

        model.render(tile, tes, translation, rotation, 0, false)
    }

    override fun renderDynamic(tile: TileEntity?, x: Double, y: Double, z: Double, f: Float) {}
}