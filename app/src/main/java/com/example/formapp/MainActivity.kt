package com.example.formapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var btnSubmit: Button
    private lateinit var tvHasil: TextView

    private lateinit var cbMembaca: CheckBox
    private lateinit var cbGame: CheckBox
    private lateinit var cbMusik: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // INISIALISASI VIEW (WAJIB SESUAI ID XML)
        etNama = findViewById(R.id.etNama)
        rgGender = findViewById(R.id.rgGender)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvHasil = findViewById(R.id.tvHasil)

        cbMembaca = findViewById(R.id.cbMembaca)
        cbGame = findViewById(R.id.cbGame)
        cbMusik = findViewById(R.id.cbMusik)

        btnSubmit.setOnClickListener {

            val nama = etNama.text.toString().trim()

            // VALIDASI NAMA
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong!"
                return@setOnClickListener
            }

            // VALIDASI GENDER
            val selectedId = rgGender.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Pilih gender dulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedId).text.toString()

            // AMBIL HOBI
            val hobiList = ArrayList<String>()

            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbGame.isChecked) hobiList.add("Gaming")
            if (cbMusik.isChecked) hobiList.add("Musik")

            val hobi = if (hobiList.isEmpty()) "Tidak ada"
            else hobiList.joinToString(", ")

            // OUTPUT
            val hasil = "Nama: $nama\nGender: $gender\nHobi: $hobi"

            tvHasil.text = hasil
        }
    }
}