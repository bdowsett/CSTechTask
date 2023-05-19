package com.example.cstechtask.view

import com.example.cstechtask.R
import com.example.cstechtask.model.CreditReportInfo
import com.example.cstechtask.viewmodel.DetailViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cstechtask.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private val detailViewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val data: CreditReportInfo? = arguments?.getParcelable("credit_Report_Info")
        if (data != null) {
            detailViewModel.setData(data)
        }
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState,
        )

        detailViewModel.detailData.observe(viewLifecycleOwner) {
            val shortTermDebt = it.currentShortTermDebt.toString()
            val longTermDebt = it.currentLongTermDebt.toString()

            binding.shortTermDebt.text = getString(R.string.your_short_term_debt_is, shortTermDebt)
            binding.longTermDebt.text = getString(R.string.your_long_term_debt_is, longTermDebt)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
