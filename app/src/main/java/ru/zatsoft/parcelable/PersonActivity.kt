package ru.zatsoft.parcelable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zatsoft.parcelable.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val person =   intent.extras?.getParcelable("person") as? Person
        binding.tvName.text = "Имя: ${person?.name}"
        binding.tvLastName.text = "Фамилия: ${person?.lastName}"
        binding.tvAddress.text =  "Адрес: ${person?.address}"
        binding.tvTelephone.text = "Телефон: ${person?.telephone}"
        binding.button.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}