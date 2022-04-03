package gt.edu.galileo.a2022progravsemana7.view

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
import gt.edu.galileo.a2022progravsemana7.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewmodel :LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.btnIngresar.setOnClickListener {
            val login = viewmodel.login(binding.txtUser.text.toString(), binding.txtPassword.text.toString())
            if (!login) {
                Toast.makeText(context, "Usuario/Password no valido", Toast.LENGTH_LONG).show()
            }
        }
        viewmodel.isLogged.observe(viewLifecycleOwner, {
            if (it) {
                binding.root.findNavController().navigate(R.id.action_loginFragment_to_menuFragment)
            }
        })
        viewmodel.loginStatus()
        return binding.root
    }
}