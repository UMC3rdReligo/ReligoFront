package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.UMCfront.religo.R


class CommunityChurchArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community_church_article, container, false)
    }

    companion object {
        fun newInstance(): CommunityChurchArticleFragment {
            return CommunityChurchArticleFragment()
        }
    }
}