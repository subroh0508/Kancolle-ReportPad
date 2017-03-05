package jp.subroh0508.kancollereportpad.ui.board

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.extensions.dayOfWeek
import jp.subroh0508.kancollereportpad.extensions.showToast
import kotlinx.android.synthetic.main.layout_improvement_arsenal.view.*
import java.util.*

/**
 * Created by subroh_0508 on 2017/03/05.
 */
class ImprovementArsenalView(context: Context, attrs: AttributeSet? = null) : InformationView(context, attrs) {
    override val layoutRes = R.layout.layout_improvement_arsenal
    val adapter: ArrayAdapter<CharSequence> by lazy { ArrayAdapter.createFromResource(context, R.array.weeks, android.R.layout.simple_spinner_item) }
    val daysOfWeek = context.resources.getStringArray(R.array.weeks).toList()

    init { addView(root) }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setupSpinner()
        setupList()
    }

    private fun setupSpinner() {
        with (root) {
            selectDay.adapter = adapter
            selectDay.setSelection(daysOfWeek.indexOf(context.dayOfWeek(Date())))
            selectDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    setupList(daysOfWeek[position])
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }

    private fun setupList(currentDate: String = context.dayOfWeek(Date())) {
        showToast(context, "current date:$currentDate")
    }
}