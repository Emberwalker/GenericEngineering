package io.drakon

import org.apache.logging.log4j.LogManager

/**
  * Constants and other package items.
  */
package object geneng {
  final val MOD_ID = "geneng"
  final val MOD_NAME = "Generic Engineering"
  final val MOD_VERSION = "@VERSION@"
  final val SCALA_VERSION = "@SCALA@"
  val log = LogManager.getLogger(MOD_ID)
}
