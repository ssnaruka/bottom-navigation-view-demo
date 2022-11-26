package com.surendrasingh.bottomnavdemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.surendrasingh.bottomnavdemo.databinding.FragmentBookingsBinding

/**
 * Created by Surendra Singh on 26-11-2022
 */
class BookingsFragment : Fragment() {

    private lateinit var binding: FragmentBookingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingsBinding.inflate(inflater, container, false)
        return binding.root
    }
}