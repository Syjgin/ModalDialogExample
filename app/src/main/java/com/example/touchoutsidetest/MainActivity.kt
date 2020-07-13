package com.example.touchoutsidetest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        red_button.setOnClickListener {
            Toast.makeText(this, "red button click", Toast.LENGTH_SHORT).show()
        }
        Handler(Looper.getMainLooper()).postDelayed({
            val modalDialog = ModalDialogFragment()
            modalDialog.show(supportFragmentManager, "TAG")
        }, 5000)
    }
}
