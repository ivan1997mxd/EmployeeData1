package sheridan.tongche.employeedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.tongche.employeedata1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutputBinding
    companion object{
        const val EMPLOYEE = "employee"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.employee = intent.getSerializableExtra(EMPLOYEE) as Employee

        binding.back.setOnClickListener { finish() }
    }
}