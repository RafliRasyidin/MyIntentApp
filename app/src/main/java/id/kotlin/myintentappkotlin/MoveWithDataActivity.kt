package id.kotlin.myintentappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
//intent explicit
class MoveWithDataActivity : AppCompatActivity() {

    //Agar bisa diakses dikelas lain maka harus dimasukan ke dalam companion object
    companion object{
        const val EXTRA_NAME = "extra_name" //membuat constanta untuk mengirim dan menerima data nama dan umur
        const val EXTRA_AGE = "extra_age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received) //inisialisasi variabel TextView dengan id tv_data_received

        val name = intent.getStringExtra(EXTRA_NAME) //mengambil data berdasarkan key, disini keynya adalah EXTRA_NAME
        val age = intent.getIntExtra(EXTRA_AGE, 0)  //mengambil data berdasarkan key, disini keynya adalah EXTRA_AGE dengan default value 0

        val text = "Name : $name, \nYour Age : $age"
        tvDataReceived.text = text
    }
}
