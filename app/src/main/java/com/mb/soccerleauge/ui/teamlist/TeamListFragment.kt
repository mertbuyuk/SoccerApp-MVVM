package com.mb.soccerleauge.ui.teamlist

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mb.soccerleauge.adapter.TeamListAdapter
import com.mb.soccerleauge.databinding.FragmentTeamListBinding


class TeamListFragment : Fragment() {
    private lateinit var binding: FragmentTeamListBinding

    private val viewModel : TeamListViewModel by viewModels {
        TeamListViewModelFactory(TeamListRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}