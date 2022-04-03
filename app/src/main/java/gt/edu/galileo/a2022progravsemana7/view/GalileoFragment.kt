package gt.edu.galileo.a2022progravsemana7.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gt.edu.galileo.a2022progravsemana7.R
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentGalileoBinding
import gt.edu.galileo.a2022progravsemana7.model.Informacion

class GalileoFragment : Fragment() {
    private lateinit var binding: FragmentGalileoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGalileoBinding.inflate(layoutInflater, container, false)
        val info = arguments?.getParcelable<Informacion>("info")
        binding.info = info
        binding.logo.setImageResource(info?.icono ?: R.drawable.mickey)
        /*
        binding.email.text = info?.email

        binding.descripcion.text = info?.descripcion
        */
        return binding.root
    }

}