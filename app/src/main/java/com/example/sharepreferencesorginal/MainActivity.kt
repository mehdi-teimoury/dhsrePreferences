package com.example.sharepreferencesorginal

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bt_save =findViewById<Button>(R.id.btsave)
        val bt_load =findViewById<Button>(R.id.btload)
        val ed_text =findViewById<EditText>(R.id.edtext)

        var  userpref : SharedPreferences? = null
        userpref = getSharedPreferences("userdata", Context.MODE_PRIVATE)


        bt_save.setOnClickListener {
            val editor = userpref.edit()
            editor.putString("useID", ed_text.text.toString())
            editor.apply()
            Toast.makeText(this,"اطلاعات کاربر ‌ذخیره شد",10).show()

        }
        bt_load.setOnClickListener {
            ed_text.setText(userpref.getString("useID","").toString())
            Toast.makeText(this,"اطلاعات خوانده شد",10).show()
        }
    }



}
