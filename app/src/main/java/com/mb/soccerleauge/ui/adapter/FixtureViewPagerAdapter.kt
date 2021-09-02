package com.mb.soccerleauge.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mb.soccerleauge.ui.fixture.weekFixture.WeekFixtureFragment
import java.util.ArrayList
import androidx.viewpager.widget.PagerAdapter.POSITION_NONE




class FixtureViewPagerAdapter(list: ArrayList<Fragment>,manager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager,lifecycle) {
    private val fragmentList = list

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]

    fun getItemPosition(`object`: Any?): Int {
        return POSITION_NONE
    }
}