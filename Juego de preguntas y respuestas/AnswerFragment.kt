import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AnswerFragment : Fragment() {
    private var isCorrect: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            isCorrect = AnswerFragmentArgs.fromBundle(it).isCorrect
        }

        view.findViewById<TextView>(R.id.feedback_text_view).text =
            if (isCorrect) "¡Correcto! Buen trabajo." else "Incorrecto. Intenta nuevamente."

        view.findViewById<Button>(R.id.next_button).setOnClickListener {
            if (isCorrect) {
                findNavController().navigate(R.id.action_answerFragment_to_nextQuestion)
            } else {
                findNavController().popBackStack()
            }
        }
    }
}
