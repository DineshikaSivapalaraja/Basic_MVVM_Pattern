package com.example.myass01.ui.main.github

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myass01.R
import com.example.myass01.databinding.FragmentGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubFragment : Fragment() {

    companion object {
        fun newInstance() = GithubFragment()
    }

    private lateinit var binding:FragmentGithubBinding  //data binding

    private lateinit var viewModel: GithubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java) //initiate viewmodel

        binding = DataBindingUtil.inflate(  //data binding
            inflater,R.layout.fragment_github,
            container,false
        )
        val recycleView = binding.root.findViewById<RecyclerView>(R.id.users_recycleView)
        val adapter = UserListAdapter(binding.root.context,this,viewModel)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(binding.root.context)

        viewModel.users.observe(viewLifecycleOwner, Observer { users->
            adapter.setSims(users)
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this //viewLifecycleOwner

        return binding.root
//        return inflater.inflate(R.layout.fragment_github, container, false)  --> comment it for above binding return
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//      //  viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}