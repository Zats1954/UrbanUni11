package ru.zatsoft.parcelable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ListAdapter(private val context: Context, dataList: MutableList<Person> )
                                  :ArrayAdapter<Person>(context, R.layout.list_item,dataList){

    override fun getView(position: Int, view: View?, parent: ViewGroup): View{
         view?.let {
             val data = getItem(position)
             val tvName = view.findViewById<TextView>(R.id.tvName)
             val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
             val color = when(position % 3){
                       0 -> R.color.white
                       1 -> R.color.blue
                       2 -> R.color.red
                 else -> R.color.white
             }
             it.setBackgroundColor(getContext().getColor(color) )
             tvName.text = data?.name
             tvLastName.text = data?.lastName
             return view
         } ?:return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
    }
}