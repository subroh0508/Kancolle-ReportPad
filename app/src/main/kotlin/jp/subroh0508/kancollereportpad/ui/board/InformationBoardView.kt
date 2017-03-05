package jp.subroh0508.kancollereportpad.ui.board

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.ui.adapter.InfoPagerAdapter
import kotlinx.android.synthetic.main.layout_information_board.view.*

/**
 * Created by subroh_0508 on 2017/03/05.
 */
class InformationBoardView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    val root: View by lazy { LayoutInflater.from(context).inflate(R.layout.layout_information_board, this, false) }
    val pagerAdapter: InfoPagerAdapter by lazy { InfoPagerAdapter(context) }

    init { addView(root) }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        setupTabs()
    }

    private fun setupTabs() {
        with (root) {
            contentList.forEach { (_, view) -> pagerAdapter.addView(view) }
            viewPager.adapter = pagerAdapter
            tabs.setupWithViewPager(viewPager)
            tabList.forEach{ (position, tabTitleRes) -> tabs.getTabAt(position)?.setCustomView(tabTitleRes) }
        }
    }

    private val tabList = mapOf(
            0 to R.layout.tab_improvement_arsenal,
            1 to R.layout.tab_improvement_arsenal,
            2 to R.layout.tab_improvement_arsenal
    )

    private val contentList = mapOf(
            0 to ImprovementArsenalView(context),
            1 to ImprovementArsenalView(context),
            2 to ImprovementArsenalView(context)
    )
}