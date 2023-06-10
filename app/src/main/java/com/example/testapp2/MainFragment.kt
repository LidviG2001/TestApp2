package com.example.testapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
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

    var arrow: ImageButton? = null
    var title_text: TextView? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrow = (requireActivity() as MainActivity).btn_arrow
        title_text = (requireActivity() as MainActivity).title_text?.apply {
            text = "Airplanes"
        }

        disableBackButton()

        initDataViewList()

        recyclerView = view.findViewById<RecyclerView>(R.id.idRVCourses)

        dataList = ArrayList()

        dataList = mainViewModel.getListEntities() as ArrayList<DataView>

        val layoutManager = GridLayoutManager(requireActivity(), 2)

        recyclerView.layoutManager = layoutManager

        recyclerAdapter = RecyclerAdapter(dataList, requireActivity(), object : ClickListener {
            override fun onClick(index: Int) {
                val bundle = Bundle().apply { putInt("Position", index) }
                findNavController(view).navigate(R.id.action_MainFragment_to_DetailsFragment, bundle)

                enableBackButton()
            }
        })

        recyclerView.adapter = recyclerAdapter

        recyclerAdapter.notifyDataSetChanged()

    }

    private fun disableBackButton(){
        arrow?.apply {
            visibility = View.INVISIBLE
            isClickable = false
        }
    }

    private fun enableBackButton(){
        arrow?.apply {
            visibility = View.VISIBLE
            isClickable = true
        }
    }

    private fun initDataViewList(){
        mainViewModel.deleteDAtaView()
        val initList = arrayListOf<DataView>(
            DataView(title = "Boeing", detail = "1970",
                imageId = R.mipmap.plane_photo_foreground,
                image2 = R.drawable.social_airplane_cockpit_buttons,
                mainTitle = "Boeing 747",
                firstDescription = "The Boeing 747 is a large, long-range wide-body airliner designed and manufactured by Boeing Commercial Airplanes in the United States between 1968 and 2023. After introducing the 707 in October 1958, Pan Am wanted a jet 2+1⁄2 times its size, to reduce its seat cost by 30%. In 1965, Joe Sutter left the 737 development program to design the 747, the first twin-aisle airliner. In April 1966, Pan Am ordered 25 Boeing 747-100 aircraft, and in late 1966, Pratt & Whitney agreed to develop the JT9D engine, a high-bypass turbofan. On September 30, 1968, the first 747 was rolled out of the custom-built Everett Plant, the world's largest building by volume. The first flight took place on February 9, 1969, and the 747 was certified in December of that year. It entered service with Pan Am on January 22, 1970. The 747 was the first airplane called a \"Jumbo Jet\" as the first wide-body airliner.",
                secondTitle = "Development",
                secondDescription = "In 1963, the United States Air Force started a series of study projects on a very large strategic transport aircraft. Although the C-141 Starlifter was being introduced, officials believed that a much larger and more capable aircraft was needed, especially to carry cargo that would not fit in any existing aircraft. These studies led to initial requirements for the CX-Heavy Logistics System (CX-HLS) in March 1964 for an aircraft with a load capacity of 180,000 pounds (81.6 t) and a speed of Mach 0.75 (430 kn; 800 km/h), and an unrefueled range of 5,000 nautical miles (9,300 km) with a payload of 115,000 pounds (52.2 t). The payload bay had to be 17 feet (5.18 m) wide by 13.5 feet (4.11 m) high and 100 feet (30 m) long with access through doors at the front and rear."
            ),
            DataView(title = "Antonov", detail = "1985",
                imageId = R.mipmap.plane_photo_foreground,
                image2 = R.drawable.social_airplane_cockpit_buttons,
                mainTitle = "An-225 Mriya",
                firstDescription = "The Antonov An-225 Mriya (Ukrainian: Антонов Ан-225 Мрія, lit. 'dream' or 'inspiration'; NATO reporting name: Cossack) was a strategic airlift cargo aircraft designed and produced by the Antonov Design Bureau in the Soviet Union.",
                secondTitle = "Development",
                secondDescription = "Work on what would become the Antonov An 225 would begin in 1984 with a request from the Soviet government for a large airlifter as a replacement for the Myasishchev VM-T.[2] The specifics of this request included the ability to carry a maximum payload of 231,838 kilograms (511,116 lb), both externally and internally, while operating from any runway of at least 3,500 metres (11,500 ft). As originally set out, the mission and objectives were broadly identical to that of the United States' Shuttle Carrier Aircraft, having been designed to airlift the Energia rocket's boosters and the Buran-class orbiters for the Soviet space program.[3][2] Furthermore, a relatively short timetable for the delivery of the completed aircraft meant that development would have to proceed at a rapid pace."
                ),
            DataView(title = "General Dynamics", detail = "1975",
                imageId = R.mipmap.plane_photo_foreground,
                image2 = R.drawable.social_airplane_cockpit_buttons,
                mainTitle = "F-16 Fighting Falcon",
                firstDescription =  "The General Dynamics F-16 Fighting Falcon is an American single-engine multirole fighter aircraft originally developed by General Dynamics for the United States Air Force (USAF). Designed as an air superiority day fighter, it evolved into a successful all-weather multirole aircraft. Over 4,600 aircraft have been built since production was approved in 1976.[4] Although no longer being purchased by the U.S. Air Force, improved versions are being built for export customers. In 1993, General Dynamics sold its aircraft manufacturing business to the Lockheed Corporation,[5] which in turn became part of Lockheed Martin after a 1995 merger with Martin Marietta.",
                secondTitle = "Development",
                secondDescription = "US Vietnam War experience showed the need for air superiority fighters and better air-to-air training for fighter pilots.[10] Based on his experience in the Korean War and as a fighter tactics instructor in the early 1960s, Colonel John Boyd with mathematician Thomas Christie developed the energy–maneuverability theory to model a fighter aircraft's performance in combat. Boyd's work called for a small, lightweight aircraft that could maneuver with the minimum possible energy loss and which also incorporated an increased thrust-to-weight ratio.[11][12] In the late 1960s, Boyd gathered a group of like-minded innovators who became known as the Fighter Mafia, and in 1969, they secured Department of Defense funding for General Dynamics and Northrop to study design concepts based on the theory."
                ),
            DataView(title = "Focke-Wulf", detail = "1939",
                imageId = R.mipmap.plane_photo_foreground,
                image2 = null,
                mainTitle = "Focke-Wulf Fw 190",
                firstDescription = "The Focke-Wulf Fw 190, nicknamed Würger[b] (\"Shrike\") is a German single-seat, single-engine fighter aircraft designed by Kurt Tank at Focke-Wulf in the late 1930s and widely used during World War II. Along with its well-known counterpart, the Messerschmitt Bf 109, the Fw 190 became the backbone of the Jagdwaffe (Fighter Force) of the Luftwaffe. The twin-row BMW 801 radial engine that powered most operational versions enabled the Fw 190 to lift larger loads than the Bf 109, allowing its use as a day fighter, fighter-bomber, ground-attack aircraft and to a lesser degree, night fighter.",
                secondTitle  = "Development",
                secondDescription = "Between 1934 and 1935 the German Ministry of Aviation (RLM) ran a contest to produce a modern fighter for the rearming Luftwaffe. Kurt Tank entered the parasol-winged Fw 159 into the contest, against the Arado Ar 80, Heinkel He 112 and Messerschmitt Bf 109. The Fw 159 was hopelessly outclassed and was soon eliminated from the competition along with the Ar 80. The He 112 and Bf 109 were generally similar in design but the 109's lightweight construction gave it a performance edge the 112 was never able to match. On March 12, 1936, the 109 was declared the winner"
                ))
        mainViewModel.setAllItems(initList)
    }
}