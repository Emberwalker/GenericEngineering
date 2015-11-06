package io.drakon.geneng.multiblock.tile

import io.drakon.geneng.multiblock.MultiblockOven
import io.drakon.geneng.util.Coord
import io.drakon.geneng.util.IMaskedWorldAccessor

import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.common.util.ForgeDirection
import net.minecraft.inventory.IInventory
import net.minecraftforge.oredict.OreDictionary

import blusunrize.immersiveengineering.common.IEContent
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDecoration
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityMultiblockPart
import cofh.api.energy.IEnergyReceiver

/**
 * TE for the Oven
 *
 * @author Arkan <arkan@drakon.io>
 */
class TileOven(private var accessor:IMaskedWorldAccessor, private var position: Coord): TileEntityMultiblockPart(),
        IEnergyReceiver {

    private final val MAX_ENERGY = 20000
    private final val ENERGY_PER_OP = 200
    public var energyStored = 0
    private var ticks = 0

    private val isEnergyAcceptor = (_getOriginalBlock()!!.first == IEContent.blockMetalDecoration &&
            _getOriginalBlock()!!.second == BlockMetalDecoration.META_radiator)

    // Defined in TileEntityMultiblockPart in later versions
    /*override*/ fun master():TileEntityMultiblockPart? {
        if (isMaster()) return this
        val te = accessor.getTileEntity(Coord(0,0,0)) ?: return null
        return if (te is TileEntityMultiblockPart) te else null
    }

    private fun isMaster():Boolean {
        return position == Coord(0,0,0)
    }

    public fun getFacing(): ForgeDirection {
        return accessor.direction
    }

    private fun _getOriginalBlock(): Pair<Block?, Int>? {
        return MultiblockOven.structureComponents[position]
    }

    override fun getOriginalBlock(): ItemStack? {
        val ent = _getOriginalBlock() ?: return null
        return ItemStack(ent.first, 1, ent.second)
    }

    override fun getBlockBounds(): FloatArray? {
        return floatArrayOf(0f,0f,0f,1f,1f,1f)
    }

    override fun getMaxEnergyStored(p0: ForgeDirection?): Int {
        return MAX_ENERGY
    }

    override fun getEnergyStored(p0: ForgeDirection?): Int {
        return energyStored
    }

    override fun receiveEnergy(dir: ForgeDirection, maxRecv: Int, simulate: Boolean): Int {
        if (!(dir == ForgeDirection.UP && this.isEnergyAcceptor)) return 0
        val master = (master() ?: return 0) as TileOven
        val deficit = MAX_ENERGY - master.energyStored
        var added: Int
        if (deficit > maxRecv) {
            added = maxRecv
        } else {
            added = deficit
        }
        if (!simulate) master.energyStored += added
        return added
    }

    override fun canConnectEnergy(dir: ForgeDirection): Boolean {
        return (dir == ForgeDirection.UP && this.isEnergyAcceptor)
    }

    override fun writeCustomNBT(nbt: NBTTagCompound, descPacket: Boolean) {
        super.writeCustomNBT(nbt, descPacket)
        nbt.setIntArray("relPos", intArrayOf(position.x, position.y, position.z))
        nbt.setInteger("energy", energyStored)
    }

    override fun readCustomNBT(nbt: NBTTagCompound, descPacket: Boolean) {
        super.readCustomNBT(nbt, descPacket)
        val rawPos = nbt.getIntArray("relPos")
        position = Coord(rawPos[0], rawPos[1], rawPos[2])
        energyStored = nbt.getInteger("energy")
    }

    override fun canUpdate(): Boolean {
        return true
    }

    override fun updateEntity() {
        //log.info(isMaster())
        if (!formed || !isMaster()) return // Master-only

        ticks += 1
        if (ticks > 20) { ticks = 0; return }
        if (ticks % 5 != 0) return // Only run every 5 ticks

        // Hunt for inventories to cook...
        val invs = hashSetOf<IInventory>()
        for (c in listOf(Coord(1,1,0), Coord(2,1,0), Coord(1,1,1), Coord(2,1,1))) {
            //log.info("DBG: {}", accessor.__transform(c))
            val te = accessor.getTileEntity(c)
            if (te is IInventory) invs.add(te)
        }

        // COOK!
        for (inv in invs) {
            if (energyStored < ENERGY_PER_OP) continue
            var it: ItemStack
            for (i in 0..inv.sizeInventory) {
                val stack = inv.getStackInSlot(i)
                val dict = OreDictionary.getOreNames()
            }
        }
    }
}