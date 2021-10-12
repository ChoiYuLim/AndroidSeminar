package com.example.seminar2_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.seminar2_recyclerview.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {
    private var _binding: FragmentSampleBinding? = null
    //private val binding get() = _binding!!
    private val binding get() = _binding ?: error("Binding 이 초기화 되지 않았습니다.") //에러 메시지를 보다 명시적으로 표현!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSampleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}