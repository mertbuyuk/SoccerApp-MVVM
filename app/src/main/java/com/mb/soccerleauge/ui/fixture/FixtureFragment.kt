package com.mb.soccerleauge.ui.fixture


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.mb.soccerleauge.databinding.FragmentFixtureBinding
import com.mb.soccerleauge.sharedpref.SharedPref
import com.mb.soccerleauge.ui.adapter.FixtureViewPagerAdapter
import com.mb.soccerleauge.ui.fixture.weekFixture.WeekFixtureFragment

class FixtureFragment : Fragment() {
    private lateinit var binding : FragmentFixtureBinding
    private val fragmentList = arrayListOf<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixtureBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  fragmentList.add(WeekFixtureFragment())

        val size = SharedPref(requireContext()).load("week")
        for (i in 0..16){
            fragmentList.add(WeekFixtureFragment())
            SharedPref(requireContext()).save(i+1,(i+1).toString())
        }

        val adapter = FixtureViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.fixtureViewPager.adapter = adapter
    }
}


