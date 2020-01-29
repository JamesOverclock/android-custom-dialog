package com.l3ios.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btnDialog?.setOnClickListener {
            CustomDialog.newInstance().apply {
                onOkClickListener = {
                    Toast.makeText(this@MainActivity, "Ok Clicked", Toast.LENGTH_SHORT).show()
                }

                onCloseClickListener = {
                    Toast.makeText(this@MainActivity, "Cancel Clicked", Toast.LENGTH_SHORT).show()
                }
            }.run { show(supportFragmentManager, "") }
        }
    }
}
