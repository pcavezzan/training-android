package com.training.codeinlove.notes

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteDialogFragment(
    val noteTitle: String = ""
) : DialogFragment() {

    interface ConfirmDeleteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Etes - vous sûre de vouloir supprimer la note $noteTitle ?")
            .setPositiveButton("Supprimer") { _, _ -> listener?.onDialogPositiveClick() }
            .setNegativeButton("Annuler") { _, _ -> listener?.onDialogNegativeClick() }
        return builder.create()
    }
}