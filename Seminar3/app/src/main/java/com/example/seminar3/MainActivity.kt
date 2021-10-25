package com.example.seminar3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.seminar3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sampleViewPagerAdapter: SampleViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initAdapter()

        initBottomNavigation()

        setContentView(binding.root)
    }

    private fun initAdapter(){
        val fragmentList = listOf(EmptyFragment1(), EmptyFragment2(), EmptyFragment3())

        sampleViewPagerAdapter = SampleViewPagerAdapter(this) //ViewPagerAdapter 초기화
        sampleViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpSample.adapter = sampleViewPagerAdapter //ViewPager2와 Adapter 연동
    }

    private fun initBottomNavigation(){
        binding.vpSample.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvSample.menu.getItem(position).isChecked=true
            }
        })

        binding.bnvSample.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_android -> {
                    binding.vpSample.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_email -> {
                    binding.vpSample.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vpSample.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
            }

            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }
}