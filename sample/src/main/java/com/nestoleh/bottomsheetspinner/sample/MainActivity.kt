package com.nestoleh.bottomsheetspinner.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nestoleh.bottomsheetspinner.adapter.OnBottomSheetSpinnerItemSelected
import com.nestoleh.bottomsheetspinner.sample.spinner.ShapeSpinnerAdapter
import com.nestoleh.bottomsheetspinner.sample.spinner.ShapeSpinnerEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerAdapter: ShapeSpinnerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

    }

    private fun initUI() {
        initSpinner()
    }


    /*
    initSpinner()
    emptyList'i ShapeSpinnerAdapter üzerinden spinnerAdapter'e setlemektedir, spinner üzerinde çıkan verilerin onItemSelectedListener
    üzerinde response göre davranışlar bu alanda yapılmalıdır, seçilmeme durumunda bir işlem gereksiniminde onNothingSelected kullanılmalıdır.
     */
    private fun initSpinner() {
        spinnerAdapter = ShapeSpinnerAdapter(emptyList())
        spinner.setAdapter(spinnerAdapter)
        spinner.onItemSelectedListener = object : OnBottomSheetSpinnerItemSelected {
            override fun onItemSelected(position: Int) {
                selectedItemTextView.text =
                        spinner.getSelectedItem<ShapeSpinnerEntity.Item>()?.value?.name ?: "null"
                selectedItemPositionTextView.text = spinner.getSelectedItemPosition().toString()
            }

            override fun onNothingSelected() {
                TODO("Not yet implemented")
            }
        }
        resetSpinnerAdapter()
    }

    private fun resetSpinnerAdapter() {
        spinnerAdapter.updateData(getSpinnerList())
    }

    /*
    getSpinnerList() : shape class'ından aldığı bilgileri döndürüp listeyi doldurmaktadır.
     */
    private fun getSpinnerList(): List<ShapeSpinnerEntity> {
        var index = 1
        val entities = ArrayList<ShapeSpinnerEntity>()
        Shape.values().forEach { shape ->
            index++
            entities.add(ShapeSpinnerEntity.Item(shape))
        }
        return entities
    }
}