package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu1.*
import kotlinx.android.synthetic.main.activity_menu2.*

class MenuActivity2 : AppCompatActivity() {

    private val search_address_btn: Button by lazy {
        findViewById(R.id.search_address_btn)
    }

    private val search_address_view: TextView by lazy {
        findViewById(R.id.search_address_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

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
                    search_address_view.text = addressData
                }
            }
        }
    }
}