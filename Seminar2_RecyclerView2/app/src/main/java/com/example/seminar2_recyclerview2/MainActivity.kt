package com.example.seminar2_recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seminar2_recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var followerAdapter: FollowerAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initAdapter()

        setContentView(binding.root)
    }

    private fun initAdapter(){
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData("최유림", "안드로이드"),
                UserData("박정훈","안드로이드"),
                UserData("이준호","IOS"),
                UserData("김인우","기획"),
                UserData("박민우", "안드로이드"),
                UserData("김우영","서버")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }
}