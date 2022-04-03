package gt.edu.galileo.a2022progravsemana7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.findNavController
import gt.edu.galileo.a2022progravsemana7.R
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentFormBinding
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentLoginBinding
import gt.edu.galileo.a2022progravsemana7.model.Persona


class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(inflater, container, false)
        (binding.rgGenero.getChildAt(0) as RadioButton).isChecked = true
        binding.btnGrabar.setOnClickListener {
            var avatar = R.drawable.mickey
          when(binding.spnAvatar.selectedItemId + 1) {
              1L -> avatar = R.drawable.mickey
              2L -> avatar = R.drawable.goofy
              3L -> avatar = R.drawable.donald
          }
            var persona = Persona(
                binding.txtNombre.text.toString(),
                if ((binding.rgGenero.getChildAt(0) as RadioButton).isChecked) "M" else "F",
                avatar
            )
            val action = FormFragmentDirections.actionFormFragmentToDisplayFragment(persona)
            binding.root.findNavController().navigate(action);
        }
        return binding.root
    }
}