package com.ayulest.latihanmp2


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ayulest.latihanmp2.adapter.PostItemAdapter
import com.ayulest.latihanmp2.rest.ApiClient
import com.ayulest.latihanmp2.rest.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)

        val recyclerView: RecyclerView= view.findViewById(R.id.rv_list_post)
        recyclerView.layoutManager= LinearLayoutManager(activity)
        val service: ApiService = ApiClient.client()
        service.getALLPost().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                recyclerView.adapter= PostItemAdapter(it, activity)
            }


        return view
    }


}
