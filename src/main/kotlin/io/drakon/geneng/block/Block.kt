package io.drakon.geneng.block

private var isRegistered = false

public fun registerBlocks() {
    if (isRegistered) return
    isRegistered = true
}