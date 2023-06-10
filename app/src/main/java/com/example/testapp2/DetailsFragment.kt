package com.example.testapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.testapp2.room.DataView
import com.example.testapp2.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {

    private val detailsViewModel: DetailsViewModel by viewModel()

    lateinit var dataList: ArrayList<DataView>

    var title_text: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataList = ArrayList()

        dataList = detailsViewModel.getDataRoom() as ArrayList<DataView>

        val mainTitle: TextView = view.findViewById(R.id.main_title)
        val firstDescription: TextView = view.findViewById(R.id.first_description)
        val secondTitle: TextView = view.findViewById(R.id.second_title)
        val secondDescription: TextView = view.findViewById(R.id.second_description)

        val image: ImageView = view.findViewById(R.id.image_detail)

        val position: Int = arguments?.get("Position") as Int

        title_text = (requireActivity() as MainActivity).title_text?.apply {
            text = dataList[position].mainTitle
        }

        val item = dataList[position]

        mainTitle.text = item.mainTitle
        firstDescription.text = item.firstDescription
        secondTitle.text = item.secondTitle
        secondDescription.text = item.secondDescription

        item.image2?.let{
            image.setImageResource(item.image2)
        }

    }
}