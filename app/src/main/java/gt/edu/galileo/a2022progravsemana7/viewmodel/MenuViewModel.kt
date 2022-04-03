package gt.edu.galileo.a2022progravsemana7.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

class MenuViewModel(app: Application) : AndroidViewModel(app) {
    val sharedPref = app.getSharedPreferences("keys", Context.MODE_PRIVATE)
    fun logout() {
        with(sharedPref.edit()) {
            putString("user", "")
            commit()
        }
    }
}