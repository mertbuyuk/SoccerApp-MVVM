package com.mb.soccerleauge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mb.soccerleauge.adapter.TeamListAdapter
import com.mb.soccerleauge.api.api
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.data.TeamResponse
import com.mb.soccerleauge.databinding.FragmentTeamListBinding
import com.mb.soccerleauge.utils.Constant
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
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getTeams()
    }

    private fun getTeams() {
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
    }

    private fun getTeamList(body: TeamResponse) {
        adapter.submitList(body.list)
        Log.i("sadas",body.list.toString())
    }
}