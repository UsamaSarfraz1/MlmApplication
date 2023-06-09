package com.myapp.mlmapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapp.mlmapplication.databinding.FragmentPanelUserBinding
import com.myapp.mlmapplication.databinding.FragmentUserBinding

class PanelUserFragment: Fragment() {
    private var _binding : FragmentPanelUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentPanelUserBinding.inflate(inflater, container, false)

        return binding.root
    }
}