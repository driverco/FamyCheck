package com.driverco.famycheck

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.driverco.famycheck.ui.TopicViewModel
import kotlinx.android.synthetic.main.fragment_topics.*
import androidx.lifecycle.Observer
import androidx.navigation.Navigation


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TopicsFragment : Fragment() {
    private lateinit var topicViewModel: TopicViewModel

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        topicViewModel =
            ViewModelProviders.of(this).get(TopicViewModel::class.java)
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_topics, container, false)

        topicViewModel.text.observe(viewLifecycleOwner, Observer {
            viewMembersButton.setOnClickListener{ view ->
                viewMembers(root)
            }

            val topicCardArray = arrayListOf<TopicCard>()
            topicCardArray.add(TopicCard("topic1"))
            topicCardArray.add(TopicCard("topic2"))
            topicCardArray.add(TopicCard("topic3"))
            topicCardArray.add(TopicCard("topic3"))
            topicCardArray.add(TopicCard("topic3"))
            topicCardArray.add(TopicCard("topic3"))
            topicCardArray.add(TopicCard("topic3"))
            val topicCardAdapter = TopicCardAdapter(context, R.layout.topic_card, topicCardArray)
            Log.v("ADAPTERTOPICS", "adapter previous")
            topicsGridView.adapter = topicCardAdapter
        })
        return root
    }
    fun viewMembers(root: View){
        //Toast.makeText(getActivity(), "viewMembers", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(root).navigate(R.id.action_topicsFragment_to_membersFragment)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TopicsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TopicsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}