package com.driverco.famycheck

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TopicCardAdapter(context: Context?, private val layout: Int, private val cards: ArrayList<TopicCard>) :
   ArrayAdapter<TopicCard>(
       context!!,
       layout,
       cards
   ) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.v("ADAPTERTOPICS","adapter executed")
        val topicCard = cards[position]
        val view : View
        view = if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val inflatedView = inflater.inflate(layout, parent, false)
            inflatedView
        }else{
            convertView
        }
        Log.v("ADAPTERTOPICS","adapter executed")
        val topicTittleTextView = view.findViewById<TextView>(R.id.topicTittleTextView)
        topicTittleTextView.text = topicCard.name
        return view
    }

}

