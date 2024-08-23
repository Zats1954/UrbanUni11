package ru.zatsoft.parcelable

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.zatsoft.parcelable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Removable {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolBar: Toolbar
    private var list = mutableListOf<Person>()
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
            val person = Person(binding.edName.text.toString(),
                                binding.edLastName.text.toString(),
                                binding.edAddress.text.toString(),
                                binding.edTelephon.text.toString()
            )
            list.add(person)
            listAdapter.notifyDataSetChanged()
            binding.edName.text.clear()
            binding.edLastName.text.clear()
            binding.edAddress.text.clear()
            binding.edTelephon.text.clear()
        }
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener{ parent, view, position, id ->
                val selectedUser = listAdapter.getItem(position)
//                val dialog = MyDialog()
                val intent = Intent(this, PersonActivity::class.java )
                intent.putExtra("person", selectedUser)
                 startActivity(intent)
//                dialog.arguments = args
//                dialog.show(supportFragmentManager,"custom")
//                listAdapter.notifyDataSetChanged()
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

    override fun remove(person: Person) {
        listAdapter.remove(person)
    }
}