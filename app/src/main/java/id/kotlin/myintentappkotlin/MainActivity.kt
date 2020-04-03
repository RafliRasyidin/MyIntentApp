package id.kotlin.myintentappkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity) //inisialisasi tombol button dengan id move_activity
        btnMoveActivity.setOnClickListener(this) //membuat event click pada tombol button atau objek btnMoveActivity

        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_data) //inisialisasi tombol button dengan id move_activity_data
        btnMoveActivityData.setOnClickListener(this) //membuat event click pada tombol button atau objek btnMoveActivityData

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number) //inisialisasi tombol button dengan id btn_dial_number
        btnDialPhone.setOnClickListener(this) //membuat event click pada tombol button atau objek btnDialPhone
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_move_activity ->{  //kelas asal selalu menggunakan this, dan kelas tujuan selalu menggunakan class.java
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java) //membuat objek intent dengan this@MainActivity sebagai kelas Activity asal dan MoveActivity::class.java sebagai kelas Activity tujuan
                startActivity(moveIntent) //metode ini akan menjalankan activity baru tanpa membawa data
            }

            R.id.btn_move_activity_data ->{
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Rafli Rasyidin") //metode putExtra() untuk mengirimkan data bersamaan dengan objek intent
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20) //metode putExtra() merupakan metode yang menampung pasangan KEY-VALUE.
                startActivity(moveWithDataIntent)
            }

            //implicit intent
            R.id.btn_dial_number ->{
                val phoneNumber = "089665710013"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")) //penggunaan implicit intent untuk melakukan proses dial menggunakan ACTION_DIAL, Uri adalah sebuah untaian karakter yang digunakan untuk mengidentifikasi nama, sumber, atau layanan di internet
                startActivity(dialPhoneIntent)                     //Uri.parse("tel:$phoneNumber") tel sebagai skema untuk sumber daya telpon, skema lain seperti "geo" untuk peta, "http" untuk browser dll.
            }
        }
    }
}
