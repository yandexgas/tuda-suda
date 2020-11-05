package com.example.myfirstanaltry
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn: Button = findViewById(R.id.register_button);
        btn.setOnClickListener{
            val rwIntent=Intent(this,Register_window::class.java);
            rwIntent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
            startActivity(rwIntent);
        }
    }
}