package com.driverco.famycheck


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MemberListAdapter(context: Context, private val layout: Int, private val data: ArrayList<Member>) :
    ArrayAdapter<Member>(context, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val member = data[position]
        val view : View
        view = if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val inflatedView = inflater.inflate(layout, parent, false)
            inflatedView
        }else{
            convertView
        }

        val MemberText = view.findViewById<TextView>(R.id.textViewMember)
        val StatusText = view.findViewById<TextView>(R.id.textViewStatus)
        val DateText = view.findViewById<TextView>(R.id.textViewDate)
        MemberText.text = member.member
        StatusText.text = member.status
        DateText.text = member.date
        return view
    }

}

