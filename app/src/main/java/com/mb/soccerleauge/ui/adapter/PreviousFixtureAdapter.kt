package com.mb.soccerleauge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mb.soccerleauge.data.Fixture
import com.mb.soccerleauge.data.TeamDetail
import com.mb.soccerleauge.databinding.ItemFixtureBinding

class PreviousFixtureAdapter(private val fixtureList : ArrayList<Fixture>) : ListAdapter<Fixture, PreviousFixtureAdapter.FixtureViewHolder>(DiffCallback()) {
    class FixtureViewHolder(private val binding : ItemFixtureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fixture: Fixture){
            binding.fixtureItem = fixture
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val binding = ItemFixtureBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FixtureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class DiffCallback : DiffUtil.ItemCallback<Fixture>() {
        override fun areItemsTheSame(oldItem: Fixture, newItem: Fixture) = oldItem== newItem

        override fun areContentsTheSame(oldItem: Fixture, newItem: Fixture) = oldItem == newItem
    }

    fun addData(list: List<Fixture>) {
        fixtureList.addAll(list)
    }
}