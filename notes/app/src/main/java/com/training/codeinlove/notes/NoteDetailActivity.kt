package com.training.codeinlove.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"
    }

    lateinit var note: Note
    var nodeIndex: Int = -1
    lateinit var titleView: TextView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        note = intent.getParcelableExtra(EXTRA_NOTE)!!
        nodeIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)

        titleView = findViewById(R.id.title)
        textView = findViewById(R.id.text)

        titleView.text = note.title
        textView.text = note.title
    }
}