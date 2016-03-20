package io.drakon.geneng.util

/**
 * Utility annotation to ignore unused errors in place of @Suppress.
 * In IDEA, open Inspections settings, find the Unused inspection and hit Configure Annotations, and add this class.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class FMLObjectOrMethod
