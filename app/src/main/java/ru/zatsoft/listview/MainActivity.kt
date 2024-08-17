package ru.zatsoft.listview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.listview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Removable {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolBar: Toolbar
    private var list = mutableListOf<User>()
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.toolbarMain
        setSupportActionBar( toolBar)
        title = " "
        listAdapter =ListAdapter(this, list)
        binding.listView.adapter = listAdapter
        binding.save.setOnClickListener {
            val user = User(binding.edName.text.toString(),binding.edAge.text.toString().toInt())
            list.add(user)
            listAdapter.notifyDataSetChanged()
            binding.edName.text.clear()
            binding.edAge.text.clear()
        }
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener{ parent, view, position, id ->
                val selectedUser = listAdapter.getItem(position)
                val dialog = MyDialog()
                val args = Bundle()
                args.putParcelable("user", selectedUser)
                dialog.arguments = args
                dialog.show(supportFragmentManager,"custom")
                listAdapter.notifyDataSetChanged()
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

    override fun remove(user: User) {
        listAdapter.remove(user)
    }
}