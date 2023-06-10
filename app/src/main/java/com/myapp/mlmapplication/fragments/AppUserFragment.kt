package com.myapp.mlmapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapp.mlmapplication.adapter.AppUserAdapter
import com.myapp.mlmapplication.databinding.FragmentAppUserBinding
import com.myapp.mlmapplication.model.AppUser


class AppUserFragment: Fragment() {
    private var _binding : FragmentAppUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentAppUserBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        return binding.root
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        val list = ArrayList<AppUser>()
        val adapter = AppUserAdapter(list,requireContext())
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))
        list.add(AppUser("usama","usama72@gmail.com","#232323","40$"))

        binding.rvUser.adapter=adapter
        adapter.notifyDataSetChanged()
    }
}