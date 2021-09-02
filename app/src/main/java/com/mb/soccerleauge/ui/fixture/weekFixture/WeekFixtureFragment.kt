package com.mb.soccerleauge.ui.fixture.weekFixture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.databinding.FragmentFixtureNextBinding
import com.mb.soccerleauge.db.db
import com.mb.soccerleauge.sharedpref.SharedPref
import com.mb.soccerleauge.ui.adapter.NextFixtureAdapter
import com.mb.soccerleauge.ui.fixture.FixtureFragment
import com.mb.soccerleauge.ui.teamlist.TeamListRepository
import com.mb.soccerleauge.ui.teamlist.TeamListViewModel
import com.mb.soccerleauge.ui.teamlist.TeamListViewModelFactory

class WeekFixtureFragment(private val viewPager2: ViewPager2) : Fragment() {
    private lateinit var binding: FragmentFixtureNextBinding
    private val adapter = NextFixtureAdapter(arrayListOf())
    private var fromIndex = 0
    private var count = 0
    private val viewModel: TeamListViewModel by viewModels {
        TeamListViewModelFactory(TeamListRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFixtureNextBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            nextRecyclerview.adapter = adapter
            nextRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        }
       getFixture()

    }


    private fun getFixture() {
        viewModel.teams.observe(viewLifecycleOwner, Observer {
            val list = viewModel.createFixture()
            adapter.submitList(list.subList(0, 8))

        })
    }
}

