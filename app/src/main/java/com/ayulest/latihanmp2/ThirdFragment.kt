package com.ayulest.latihanmp2


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayulest.latihanmp2.adapter.UpcomingAdapter
import com.ayulest.latihanmp2.model.ResultsItem
import com.ayulest.latihanmp2.rest.ApiClient
import com.ayulest.latihanmp2.rest.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * A simple [Fragment] subclass.
 *
 */

@Suppress("UNCHECKED_CAST")
class ThirdFragment : Fragment() {

    private var items: ArrayList<ResultsItem> = arrayListOf()
    private lateinit var upcomingAdapter: UpcomingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_third, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_list_post)

        val service: ApiService = ApiClient.client()
        service.getALLPostPlaying().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                items.clear()
                items = it.results as ArrayList<ResultsItem>
                recyclerView.layoutManager= LinearLayoutManager(activity)
                upcomingAdapter = UpcomingAdapter(items, activity)
                recyclerView.adapter = upcomingAdapter
                upcomingAdapter.notifyDataSetChanged()

//                items = it.
//                mAdapter = UpcomingAdapter(context, items)
//                recyclerView.adapter= UpcomingAdapter(it, activity)
            }

        return view
    }


}
