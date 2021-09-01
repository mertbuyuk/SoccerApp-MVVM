package com.mb.soccerleauge.ui.fixture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mb.soccerleauge.R
import com.mb.soccerleauge.databinding.FragmentFixtureBinding
import com.mb.soccerleauge.ui.adapter.FixtureViewPagerAdapter
import com.mb.soccerleauge.ui.adapter.PreviousFixtureAdapter
import com.mb.soccerleauge.ui.fixture.nextweek.FixtureNextFragment
import com.mb.soccerleauge.ui.fixture.previous.FixturePreviousFragment

class FixtureFragment : Fragment() {
    private lateinit var binding : FragmentFixtureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixtureBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf<Fragment>(
            FixturePreviousFragment(),
            FixtureNextFragment()
        )

        val adapter = FixtureViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.fixtureViewPager.adapter = adapter
    }
}