package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import kotlinx.android.synthetic.main.activity_menu2.*

class MenuActivity2 : AppCompatActivity() {
    val address = "address"
    // 주소 검색
    private val search_address_btn: Button by lazy {
        findViewById(R.id.search_address_btn)
    }
    private val search_address_view: TextView by lazy {
        findViewById(R.id.search_address_view)
    }

    // shared preference
    // val preference by lazy {getSharedPreferences("MenuActivity2", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        applicationContext.getSharedPreferences("MenuActivity2", MODE_PRIVATE)

        // [다음으로] 버튼
        menu2_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }

        // [이전으로] 버튼
        menu2_back_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity1::class.java)
            startActivity(intent)
        }

        // 버튼을 누르면 AddressActivity를 띄워주는 부분
        search_address_btn.setOnClickListener {
            Intent(this, AddressForKotlin2::class.java).apply {
                startActivityForResult(this, AddressForKotlin2.ADDRESS_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            AddressForKotlin2.ADDRESS_REQUEST_CODE -> {
                if (resultCode == RESULT_OK) {
                    // 주소를 가져와서 보여주는 부분
                    val addressData = data?.extras?.getString("address")
                    // search_address_view.text = addressData

                    // 해당 주소를 shared preferences 저장
                    // preference.edit().putString(address, addressData).apply()
                    ApplicationClass.SPEditor.putString(address, addressData).apply()
                    // shared preferences 저장한 주소 값 search_address_view로 띄우기
                    // search_address_view.setText(preference.getString(address,""))
                    search_address_view.setText(addressData)
                }
            }
        }
    }
}