package it.sileo.associazionelucana.list

import android.view.ViewGroup
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.BaseAdapter
import android.widget.TextView
import it.sileo.associazionelucana.fragment.StoryFragment
import it.sileo.associazionelucana.activity.ALSTEGActivity
import it.sileo.associazionelucana.fragment.ListImageFragment
import it.sileo.associazionelucana.R

class AppAdapter(private val context: FragmentActivity, private val contentList: ArrayList<String>, val content: String?)
    : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.fragment_item, null)
        val textView = rowView.findViewById<TextView>(R.id.content)
       // imageView.setImageResource(contentList[p0])
        textView.text = contentList[p0]
        rowView.setOnClickListener{
            if(content == ALSTEGActivity.STORY) {
                var fragmentTransaction = context.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_layout, StoryFragment.newInstance(contentList[p0], ""))
                        .addToBackStack(null)
                        .commit()
            }else if(content == ALSTEGActivity.IMAGE){
                var fragmentTransaction = context.supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_layout, ListImageFragment.newInstance(contentList[p0], ""))
                        .addToBackStack(null)
                        .commit()
            }
        }
        return rowView
    }

    override fun getItem(p0: Int): Any {
        return contentList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return contentList.size
    }
}