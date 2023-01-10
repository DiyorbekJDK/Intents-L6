package com.diyorbek.newintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import com.diyorbek.newintents.models.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text: TextView = findViewById(R.id.textView)

        val user = intent.getSerializableExtra("user") as User
        text.text = "${user.name}\n" +
                "${user.lastName}\n" +
                "${user.age}"
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent()
            val bundle = bundleOf("user1" to User("Kotlin", "Android", "10"))
            intent.putExtras(bundle)
            setResult(100, intent)
            finish()
        }

    }
}