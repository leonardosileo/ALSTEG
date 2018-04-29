package it.sileo.associazionelucana.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import it.sileo.associazionelucana.R
import it.sileo.associazionelucana.activity.ALSTEGActivity
import it.sileo.associazionelucana.list.AppAdapter
import it.sileo.associazionelucana.utils.OnFragmentInteractionListener
import java.time.LocalDateTime
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ItemFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var listView : ListView
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_item_list, container, false)
        listView = view.findViewById<ListView>(R.id.list)
        textView = view.findViewById<TextView>(R.id.title_list)
        var startYear: Int = 1998
        if(param1 == ALSTEGActivity.STORY) {
            textView.text = getString(R.string.select_year)
        }else if(param1 == ALSTEGActivity.IMAGE){
            textView.text = getString(R.string.select_year_image)
            startYear = 1999
        }

        val list = ArrayList<String>()

        var cal = Calendar.getInstance()
        var finalYear: Int = cal.get(Calendar.YEAR)


        for (i in startYear..finalYear)
        list.add(i.toString())


        var adapterlist = AppAdapter(activity!!,list,param1)
        listView.adapter = adapterlist


        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ItemFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
