package com.training.codeinlove.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class ConfirmDeleteDialogFragment : DialogFragment() {

    interface ConfirmDeleteListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    private val TAG = ConfirmDeleteDialogFragment::class.java.simpleName

    var listener: ConfirmDeleteListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Supprimer tout les contenu du téléphone ?")
            .setPositiveButton("Oh oui !") { _, _ ->
                Log.i(TAG, "Youpi ! On va tout casser :)")
                listener?.onDialogPositiveClick()
            }
            .setNegativeButton("Heu non !") { _, _ ->
                Log.i(TAG, "Bon ben cela sera pour la prochaine fois")
                listener?.onDialogNegativeClick()
            }

        return builder.create()
    }
}