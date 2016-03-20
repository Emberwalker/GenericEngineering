package io.drakon.geneng

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent

import io.drakon.geneng.util.FMLObjectOrMethod
import io.drakon.geneng.util.const.*

@FMLObjectOrMethod
@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, modLanguage = MOD_LANG,
        modLanguageAdapter = MOD_ADAPTER, dependencies = "after:ImmersiveEngineering[0.7,)")
object GenericEngineering {

    @EventHandler @FMLObjectOrMethod
    fun preinit(evt: FMLPreInitializationEvent) {
        // TODO
    }

    @EventHandler @FMLObjectOrMethod
    fun init(evt: FMLInitializationEvent) {
        // TODO
    }

    @EventHandler @FMLObjectOrMethod
    fun postinit(evt: FMLPostInitializationEvent) {
        // TODO
    }

}