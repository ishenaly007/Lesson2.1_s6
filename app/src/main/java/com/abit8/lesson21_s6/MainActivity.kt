package com.abit8.lesson21_s6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.abit8.lesson21_s6.adapter.GoatAdapter
import com.abit8.lesson21_s6.adapter.model.GoatModel
import com.abit8.lesson21_s6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: GoatAdapter
    private var goatList = arrayListOf<GoatModel>()
    private val selectedGoats = mutableListOf<GoatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGoat()
        adapter = GoatAdapter(goatList, this::addImage, this::removeImage)
        binding.apply {
            recycler.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recycler.adapter = adapter
        }

        binding.btnAddGoats.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(MAIN_TO_SECOND_GOAT, ArrayList(selectedGoats))
            startActivity(intent)

            selectedGoats.clear()
        }
    }

    private fun initGoat() {
        goatList.add(GoatModel("https://m.media-amazon.com/images/M/MV5BYmRjYmUzNzgtNjdhMi00NmNiLWE2ZTMtNzYyOWEyODdlZjgwXkEyXkFqcGdeQXVyMTkzODQwNzI@._V1_.jpg"))
        goatList.add(GoatModel("https://i2-prod.dailystar.co.uk/incoming/article29433537.ece/ALTERNATES/s1200c/3_PROD-JS293280991.jpg"))
        goatList.add(GoatModel("https://w0.peakpx.com/wallpaper/119/390/HD-wallpaper-goat-cristiano-ronaldo-2021.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://upload.wikimedia.org/wikipedia/commons/f/ff/Domestic_goat_kid_in_capeweed.jpg"))
        goatList.add(GoatModel("https://upload.wikimedia.org/wikipedia/commons/f/ff/Domestic_goat_kid_in_capeweed.jpg"))
        goatList.add(GoatModel("https://www.plenglish.com/wp-content/uploads/2022/07/Etiopia-Walia.jpg"))
        goatList.add(GoatModel("https://eu-images.contentstack.com/v3/assets/blta90d05ad41a54a71/bltf0ebe4491611fd1f/639cc1ef0ead454b3679482d/2M17EDB.jpg"))
        goatList.add(GoatModel("https://www.thehappychickencoop.com/wp-content/uploads/2023/01/10-Giant-Goat-Breeds-You-Should-Get.jpg"))
        goatList.add(GoatModel("https://upload.wikimedia.org/wikipedia/commons/f/ff/Domestic_goat_kid_in_capeweed.jpg"))
        goatList.add(GoatModel("https://upload.wikimedia.org/wikipedia/commons/f/ff/Domestic_goat_kid_in_capeweed.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://i.pinimg.com/originals/ea/98/77/ea9877dc57f5825037e97b1bdfe69ed4.jpg"))
        goatList.add(GoatModel("https://upload.wikimedia.org/wikipedia/commons/f/ff/Domestic_goat_kid_in_capeweed.jpg"))
    }

    fun addImage(goatModel: GoatModel) {
        selectedGoats.add(goatModel)
    }

    fun removeImage(goatModel: GoatModel) {
        selectedGoats.remove(goatModel)
    }

    companion object {
        const val MAIN_TO_SECOND_GOAT = "data"
    }
}