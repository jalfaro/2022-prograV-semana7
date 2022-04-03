package gt.edu.galileo.a2022progravsemana7.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import gt.edu.galileo.a2022progravsemana7.R
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentLoginBinding
import gt.edu.galileo.a2022progravsemana7.databinding.FragmentMenuBinding
import gt.edu.galileo.a2022progravsemana7.viewmodel.MenuViewModel


class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewmodel : MenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(MenuViewModel::class.java)
        binding.btnFormulario.setOnClickListener {
            Toast.makeText(context, "Nombre", Toast.LENGTH_LONG).show()
            binding.root.findNavController().navigate(R.id.action_menuFragment_to_formFragment)
        }
        binding.btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:34567890"))
            startActivity(intent)
        }
        binding.btnPagina.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            viewmodel.logout()
            binding.root.findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }
        return binding.root
    }
}