package com.mb.soccerleauge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mb.soccerleauge.R
import com.mb.soccerleauge.adapter.TeamListAdapter
import com.mb.soccerleauge.api.api
import com.mb.soccerleauge.data.Team
import com.mb.soccerleauge.databinding.FragmentTeamListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamListFragment : Fragment() {
    private lateinit var binding: FragmentTeamListBinding
    private val adapter =  TeamListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        getTeams()
    }

    private fun getTeams() {
        api.getAllTeamByLeague("turkey").enqueue(object : Callback<List<Team>>{
            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                when(response.code()){
                    200->getTeamList(response.body()!!)
                    else -> null
                }
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun getTeamList(body: List<Team>) {
        adapter.submitList(body)
    }
}