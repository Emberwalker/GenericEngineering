package io.drakon.geneng.proxy

import cpw.mods.fml.common.FMLCommonHandler
import io.drakon.geneng.manual.registerManPages
import io.drakon.geneng.util.const.log

public class ClientProxy : CommonProxy() {

    override fun preInit() {
        super.preInit()
    }

    override fun init() {
        super.init()
    }

    override fun postInit() {
        super.postInit()
        registerManPages()
    }

}