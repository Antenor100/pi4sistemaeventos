package com.example.teste.ui.ingresso

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.teste.R


class IngressoFragment : Fragment(){

    private lateinit var ingressoViewModel: IngressoViewModel

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ingressoViewModel =
            ViewModelProviders.of(this).get(IngressoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ingresso, container, false)
        val textView: TextView = root.findViewById(R.id.text_ingresso)
        ingressoViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}