package com.abit8.lesson21_s6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.abit8.lesson21_s6.MainActivity.Companion.MAIN_TO_SECOND_GOAT
import com.abit8.lesson21_s6.adapter.SecondGoatAdapter
import com.abit8.lesson21_s6.adapter.model.GoatModel
import com.abit8.lesson21_s6.databinding.ActivitySecondBinding
 
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var adapter: SecondGoatAdapter
    private val goatList2 = arrayListOf<GoatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedGoats =
            intent.getSerializableExtra(MAIN_TO_SECOND_GOAT) as ArrayList<GoatModel>?
        if (selectedGoats != null) {
            goatList2.addAll(selectedGoats)
            adapter = SecondGoatAdapter(goatList2)
            binding.apply {
                recycler.layoutManager = GridLayoutManager(this@SecondActivity, 3)
                recycler.adapter = adapter
            }
        }
    }
}