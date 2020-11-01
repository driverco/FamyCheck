package com.driverco.famycheck.ui.famy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.driverco.famycheck.FamyCard
import com.driverco.famycheck.FamyCardAdapter
import com.driverco.famycheck.R
import kotlinx.android.synthetic.main.fragment_famy.*

class FamyFragment : Fragment() {

    private lateinit var famyViewModel: FamyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        famyViewModel =
            ViewModelProviders.of(this).get(FamyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_famy, container, false)
        famyViewModel.text.observe(viewLifecycleOwner, Observer {
            val famyCardArray = arrayListOf<FamyCard>()
            famyCardArray.add(FamyCard("famy1"))
            famyCardArray.add(FamyCard("famy2"))
            famyCardArray.add(FamyCard("famy3"))
            famyCardArray.add(FamyCard("famy4"))
            famyCardArray.add(FamyCard("famy5"))
            famyCardArray.add(FamyCard("famy6"))
            famyCardArray.add(FamyCard("famy7"))
            famyCardArray.add(FamyCard("famy8"))

            val famyCardAdapter = FamyCardAdapter(context,R.layout.famy_card,famyCardArray)
            famysGridView.adapter = famyCardAdapter
            famysGridView.setOnItemClickListener { parent, view, position: Int, id: Long  ->
                Navigation.findNavController(root).navigate(R.id.action_nav_famy_to_topicsFragment)
            }


        })
        return root
    }
}