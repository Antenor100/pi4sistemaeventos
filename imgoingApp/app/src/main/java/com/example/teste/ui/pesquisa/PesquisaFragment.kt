package com.example.teste.ui.pesquisa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.teste.R


class PesquisaFragment : Fragment() {

    private lateinit var pesquisaViewModel: PesquisaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pesquisaViewModel =
            ViewModelProviders.of(this).get(PesquisaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pesquisa, container, false)
        val textView: TextView = root.findViewById(R.id.text_pesquisa)
        pesquisaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}