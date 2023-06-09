package com.myapp.mlmapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapp.mlmapplication.databinding.FragmentAppUserBinding
import com.myapp.mlmapplication.databinding.FragmentUserBinding

class AppUserFragment: Fragment() {
    private var _binding : FragmentAppUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentAppUserBinding.inflate(inflater, container, false)

        return binding.root
    }
}