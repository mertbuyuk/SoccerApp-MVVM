package com.mb.soccerleauge.ui.teamlist

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getTeams()
    }

    /*private fun getTeams() {
        Log.i("i","2")
        api.getAllTeam(Constant.API_KEY).enqueue(object : Callback<TeamResponse>{
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                when(response.code()){
                    200 -> getTeamList(response.body()!!)
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }*/

   /* private fun getTeamList(body: TeamResponse) {
        adapter.submitList(body.list)
        Log.i("sadas",body.list.toString())
    }*/
}