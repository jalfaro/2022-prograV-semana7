package gt.edu.galileo.a2022progravsemana7.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val app: Application) : AndroidViewModel(app) {
    val isLogged = MutableLiveData<Boolean>(false)
    val sharedPref = app?.getSharedPreferences("keys", Context.MODE_PRIVATE)

    fun login(user:String, password: String): Boolean {
       val login =  user.lowercase().equals("julio") && password.equals("Abcdef")
        if (login) {
            with(sharedPref.edit()) {
                putString("user", user)
                commit()
            }
        }
        isLogged.value = login
       return login
    }

    fun loginStatus() {
        val login = !sharedPref.getString("user", "").equals("")
        isLogged.value = login
    }
}