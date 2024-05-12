package com.example.welcomefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_welcome, container, false)

        val buttonNavigate = root.findViewById<Button>(R.id.buttonNavigate)
        buttonNavigate.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment)
        }


        return root


    }


}