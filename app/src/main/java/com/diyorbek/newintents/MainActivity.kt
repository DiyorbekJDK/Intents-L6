package com.diyorbek.newintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.diyorbek.newintents.models.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById(R.id.btnNext)

        btn.setOnClickListener {
            val editName: EditText = findViewById(R.id.editTextName)
            val editLastName: EditText = findViewById(R.id.editTextLastName)
            val editAge: EditText = findViewById(R.id.editTextAge)
            val intent = Intent(this, SecondActivity::class.java)
            val name = editName.text
            val lastName = editLastName.text
            val age = editAge.text
            val user = User(name.toString(), lastName.toString(), age.toString())
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

    private val registryActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 100){
                val user = it?.data?.getSerializableExtra("user1") as User
                val textView: TextView = findViewById(R.id.textView2)
                textView.text = "${user.name}\n${user.lastName}\n${user.age}"
            }
        }
}