package com.example.testapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp2.room.DataView
import com.example.testapp2.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModel()

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var dataList: ArrayList<DataView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataViewList()

        recyclerView = view.findViewById<RecyclerView>(R.id.idRVCourses)

        dataList = ArrayList()

        dataList = mainViewModel.getDataRoom() as ArrayList<DataView>

        val layoutManager = GridLayoutManager(requireActivity(), 2)

        recyclerView.layoutManager = layoutManager

        recyclerAdapter = RecyclerAdapter(dataList, requireActivity(), object : ClickListener {
            override fun onClick(index: Int) {
                val bundle = Bundle().apply { putInt("Position", index) }
                findNavController(view).navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)
            }
        })

        recyclerView.adapter = recyclerAdapter

/*        dataList.add(DataView("Boing", "1970" ,R.drawable.android))
        dataList.add(DataView("Boing","1970", R.drawable.f60fps))
        dataList.add(DataView("Boing","1970", R.drawable.javascript))*/



        recyclerAdapter.notifyDataSetChanged()

    }

    private fun initDataViewList(){
        val initList = arrayListOf<DataView>(DataView(title = "Boing", detail = "1970", imageId = R.drawable.android, fullDescription = "The Boeing 747 is a large, long-range wide-body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin-aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747-100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high-bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom-built Everett Plant, the world's largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. It entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide-body airliner."),
            DataView(title = "Boing", detail = "1970", imageId = R.drawable.android, fullDescription = "The Boeing 747 is a large, long-range wide-body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin-aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747-100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high-bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom-built Everett Plant, the world's largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. It entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide-body airliner."),
            DataView(title = "Boing", detail = "1970", imageId = R.drawable.android, fullDescription = "The Boeing 747 is a large, long-range wide-body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin-aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747-100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high-bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom-built Everett Plant, the world's largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. It entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide-body airliner."),
            DataView(title = "Boing", detail = "1970", imageId = R.drawable.android, fullDescription = "The Boeing 747 is a large, long-range wide-body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin-aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747-100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high-bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom-built Everett Plant, the world's largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. It entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide-body airliner."))
        mainViewModel.setAllItems(initList)
    }
}