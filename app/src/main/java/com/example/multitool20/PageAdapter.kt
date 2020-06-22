package com.example.multitool20

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {return ToolsFragment()}
            1 -> {return SettingsFragment()}
            2 -> {return AboutFragment()}
            else -> {return ToolsFragment()}
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> {return "Tools"}
            1 -> {return "Settings"}
            2 -> {return "About"}
        }
        return super.getPageTitle(position)
    }
}