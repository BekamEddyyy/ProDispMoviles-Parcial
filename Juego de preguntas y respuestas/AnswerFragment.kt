import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswerFragment : Fragment() {
    // Campo para almacenar si la respuesta fue correcta o no
    private var isCorrect: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragment
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Recuperar el estado de si la respuesta es correcta de los argumentos
        arguments?.let {
            isCorrect = it.getBoolean("isCorrect", false)
        }

        // Mostrar el feedback de la respuesta
        displayFeedback(view)
    }

    private fun displayFeedback(view: View) {
        // Encuentra el TextView donde mostrarás el feedback
        val feedbackTextView = view.findViewById<TextView>(R.id.feedback_text_view)
        
        // Configurar el texto de feedback dependiendo de si la respuesta fue correcta o no
        if (isCorrect) {
            feedbackTextView.text = "¡Correcto! Buen trabajo."
        } else {
            feedbackTextView.text = "Incorrecto. Intenta nuevamente."
        }
    }

    companion object {
        // Método estático para crear una nueva instancia del fragmento con un argumento
        fun newInstance(isCorrect: Boolean): AnswerFragment {
            val fragment = AnswerFragment()
            val args = Bundle()
            args.putBoolean("isCorrect", isCorrect)
            fragment.arguments = args
            return fragment
        }
    }
}
