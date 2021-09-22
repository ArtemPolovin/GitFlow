package com.example.gitflow.ui.viepager_container

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.domain.models.WelcomeScreenModel
import com.example.gitflow.R
import com.example.gitflow.utils.LAST_PAGE
import com.example.gitflow.utils.ZoomOutPageTransformer
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_view_pager_container.*

class ViewPagerContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val pagesList = listOf(
            WelcomeScreenModel(
                R.drawable.image_screen_one,
                getString(R.string.welcome_screen_one_text_title),
                getString(R.string.welcome_screen_one_subtext)
            ),
            WelcomeScreenModel(
                R.drawable.image_screen_two,
                getString(R.string.welcome_screen_two_text_title),
                getString(R.string.welcome_screen_two_text_subtitle)
            ),
            WelcomeScreenModel(
                R.drawable.image_screen_three,
                getString(R.string.welcome_screen_three_text_title),
                getString(R.string.welcome_screen_three_text_subtitle)
            )

        )

        val mAdapter = ViewPagerAdapter(pagesList)
        viewPager.adapter = mAdapter

        viewPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(tablayout, viewPager) { tab, position ->}.attach()

        btn_continue.setOnClickListener {
            if ( viewPager.currentItem == LAST_PAGE) {

            }else viewPager.setCurrentItem( viewPager.currentItem + 1, true)
        }
    }
}