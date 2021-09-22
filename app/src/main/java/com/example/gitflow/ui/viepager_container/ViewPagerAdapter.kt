package com.example.gitflow.ui.viepager_container

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.WelcomeScreenModel
import com.example.gitflow.R
import kotlinx.android.synthetic.main.cell_view_pager.view.*

class ViewPagerAdapter(private val pagesList: List<WelcomeScreenModel> ): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val welcomeScreenModel = pagesList[position]

        holder.itemView.apply {
            image_welcome_screen.setImageResource(welcomeScreenModel.image)
            text_title.text = welcomeScreenModel.title
            text_subtext.text = welcomeScreenModel.subText
        }
    }

    override fun getItemCount(): Int {
        return pagesList.size
    }

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}