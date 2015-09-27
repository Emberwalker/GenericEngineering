package io.drakon.geneng.util.convenience

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText

/**
 * Things Arkan likes because he's lazy.
 *
 * @author Arkan <arkan@drakon.io>
 */

public fun sendMessageToPlayer(player:EntityPlayer, msg:String) {
    player.addChatMessage(ChatComponentText(msg))
}