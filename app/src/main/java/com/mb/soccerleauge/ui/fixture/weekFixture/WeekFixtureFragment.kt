package com.mb.soccerleauge.ui.fixture.weekFixture


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.mb.soccerleauge.databinding.FragmentWeekFixtureBinding
import com.mb.soccerleauge.sharedpref.SharedPref
import com.mb.soccerleauge.ui.adapter.NextFixtureAdapter
import com.mb.soccerleauge.ui.teamlist.TeamListRepository
import com.mb.soccerleauge.ui.teamlist.TeamListViewModel
import com.mb.soccerleauge.ui.teamlist.TeamListViewModelFactory

class WeekFixtureFragment() : Fragment() {
    private lateinit var binding: FragmentWeekFixtureBinding

    private val adapter = NextFixtureAdapter(arrayListOf())
    private val viewModel: TeamListViewModel by viewModels {
        TeamListViewModelFactory(TeamListRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekFixtureBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
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
            SharedPref(requireContext()).save(it.size,"week")
            val list = viewModel.createFixture()
            adapter.submitList(list.subList(0, 9))

        })
    }
}

