package com.example.myass01.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myass01.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.fragment_main, container, false)
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        var message = view.findViewById<TextView>(R.id.message)

      //  message.text = viewModel.result.value.toString()

        viewModel.result.observe(viewLifecycleOwner, Observer{
            message.text = it.toString()
        })  //Observer pattern

//        if (message != null) {
//            message.text = viewModel.result.value.toString()
//            // 1 message.text = "Dineshi"
//        }

        var addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            //viewModel.add(5.0,6.0)
            viewModel.add(Math.random()*12,6.0)
        //message.text = viewModel.addAntiFunction(Math.random(),12.0).toString() -->1st anti pattern
           // viewModel.addAntiFunction(Math.random(),12.0,message).toString()  --->2nd anti pattern
        }

        return view
    }

}