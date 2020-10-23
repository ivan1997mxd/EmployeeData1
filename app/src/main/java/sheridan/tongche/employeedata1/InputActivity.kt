package sheridan.tongche.employeedata1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sheridan.tongche.employeedata1.OutputActivity.Companion.EMPLOYEE
import sheridan.tongche.employeedata1.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener { showOutput() }
    }

    private fun showOutput() {
        val name = binding.nameInput.text.toString().trim()
        if (name.isEmpty()) {
            val required = "Name Cannot be empty"
            binding.nameInput.error = required
            Toast.makeText(this, required, Toast.LENGTH_LONG).show()
        } else {
            val trained = binding.isTrained.isChecked
            val certified = binding.isCertified.isChecked
            val employee = Employee(name, trained, certified)
            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra(EMPLOYEE,employee)
            startActivity(intent)
        }
    }
}