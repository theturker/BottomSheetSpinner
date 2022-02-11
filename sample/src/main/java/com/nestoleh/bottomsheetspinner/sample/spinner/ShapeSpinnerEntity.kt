package com.nestoleh.bottomsheetspinner.sample.spinner

import com.nestoleh.bottomsheetspinner.sample.Shape

/**
 * Wrapper for shape spinner entity,
 * used to separate shapes and headers
 *
 * @author oleg.nestyuk
 */
sealed class ShapeSpinnerEntity(
    val type: Type
) {
    class Item(val value: Shape) : ShapeSpinnerEntity(Type.ITEM)

    enum class Type {
         ITEM
    }
}