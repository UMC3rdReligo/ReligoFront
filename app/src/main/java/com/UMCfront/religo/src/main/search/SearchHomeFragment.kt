package com.UMCfront.religo.src.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity

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
        val btnHashtag = view.findViewById<Button>(R.id.btn_hashtag)



        val bundle = Bundle()
        bundle.putString("key", edtInput.text.toString())

        val passBundleSearchFragment = SearchFragment()






        //키보드 완료 눌렀을때 숨겨진 버튼을 통해 이동

        edtInput!!.setOnEditorActionListener(getEditorActionListener(btnDone)) // 키보드에서 done(완료) 클릭 시 , 원하는 뷰 클릭되게 하기
        btnDone.setOnClickListener {
            passBundleSearchFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFrameLayout, SearchFragment())
                .commit()

        }

        btnHashtag.setOnClickListener{
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


