package dev.bogibek.dastgoh.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.bogibek.dastgoh.R
import dev.bogibek.dastgoh.adapter.Adapter
import dev.bogibek.dastgoh.databinding.ActivityMainBinding
import dev.bogibek.dastgoh.model.Detal

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<Detal>
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadList()
        setupUI()
    }

    private fun setupUI() {
        adapter = Adapter(list)
        binding.apply {
            rvMain.adapter = adapter
            adapter.itemClick = {
                openDetail(it)
            }
        }
    }

    private fun openDetail(detal: Detal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("detal", detal)
        startActivity(intent)
    }


    private fun loadList() {
        list = ArrayList()
        list.add(Detal(R.drawable.img, "1. Asos", "Stanokni o’rnatuvchi stol"))
        list.add(Detal(R.drawable.img, "2. Elektrodvigatel", "Elektr energiyasini mehanik energiyaga aylantirib beradi"))
        list.add(Detal(R.drawable.img, "3. Tasmali uzatma himoyalagichi", "Tasmani turli tashqi ta’sirlardan saqlash uchun xizmat qiladi"))
        list.add(Detal(R.drawable.img, "4. Ulab ajratish tugmalari", "Stanokni ishga tushirish va to’xtatish uchun xizmat qiladi"))
        list.add(Detal(R.drawable.img, "5. Stanina", "stonokni barcha detallarini mahkamlash vazifasini bajaradi"))
        list.add(Detal(R.drawable.img, "6. Oldingi babka", "Shpindelni mahkamlab turadi va elektrodvigateldan kelgan mexanik energiyani shpindelga uzatish vazifasini bajaradi"))
        list.add(Detal(R.drawable.img, "7. Shpinde (patron)", "Zagatovkani old tomondan markaziy o’q bo’yicha mahkamlash uchun xizmat qiladi"))
        list.add(Detal(R.drawable.img, "8. Trgak", "Zagatovkaga ishlov berishda iskanalarni ilgarilanma va qaytma harakatlanishini amalga oshirish uchun xizmat qiladi"))
        list.add(Detal(R.drawable.img, "9. Ximoya oynasi", "Zagatovkaga ishlov berilyotgan paytda uchib chiquvchi yog’och payrahalardan saqlash vazifasini bajaradi"))
        list.add(Detal(R.drawable.img, "10. Ketingi babka", "Zagatovkani ketingi tomonidan markaziy o’q bo’yicha mahkamlash va siqib turish vazifasini bajaradi"))
        list.add(Detal(R.drawable.img, "11. Yoritgich", "Zagatovkaga ishlov berishda ish o’rnini yoritish uchun xizmat qiladi"))
    }
}
