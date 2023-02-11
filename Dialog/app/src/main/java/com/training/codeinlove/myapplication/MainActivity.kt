package com.training.codeinlove.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.show_dialog_btn).setOnClickListener {
            val fragment = ConfirmDeleteDialogFragment()
            fragment.listener = object : ConfirmDeleteDialogFragment.ConfirmDeleteListener {
                override fun onDialogPositiveClick() {
                    Log.i("MainActivity", "onDialogPositiveClick()")
                    val fileListDialogFragment = FileListDialogFragment()
                    fileListDialogFragment.show(supportFragmentManager, "fileList")
                }

                override fun onDialogNegativeClick() {
                    Log.i("MainActivity", "onDialogNegativeClick()")
                }

            }
            fragment.show(supportFragmentManager, "confirmDialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
        R.id.acton_add -> {
            Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.acton_delete -> {
            Toast.makeText(this, "Supprimer", Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}