package ru.zatsoft.listview

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialog : DialogFragment() {
    lateinit var removable: Removable

    override fun onAttach(context: Context) {
        super.onAttach(context)
        removable = context as Removable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val user = requireArguments().getParcelable<User>("user")
        val builder = AlertDialog.Builder(requireActivity())
        return builder
            .setTitle("Удаление пользователя")
            .setMessage("Удаляем \"${user?.name}\" ?")
            .setIcon(R.drawable.ic_remove)
            .setPositiveButton("Да") { dialog, ind ->
                user?.let { removable.remove(it) }
            }
            .setNegativeButton("Отмена", null)
            .create()
    }
}