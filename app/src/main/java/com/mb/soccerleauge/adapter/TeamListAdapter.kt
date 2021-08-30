package com.mb.soccerleauge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.data.TeamResponse
import com.mb.soccerleauge.databinding.ItemTeamlistBinding

class TeamListAdapter : ListAdapter<TeamDetail,TeamListAdapter.TeamViewHolder>(DiffCallback()) {
    class TeamViewHolder(private val binding : ItemTeamlistBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(team: TeamDetail){
           val sira = adapterPosition +1
           binding.apply {
                txtTeamName.text = team.shortName
                txtId.text = "$sira."
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

    class DiffCallback : DiffUtil.ItemCallback<TeamDetail>() {
        override fun areItemsTheSame(oldItem: TeamDetail, newItem: TeamDetail) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TeamDetail, newItem: TeamDetail) = oldItem == newItem
}


