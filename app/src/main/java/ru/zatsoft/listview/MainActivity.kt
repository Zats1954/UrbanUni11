package ru.zatsoft.listview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.listview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolBar: Toolbar
    private var list = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.toolbarMain
        setSupportActionBar( toolBar)
        title = " "
        val listAdapter =ListAdapter(this, list)
        binding.listView.adapter = listAdapter
        binding.save.setOnClickListener {
            val user = User(binding.edName.text.toString(),binding.edAge.text.toString().toInt())
            list.add(user)
            listAdapter.notifyDataSetChanged()
            binding.edName.text.clear()
            binding.edAge.text.clear()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        if(item.itemId == R.id.exit)
            finish()
        return super.onOptionsItemSelected(item)
    }

    fun onButtonClick(view: View){
        val user = User(binding.edName.text.toString(),binding.edAge.text.toString().toInt())
        list.add(user)
        list

    }
}