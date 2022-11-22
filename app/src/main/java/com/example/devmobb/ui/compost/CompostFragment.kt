package com.example.devmobb.ui.compost

import allComposts
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devmobb.adapter.CompostAdapter
import com.example.devmobb.api.CompostApi
import com.example.devmobb.api.RetrofitHelper
import com.example.devmobb.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CompostFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(CompostViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView
        //val progressBarSation = binding.progressBarSation

        homeViewModel.composts.observe(viewLifecycleOwner) {
            //val adapter : StationAdapter(it)
            //val adapter : StationAdapter(it.requireContext())
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = CompostAdapter(it, requireContext())
            //progressBarSation.visibility = View.GONE

            allComposts = it
        }

        val compostApi = RetrofitHelper().getInstance().create(CompostApi::class.java)
        GlobalScope.launch {
            val result = compostApi.getComposts()
            Log.d("HOME", result.body().toString())
            homeViewModel.composts.postValue(result.body())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}