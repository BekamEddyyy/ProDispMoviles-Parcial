import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class QuestionFragment : Fragment() {
    private lateinit var currentQuestion: Question

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showQuestion()
    }

    private fun showQuestion() {
        // Mostrar pregunta y opciones
    }

    companion object {
        fun newInstance(): QuestionFragment {
            return QuestionFragment()
        }
    }
}
