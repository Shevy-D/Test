package com.shevy.test.ui.main

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class SectionsPagerAdapter(activity: FragmentActivity, val colorList: List<Int>) :
    FragmentStateAdapter(activity) {
    override fun getItemCount() = colorList.count()

    override fun createFragment(position: Int) = ColoredFragment.newInstance(colorList[position])
}