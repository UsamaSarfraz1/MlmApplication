package com.myapp.mlmapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myapp.mlmapplication.databinding.ItemAppUserBinding
import com.myapp.mlmapplication.databinding.ItemPanelUserBinding
import com.myapp.mlmapplication.model.AppUser

class AppUserAdapter(
    private var list : ArrayList<AppUser>,
    private var context : Context
) : Adapter<AppUserAdapter.PanelUserViewHolder>() {

    class PanelUserViewHolder(var binding: ItemAppUserBinding) : ViewHolder(binding.root){
        var isButtonEnabled = false
        // Function to update button state and text
        fun updateButtonState() {
            if (isButtonEnabled) {
                binding.btnStatus.isEnabled = true
                binding.btnStatus.text = "Enabled"
            } else {
                binding.btnStatus.isEnabled = false
                binding.btnStatus.text = "Disabled"
            }
        }
        fun bind(AppUser : AppUser){
            binding.name.text=AppUser.userName
            binding.userPanelEmail.text=AppUser.userEmail
            binding.btnStatus.setOnClickListener {
                isButtonEnabled = !isButtonEnabled
                updateButtonState()
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelUserViewHolder {
        val binding = ItemAppUserBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        return PanelUserViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: PanelUserViewHolder, position: Int) {
        val AppUser= list[position]
        holder.bind(AppUser)
    }
}