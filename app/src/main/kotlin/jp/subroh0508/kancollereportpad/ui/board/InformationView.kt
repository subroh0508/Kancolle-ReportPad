package jp.subroh0508.kancollereportpad.ui.board

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import jp.subroh0508.kancollereportpad.R

/**
 * Created by subroh_0508 on 2017/03/05.
 */

open class InformationView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    open val layoutRes: Int = R.layout.layout_improvement_arsenal
    val root: View by lazy { LayoutInflater.from(context).inflate(layoutRes, this, false) }
}