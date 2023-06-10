package com.myapp.mlmapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myapp.mlmapplication.databinding.ItemPanelUserBinding
import com.myapp.mlmapplication.model.UserPanel

class PanelUserAdapter(
    private var list : ArrayList<UserPanel>,
    private var context : Context
) : Adapter<PanelUserAdapter.PanelUserViewHolder>() {

    class PanelUserViewHolder(var binding: ItemPanelUserBinding) : ViewHolder(binding.root){
        fun bind(userPanel : UserPanel){
            binding.name.text=userPanel.userName
            binding.userPanelEmail.text=userPanel.userEmail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelUserViewHolder {
        val binding = ItemPanelUserBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return PanelUserViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: PanelUserViewHolder, position: Int) {
        val userPanel= list[position]
        holder.bind(userPanel)
    }
}