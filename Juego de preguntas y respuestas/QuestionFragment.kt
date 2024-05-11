import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuestionFragment : Fragment() {

    private var currentQuestionIndex = 0
    private val questions = listOf(
        Question("¿Cuál es la capital de Francia?", listOf("París", "Madrid", "Berlín", "Londres"), 0),
        Question("¿Cuánto es 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("¿En qué continente está Egipto?", listOf("Europa", "Asia", "África", "Australia"), 2)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupQuestion(view)
    }

    private fun setupQuestion(view: View) {
        view.findViewById<TextView>(R.id.question_text).text = questions[currentQuestionIndex].text
        val radioGroup = view.findViewById<RadioGroup>(R.id.answer_group)
        questions[currentQuestionIndex].options.forEachIndexed { index, option ->
            (radioGroup.getChildAt(index) as RadioButton).text = option
        }

        view.findViewById<Button>(R.id.answer_button).setOnClickListener {
            val selectedOptionIndex = radioGroup.indexOfChild(view.findViewById(radioGroup.checkedRadioButtonId))
            val action = QuestionFragmentDirections.actionQuestionFragmentToAnswerFragment(
                selectedOptionIndex == questions[currentQuestionIndex].correctAnswer
            )
            findNavController().navigate(action)
        }
    }

    data class Question(val text: String, val options: List<String>, val correctAnswer: Int)
}
