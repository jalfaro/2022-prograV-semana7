package gt.edu.galileo.a2022progravsemana7.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Persona(
    val nombre: String,
    val genero: String,
    val avatar: Int
): Parcelable
