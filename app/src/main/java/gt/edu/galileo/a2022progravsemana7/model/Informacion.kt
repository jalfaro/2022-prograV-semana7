package gt.edu.galileo.a2022progravsemana7.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Informacion(
    val descripcion: String,
    val icono: Int,
    val email: String
): Parcelable
