package com.nestoleh.bottomsheetspinner.sample.spinner

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nestoleh.bottomsheetspinner.adapter.BottomSheetSpinnerItemClickListener
import com.nestoleh.bottomsheetspinner.adapter.BottomSheetSpinnerItemViewHolder
import com.nestoleh.bottomsheetspinner.sample.R
import com.nestoleh.bottomsheetspinner.sample.Shape

class ShapeViewHolder(
    itemView: View,
    onItemClickListener: BottomSheetSpinnerItemClickListener?
) : BottomSheetSpinnerItemViewHolder(itemView, onItemClickListener) {

    private val shapeName: TextView by lazy { itemView.findViewById(R.id.shapeName) }

    fun bindShape(shape: Shape) {
        shapeName.text = shape.title
    }

    companion object {
        const val LAYOUT_SELECTED: Int = R.layout.item_shape_selected
        const val LAYOUT_DROPDOWN: Int = R.layout.item_shape_dropdown
    }
}