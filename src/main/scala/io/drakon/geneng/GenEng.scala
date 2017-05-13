package io.drakon.geneng

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

/**
  * Small additions to Immersive Engineering.
  *
  * @author Arkan <arkan@drakon.io>
  */
@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, modLanguage = "scala",
  dependencies = "required-after:immersiveengineering@[0.11-58,);"
               + "required-after:forge@[13.20.0.2282,)")
object GenEng {

  log.info(s"$MOD_NAME version $MOD_VERSION (Scala $SCALA_VERSION)")

  @EventHandler
  def preinit(evt: FMLPreInitializationEvent) {
    log.debug("Preinit.")
  }

  @EventHandler
  def init(evt: FMLInitializationEvent) {
    log.debug("Init.")
  }

  @EventHandler
  def postinit(evt: FMLPostInitializationEvent) {
    log.debug("Postinit.")
  }

}
