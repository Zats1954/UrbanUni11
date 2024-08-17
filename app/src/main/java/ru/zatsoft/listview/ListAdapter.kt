package ru.zatsoft.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(private val context: Context, dataList: MutableList<User> )
                                  :ArrayAdapter<User>(context,R.layout.list_item,dataList){

    override fun getView(position: Int, view: View?, parent: ViewGroup): View{
         view?.let {
             val data = getItem(position)
             val tvName = view.findViewById<TextView>(R.id.tvName)
             val tvAge = view.findViewById<TextView>(R.id.tvAge)
             tvName.text = data?.name
             tvAge.text = data?.age.toString()
             return view
         } ?:return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
    }
}