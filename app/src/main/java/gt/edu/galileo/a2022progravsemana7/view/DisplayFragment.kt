package gt.edu.galileo.a2022progravsemana7.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import gt.edu.galileo.a2022progravsemana7.R
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentDisplayBinding
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentLoginBinding
import gt.edu.galileo.a2022progravsemana7.model.Informacion
import gt.edu.galileo.a2022progravsemana7.model.Persona


class DisplayFragment : Fragment() {
    private lateinit var binding: FragmentDisplayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDisplayBinding.inflate(inflater, container, false)
        val persona = arguments?.getParcelable<Persona>("persona")
        binding.imgAvatar.setImageResource(persona?.avatar ?: R.drawable.mickey)
        binding.txtNombre.text = persona?.nombre
        binding.lytContainer.setBackgroundColor(if (persona?.genero.equals("F")) Color.YELLOW else Color.BLUE)
        binding.imgAvatar.setOnClickListener{
            val info = Informacion("Esta es una universidad muy prestigiosa, blab lbalalbla", R.drawable.galileo_logo, "jalfaro@galileo.edu")
            var action = DisplayFragmentDirections.actionDisplayFragmentToGalileoFragment(info)
            binding.root.findNavController().navigate(action)
        }
        return binding.root
    }
}