package com.example.myfirstanaltry

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import org.json.JSONObject
import java.lang.Exception
import java.net.URLEncoder
import khttp.*

class Register_window : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_window)
        var btt: Button = findViewById(R.id.already_exist);
        var btt2: Button = findViewById(R.id.button_enter);
        btt.setOnClickListener{
            val siwIntent= Intent(this, MainActivity::class.java);
            siwIntent.flags=Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
            startActivity(siwIntent);
        }
        btt2.setOnClickListener{
            var username: com.rengwuxian.materialedittext.MaterialEditText = findViewById(R.id.reg_surname_login)
            var name: com.rengwuxian.materialedittext.MaterialEditText = findViewById(R.id.reg_name_login)
            var email: com.rengwuxian.materialedittext.MaterialEditText = findViewById(R.id.sign_email_login)
            var pass: com.rengwuxian.materialedittext.MaterialEditText = findViewById(R.id.sign_passward)
            var Rec = object : RequestAsync(username = username.text.toString(),email = email.text.toString(),name = URLEncoder.encode(name.text.toString(),"utf-8"),pass = pass.text.toString()){
                override protected fun onPreExecute() {
                    var Post: JSONObject = JSONObject()
                    Post.put("username",username);
                    Post.put("email",email);
                    Post.put("name",name);
                    Post.put("password",pass);
                    Toast.makeText(applicationContext,Post.toString(), Toast.LENGTH_LONG).show()
                }
                override protected fun onPostExecute(result: String?) {
                    if(result!=null) Toast.makeText(applicationContext,result.toString(), Toast.LENGTH_LONG).show()
                }
            }
            Rec.execute();

        }
    }
    open class RequestAsync(var username :String , var email: String , var name: String ,var pass: String): AsyncTask<String, String, String>() {

        override protected fun doInBackground(vararg params: String?): String {
            try {
                var Post: JSONObject = JSONObject()
                Post.put("username",username);
                Post.put("email",email);
                Post.put("name",name);
                Post.put("password",pass);
                return Post("http://79.174.13.160/?format=openapi#definitions/User", Post);
            }
            catch (e: Exception){
                return e.message.toString();
            }
        }
    }
}

