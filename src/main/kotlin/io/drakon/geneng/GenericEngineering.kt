package io.drakon.geneng

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.Mod.EventHandler as handler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLLoadCompleteEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import io.drakon.geneng.block.registerBlocks
import io.drakon.geneng.manual.registerManPages

import io.drakon.geneng.proxy.CommonProxy
import io.drakon.geneng.util.FMLObjectOrMethod
import io.drakon.geneng.util.const.*
import io.drakon.geneng.multiblock.registerMultiblocks
import io.drakon.geneng.multiblock.tile.registerMultiTiles

@FMLObjectOrMethod
@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, modLanguage = MOD_LANG, dependencies = "after:ImmersiveEngineering[0.6,)")
class GenericEngineering {

    companion object {
        @FMLObjectOrMethod @JvmStatic
        @SidedProxy(serverSide="io.drakon.geneng.proxy.CommonProxy", clientSide="io.drakon.geneng.proxy.ClientProxy")
        public var proxy:CommonProxy = CommonProxy()
    }

    @FMLObjectOrMethod @handler fun preinit(evt: FMLPreInitializationEvent) {
        proxy.preInit()
    }

    @FMLObjectOrMethod @handler fun init(evt: FMLInitializationEvent) {
        proxy.init()
        registerBlocks()
        registerMultiTiles()
        registerMultiblocks()
    }

    @FMLObjectOrMethod @handler fun postinit(evt:FMLPostInitializationEvent) {
        proxy.postInit()
    }

}