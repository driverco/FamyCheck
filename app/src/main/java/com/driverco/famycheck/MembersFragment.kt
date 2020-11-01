package com.driverco.famycheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MembersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MembersFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val memberArray = arrayListOf<Member>()
    private lateinit var memberAdapt: MemberListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val viewInflated = inflater.inflate(R.layout.fragment_members, container, false)

        if (container != null) {
            memberAdapt = MemberListAdapter(container.context, R.layout.member_item, memberArray)
        }
        var membersList = viewInflated.findViewById<ListView>(R.id.membersList)
        membersList.adapter = memberAdapt
        memberAdapt.add(Member("Wilmer Rodriguez", "With symptoms", "31/10/2020"))
        memberAdapt.add(Member("Harold Rodriguez", "asymptomatic", "31/10/2020"))
        memberAdapt.add(Member("Tara Rodriguez", "Perfect Condition", "31/10/2020"))
        memberAdapt.add(Member("Max Rodriguez", "Prefect Condition", "31/10/2020"))
        memberAdapt.add(Member("Fiona Rodriguez", "UCI Clínica de Occidente", "29/10/2020"))
        return viewInflated
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MembersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MembersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}