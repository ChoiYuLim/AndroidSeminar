package com.example.seminar2_recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seminar2_recyclerview2.databinding.ItemSampleListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>(){
    val userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        val binding = ItemSampleListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    //클래스 안에 클래스가 있는 NestedClass 구조
    class FollowerViewHolder(private val binding: ItemSampleListBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun onBind(data : UserData){
                binding.tvName.text = data.name
                binding.tvIntroduce.text = data.introdution
            }
        }
}