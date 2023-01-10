package com.diyorbek.newintents.models

import android.text.Editable
import java.io.Serializable

data class User(
    val name: String,
    val lastName: String,
    val age: String
): Serializable
