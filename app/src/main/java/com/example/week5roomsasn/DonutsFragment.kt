package com.example.week5roomsasn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week5roomsasn.databinding.FragmentDonutsBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//import com.example.viewmodelexample.BR.myViewModel //BR = binding root




/**
 * A simple [Fragment] subclass.
 * Use the [TasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DonutsFragment : Fragment() {

    private var _binding : FragmentDonutsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDonutsBinding.inflate(inflater,container,false)
        val view = binding!!.root
        val application= requireNotNull(this.activity).application
        val dao = DonutDatabase.getInstance(application).donutDao
        val viewModelFactory = DonutsViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(DonutsViewModel::class.java)
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner=viewLifecycleOwner//set layout's lifecycleOwner so that it can respond to data updates

        return view
    }


}