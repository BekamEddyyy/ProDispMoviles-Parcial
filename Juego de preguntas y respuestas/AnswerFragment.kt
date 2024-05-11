import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

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
        displayFeedback()
    }

    private fun displayFeedback() {
        // Mostrar si la respuesta es correcta y por qué
    }

    companion object {
        fun newInstance(isCorrect: Boolean): AnswerFragment {
            val fragment = AnswerFragment()
            val args = Bundle()
            args.putBoolean("isCorrect", isCorrect)
            fragment.arguments = args
            return fragment
        }
    }
}
