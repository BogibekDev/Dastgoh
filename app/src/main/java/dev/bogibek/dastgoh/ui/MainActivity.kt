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
        list.add(Detal(R.drawable.asos1, "1. Asos", "Stanokni o’rnatuvchi stol"))
        list.add(Detal(R.drawable.elektrodivigatel2, "2. Elektrodvigatel", "Elektr energiyasini mehanik energiyaga aylantirib beradi"))
        list.add(Detal(R.drawable.stanina3, "3. Stanina", "stonokni barcha detallarini mahkamlash vazifasini bajaradi"))
        list.add(Detal(R.drawable.tas4, "4. Tasmali uzatma himoyalagichi", "Tasmani turli tashqi ta’sirlardan saqlash uchun xizmat qiladi"))
        list.add(Detal(R.drawable.ulab_ajrtgich5, "5. Ulab ajratish tugmalari", "Stanokni ishga tushirish va to’xtatish uchun xizmat qiladi"))
        list.add(Detal(R.drawable.oldingi_bobka6, "6. Oldingi babka", "Shpindelni mahkamlab turadi va elektrodvigateldan kelgan mexanik energiyani shpindelga uzatish vazifasini bajaradi"))
        list.add(Detal(R.drawable.shpindel7, "7. Shpinde (patron)", "Zagatovkani old tomondan markaziy o’q bo’yicha mahkamlash uchun xizmat qiladi"))
        list.add(Detal(R.drawable.trgak8, "8. Tirgak", "Zagatovkaga ishlov berishda iskanalarni ilgarilanma va qaytma harakatlanishini amalga oshirish uchun xizmat qiladi"))
        list.add(Detal(R.drawable.ketingi_bobka9, "9. Ketingi babka", "Zagatovkani ketingi tomonidan markaziy o’q bo’yicha mahkamlash va siqib turish vazifasini bajaradi"))
        list.add(Detal(R.drawable.ximoya10, "10. Ximoya oynasi", "Zagatovkaga ishlov berilyotgan paytda uchib chiquvchi yog’och payrahalardan saqlash vazifasini bajaradi"))
        list.add(Detal(R.drawable.lampochka11, "11. Yoritgich", "Zagatovkaga ishlov berishda ish o’rnini yoritish uchun xizmat qiladi"))
    }
}
