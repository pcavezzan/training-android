package com.training.codeinlove.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        val REQUEST_EDIT_NOTE = 1
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"
        val ACTION_SAVE_NOTE = "com.training.codeinlove.notes.ACTION_SAVE_NOTE"
        val ACTION_DELETE_NOTE = "com.training.codeinlove.notes.ACTION_DELETE_NOTE"
    }

    lateinit var note: Note
    var noteIndex: Int = -1
    lateinit var titleView: TextView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        note = intent.getParcelableExtra(EXTRA_NOTE)!!
        noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)

        titleView = findViewById(R.id.title)
        textView = findViewById(R.id.text)

        titleView.text = note.title
        textView.text = note.title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_note_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save -> saveNote()
            R.id.action_delete -> showDeleteConfirmDialog()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDeleteConfirmDialog(): Boolean {
        val confirmDeleteNoteDialogFragment = ConfirmDeleteNoteDialogFragment(note.title)
        confirmDeleteNoteDialogFragment.listener = object : ConfirmDeleteNoteDialogFragment.ConfirmDeleteDialogListener {
            override fun onDialogPositiveClick() {
                deleteNote()
            }

            override fun onDialogNegativeClick() {}

        }
        confirmDeleteNoteDialogFragment.show(supportFragmentManager, "confirmDeleteNote")
        return true
    }

    private fun deleteNote() {
        val intent = Intent(ACTION_DELETE_NOTE)
        intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
        setResult(RESULT_OK)
        finish()
    }

    private fun saveNote(): Boolean {
        note.title = titleView.text.toString()
        note.text = textView.text.toString()
        val intent = Intent(ACTION_SAVE_NOTE)
        intent.putExtra(EXTRA_NOTE, note)
        intent.putExtra(EXTRA_NOTE_INDEX, noteIndex)
        setResult(RESULT_OK, intent)
        finish()
        return true
    }
}