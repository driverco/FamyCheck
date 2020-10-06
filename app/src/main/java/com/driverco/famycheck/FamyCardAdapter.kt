package com.driverco.famycheck

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class FamyCardAdapter(context: Context?, private val layout: Int, private val cards: ArrayList<FamyCard>) :
    ArrayAdapter<FamyCard>(context!!, layout, cards) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val famyCard = cards[position]
        val view : View
        view = if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val inflatedView = inflater.inflate(layout, parent, false)
            inflatedView
        }else{
            convertView
        }

        val famyTittleTextView = view.findViewById<TextView>(R.id.topicTittleTextView)
        famyTittleTextView.text = famyCard.name
        return view
    }

}

