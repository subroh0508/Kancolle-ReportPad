package jp.subroh0508.kancollereportpad.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

/**
 * Created by subroh_0508 on 2017/03/05.
 */
class InfoPagerAdapter(val context: Context) : PagerAdapter() {
    val contents: SparseArray<View> = SparseArray()

    override fun getCount() = contents.size()

    override fun isViewFromObject(view: View?, `object`: Any?) = view == `object`

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        require(contents[position] != null) { "contents[$position] can not be null" }

        val contentView = contents[position]
        container?.addView(contentView)

        return contentView
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }

    fun addView(view: View) {
        contents.put(count, view)
        notifyDataSetChanged()
    }
}