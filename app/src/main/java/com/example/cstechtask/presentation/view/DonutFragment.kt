package com.example.cstechtask.presentation.view

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.cstechtask.R
import com.example.cstechtask.databinding.FragmentDonutBinding
import com.example.cstechtask.presentation.viewmodel.DonutViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DonutFragment : Fragment() {
    lateinit var bundle: Bundle

    private val donutViewModel: DonutViewModel by viewModels()

    private var _binding: FragmentDonutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDonutBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        donutViewModel.donutData.observe(viewLifecycleOwner) {
            val score = it.creditReportInfo.score
            binding.score.text = score.toString()
            animateDonut(binding.progress, score.toInt())

            bundle = Bundle().apply {
                putParcelable(CREDIT_REPORT_INFO, it.creditReportInfo)
            }
        }

        donutViewModel.getDonutDetails()

        binding.donut.setOnClickListener {
                view ->
            view.findNavController().navigate(R.id.navigate_to_details, bundle)
        }
    }

    fun animateDonut(view: View, value: Int) {
        ObjectAnimator.ofInt(view, "progress", value)
            .setDuration(1000)
            .start()
    }

    companion object {
        private const val CREDIT_REPORT_INFO = "credit_Report_Info"
    }
}
