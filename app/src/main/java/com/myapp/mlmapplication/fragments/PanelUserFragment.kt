package com.myapp.mlmapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapp.mlmapplication.adapter.PanelUserAdapter
import com.myapp.mlmapplication.databinding.FragmentPanelUserBinding
import com.myapp.mlmapplication.model.UserPanel

class PanelUserFragment: Fragment() {
    private var _binding : FragmentPanelUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentPanelUserBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        val list = ArrayList<UserPanel>()
        val adapter = PanelUserAdapter(list,requireContext())
        list.add(UserPanel("usama","usama72@gmail.com","admin"))
        list.add(UserPanel("usama","usama72@gmail.com","super admin"))
        list.add(UserPanel("usama","usama72@gmail.com","super admin"))
        list.add(UserPanel("usama","usama72@gmail.com","admin"))
        list.add(UserPanel("usama","usama72@gmail.com","admin"))
        list.add(UserPanel("usama","usama72@gmail.com","admin"))

        binding.rvUser.adapter=adapter
        adapter.notifyDataSetChanged()
    }
}