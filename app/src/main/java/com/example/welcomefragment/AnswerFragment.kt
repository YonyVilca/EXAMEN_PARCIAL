package com.example.welcomefragment
/**
 * Descripción:EXAMEN PARCIAL.
 * Autor: Yony Alex Vilca Mamani.
 * Fecha: 10/05/2024
 * Modificación: 12/05/2024
 *
 */
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AnswerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

}