package com.training.codeinlove.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val NEW_NOTE_INDEX = -1

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        findViewById<FloatingActionButton>(R.id.create_note_fab).setOnClickListener(this)

        notes = mutableListOf()
        notes.add(Note("Note 1", "Blablabla"))
        notes.add(Note("Memo Bob", "Range ton linge"))
        notes.add(Note("Memo Bobby", "Fais la vaiselle"))
        adapter = NoteAdapter(notes, this)
        val recycleView = findViewById<RecyclerView>(R.id.notes_recycle_view)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            showNoteDetail(view.tag as Int)
        } else {
            when(view.id) {
                R.id.create_note_fab -> createNewNote()
            }
        }
    }

    private fun createNewNote() {
        showNoteDetail(NEW_NOTE_INDEX)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != RESULT_OK || data == null) {
            return
        }
        when (requestCode) {
            NoteDetailActivity.REQUEST_EDIT_NOTE -> processEditNoteResult(data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun processEditNoteResult(data: Intent) {
        val noteIndex = data.getIntExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, NEW_NOTE_INDEX)
        val note = data.getParcelableExtra<Note>(NoteDetailActivity.EXTRA_NOTE)
        saveNote(note!!, noteIndex)
    }

    private fun saveNote(note: Note, noteIndex: Int) {
        if (noteIndex < 0) {
            notes.add(0, note)
        } else {
            notes[noteIndex] = note
        }
        adapter.notifyDataSetChanged()
    }

    private fun showNoteDetail(noteIndex: Int) {
        val note = if (noteIndex < 0) Note() else notes[noteIndex]
        val intent = Intent(this, NoteDetailActivity::class.java)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE, note)
        intent.putExtra(NoteDetailActivity.EXTRA_NOTE_INDEX, noteIndex)
        startActivityForResult(intent, NoteDetailActivity.REQUEST_EDIT_NOTE)
    }
}