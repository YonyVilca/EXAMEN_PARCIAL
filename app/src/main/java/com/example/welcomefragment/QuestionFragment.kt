package com.example.welcomefragment
/**
 * Descripción:EXAMEN PARCIAL.
 * Autor: Yony Alex Vilca Mamani.
 * Fecha: 10/05/2024
 * Modificación: 12/05/2024
 *
 */
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.welcomefragment.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private lateinit var binding: FragmentQuestionBinding
    private val questions = arrayOf(
        "¿Cuál de las siguientes opciones NO es un lenguaje de programación?",
        "¿Cuál de las siguientes afirmaciones sobre las variables es falsa?",
        "¿Cuál de las siguientes herramientas NO es esencial para los programadores?"
    )
    private val options = arrayOf(
        arrayOf("Java", "C++", "Microsoft Word"),
        arrayOf("almacenar datos", "diferentes tipos", "variable debe ser único"),
        arrayOf("Un navegador web", "Un editor de código", "Un compilador o intérprete")
    )

    private val correctAnswers = arrayOf(2, 2, 0)
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento utilizando el enlace de datos
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Mostrar la primera pregunta al crear la vista
        displayQuestion()
        // Configurar los listeners de los botones de opción
        binding.option1Button.setOnClickListener {
            checkAnswer(0)
        }
        binding.option2Button.setOnClickListener {
            checkAnswer(1)
        }
        binding.option3Button.setOnClickListener {
            checkAnswer(2)
        }
    }

    private fun correctButtonColors(buttonIndex: Int) {
        // Cambiar el color de fondo del botón seleccionado a verde (indicando una respuesta correcta)
        when (buttonIndex) {
            0 -> binding.option1Button.setBackgroundColor(Color.GREEN)
            1 -> binding.option2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.option3Button.setBackgroundColor(Color.GREEN)
        }
    }

    private fun wrongButtonColors(buttonIndex: Int) {
        // Cambiar el color de fondo del botón seleccionado a rojo (indicando una respuesta incorrecta)
        when (buttonIndex) {
            0 -> binding.option1Button.setBackgroundColor(Color.RED)
            1 -> binding.option2Button.setBackgroundColor(Color.RED)
            2 -> binding.option3Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColors() {
        // Restablecer el color de fondo de los botones a su estado original
        binding.option1Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option2Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option3Button.setBackgroundColor(Color.rgb(50, 59, 96))
    }

    private fun showResults() {
        // Mostrar los resultados del cuestionario en un Toast
        Toast.makeText(requireContext(), "Tu puntaje: $score out of ${questions.size}", Toast.LENGTH_LONG).show()
        // Si el botón de reinicio está en el mismo layout, habilita su funcionalidad aquí
    }

    private fun displayQuestion() {
        // Mostrar la pregunta actual y las opciones en la interfaz de usuario
        binding.questionText.text = questions[currentQuestionIndex]
        binding.option1Button.text = options[currentQuestionIndex][0]
        binding.option2Button.text = options[currentQuestionIndex][1]
        binding.option3Button.text = options[currentQuestionIndex][2]
        resetButtonColors()
    }

    private fun checkAnswer(selectedAnswerIndex: Int) {
        // Verificar si la respuesta seleccionada es correcta o incorrecta
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]
        if (selectedAnswerIndex == correctAnswerIndex) {
            // Incrementar la puntuación y cambiar el color del botón seleccionado a verde
            score++
            correctButtonColors(selectedAnswerIndex)
        } else {
            // Cambiar el color del botón seleccionado a rojo y el color del botón correcto a verde
            wrongButtonColors(selectedAnswerIndex)
            correctButtonColors(correctAnswerIndex)
        }
        if (currentQuestionIndex < questions.size - 1) {
            // Si hay más preguntas, mostrar la siguiente pregunta después de un retraso de 1 segundo
            currentQuestionIndex++
            binding.questionText.postDelayed({ displayQuestion() }, 1000)
        } else {
            // Si no hay más preguntas, mostrar los resultados del cuestionario
            showResults()
        }
    }
}