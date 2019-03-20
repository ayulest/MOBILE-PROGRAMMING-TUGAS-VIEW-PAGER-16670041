package com.ayulest.latihanmp2


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * A simple [Fragment] subclass.
 *
 */
class FourFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_four, container, false)
        val btnFollowMe: Button = view.findViewById(R.id.btnFollowMe)
        val ivPotoProfile: ImageView = view.findViewById(R.id.ivPotoProfile)
        activity?.let {
            Glide.with(it)
                .load(R.drawable.ayulest).override(512,512).into(ivPotoProfile)
        }
        btnFollowMe.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/ayle0699")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/ayle0699")
                    )
                )
            }

        }


        return view

    }


}
