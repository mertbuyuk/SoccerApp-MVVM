package com.mb.soccerleauge.ui.teamlist

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mb.soccerleauge.R
import com.mb.soccerleauge.databinding.FragmentTeamListBinding
import com.mb.soccerleauge.sharedpref.SharedPref


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

        val isNightMode = SharedPref(requireContext()).loadBoolen("mode")

        binding.btnFixture.setOnClickListener {
            val action = TeamListFragmentDirections.actionTeamListFragmentToFixtureFragment()
            findNavController().navigate(action)
        }

        loadMode(isNightMode)

        binding.switchDark.setOnCheckedChangeListener { _, isChecked ->
            saveDarkMode(isChecked)
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun saveDarkMode(isChecked : Boolean) {
        if (isChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            SharedPref(requireContext()).saveBoolean(isChecked,"mode")
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            SharedPref(requireContext()).saveBoolean(isChecked,"mode")
        }
    }

    private fun loadMode(isNight : Boolean){
        if (isNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.switchDark.isChecked = isNight

        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.switchDark.isChecked = isNight
        }
    }
}