package com.UMCfront.religo.src.main.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentSearchHomeBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.CommunityAllFragment
import com.UMCfront.religo.src.main.community.CommunityFragment
import com.UMCfront.religo.src.main.home.HomeFragment

class SearchHomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtSearch = view.findViewById<EditText>(R.id.edt_search)
        val edtInput = view.findViewById<EditText>(R.id.edt_search)
        val btnDone = view.findViewById<Button>(R.id.btn_intent)


        
        //키보드 완료 눌렀을때 숨겨진 버튼을 통해 인텐트



        edtInput!!.setOnEditorActionListener(getEditorActionListener(btnDone)) // 키보드에서 done(완료) 클릭 시 , 원하는 뷰 클릭되게 하기
        btnDone.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(SearchFragment.newInstance())
        }
    }


    companion object {
        // fragment 인스턴스 사용하기 위해 companion object 사용
        fun newInstance(): SearchHomeFragment {
            return SearchHomeFragment()
        }
    }

    fun getEditorActionListener(view: View): TextView.OnEditorActionListener { // 키보드에서 done(완료) 클릭 시 , 원하는 뷰 클릭되게 하는 메소드
        return TextView.OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                view.callOnClick()
            }
            false
        }
    }
}

//버튼 인텐트를 통해 edittext내용도 getstring을 통해 넘겨주고 그 결과를 rv에 표시해야댐


