package com.mb.soccerleauge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.data.Team
import com.mb.soccerleauge.databinding.ItemTeamlistBinding

class TeamListAdapter : ListAdapter<Team,TeamListAdapter.TeamViewHolder>(DiffCallback()) {
    inner class TeamViewHolder(private val binding : ItemTeamlistBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(team: Team){
           binding.apply {
               txtTeamName.text = team.strTeam
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}

    class DiffCallback(): DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Team, newItem: Team) = oldItem==newItem }
