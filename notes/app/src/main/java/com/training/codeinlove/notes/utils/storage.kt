package com.training.codeinlove.notes.utils

import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.training.codeinlove.notes.Note
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.UUID

private const val TAG = "storage"

fun persistNote(context: Context, note: Note) {
    if (TextUtils.isEmpty(note.id)) {
        note.id = UUID.randomUUID().toString()
    }
    val fileName = note.id + ".note"
    val fileOutput = context.openFileOutput(fileName, Context.MODE_PRIVATE)
    val outputStream = ObjectOutputStream(fileOutput)
    outputStream.writeObject(note)
    outputStream.close()
}

fun loadNotes(context: Context): List<Note> {
    return context.filesDir.list()?.map { loadNote(context, it) }
        ?.onEach { Log.i(TAG, "Loaded note $it") }
        ?: emptyList()
}

fun deleteNote(context: Context, noteToDelete: Note) {
    val fileName = noteToDelete.id + ".note"
    context.deleteFile(fileName)
}

private fun loadNote(context: Context, fileName: String): Note {
    val fileInputStream = context.openFileInput(fileName)
    val inputStream = ObjectInputStream(fileInputStream)
    val note = inputStream.readObject() as Note
    inputStream.close()
    return note
}