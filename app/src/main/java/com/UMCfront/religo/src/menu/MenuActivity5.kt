package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import kotlinx.android.synthetic.main.activity_menu5.*


class MenuActivity5 : AppCompatActivity() {
    var count = 0 // 태크 선택 수 (5개 이하로 선택하도록 하기 위해 선언)
    val hashTag = "hashTag"

    // 서버에 보낼 hashTage값을 넣을 문자열 배열 선언
    // ★ mutableSetOf사용 ==> 중복 불가, setOf와 다르게 수정(추가 및 삭제) 가능
    val hashTagArray = mutableSetOf<String>()
    // val preference by lazy {getSharedPreferences("MenuActivity5", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu5)

        applicationContext.getSharedPreferences("MenuActivity5", MODE_PRIVATE)

        // 버튼 클릭시 해당 값을 hashTag에 추가 (선택 해제하면 다시 삭제)
        menu5_btn1.setOnClickListener{
            if (menu5_btn1.isChecked == true) {
                hashTagArray.add("#가까운")
                count++;
            }
            else{
                hashTagArray.remove("#가까운")
                count--;
            }
        }
        menu5_btn2.setOnClickListener{
            if (menu5_btn2.isChecked == true) {
                hashTagArray.add("#활기찬")
                count++;
            }
            else{
                hashTagArray.remove("#활기찬")
                count--;
            }
        }
        menu5_btn3.setOnClickListener{
            if (menu5_btn3.isChecked == true) {
                hashTagArray.add("#시간이 다양한")
                count++;
            }
            else{
                hashTagArray.remove("#시간이 다양한")
                count--;
            }
        }
        menu5_btn4.setOnClickListener{
            if (menu5_btn4.isChecked == true) {
                hashTagArray.add("#따뜻한")
                count++;
            }
            else{
                hashTagArray.remove("#따뜻한")
                count--;
            }
        }
        menu5_btn5.setOnClickListener{
            if (menu5_btn5.isChecked == true) {
                hashTagArray.add("#모임이 많은")
                count++;
            }
            else{
                hashTagArray.remove("#모임이 많은")
                count--;
            }
        }
        menu5_btn6.setOnClickListener{
            if (menu5_btn6.isChecked == true) {
                hashTagArray.add("#편안한")
                count++;
            }
            else{
                hashTagArray.remove("#편안한")
                count--;
            }
        }
        menu5_btn7.setOnClickListener{
            if (menu5_btn7.isChecked == true) {
                hashTagArray.add("#다양한")
                count++;
            }
            else{
                hashTagArray.remove("#다양한")
                count--;
            }
        }
        menu5_btn8.setOnClickListener{
            if (menu5_btn8.isChecked == true) {
                hashTagArray.add("#저녁예배")
                count++;
            }
            else{
                hashTagArray.remove("#저녁예배")
                count--;
            }
        }
        menu5_btn9.setOnClickListener{
            if (menu5_btn9.isChecked == true) {
                hashTagArray.add("#행사")
                count++;
            }
            else{
                hashTagArray.remove("#행사")
                count--;
            }
        }
        menu5_btn10.setOnClickListener{
            if (menu5_btn10.isChecked == true) {
                hashTagArray.add("#유아부 청소년부")
                count++;
            }
            else{
                hashTagArray.remove("#유아부 청소년부")
                count--;
            }
        }
        menu5_btn11.setOnClickListener{
            if (menu5_btn11.isChecked == true) {
                hashTagArray.add("#다채로운")
                count++;
            }
            else{
                hashTagArray.remove("#다채로운")
                count--;
            }
        }
        menu5_btn12.setOnClickListener{
            if (menu5_btn12.isChecked == true) {
                hashTagArray.add("#개인공간")
                count++;
            }
            else{
                hashTagArray.remove("#개인공간")
                count--;
            }
        }
        menu5_btn13.setOnClickListener{
            if (menu5_btn13.isChecked == true) {
                hashTagArray.add("#궁금함")
                count++;
            }
            else{
                hashTagArray.remove("#궁금함")
                count--;
            }
        }
        menu5_btn14.setOnClickListener{
            if (menu5_btn14.isChecked == true) {
                hashTagArray.add("#축제")
                count++;
            }
            else{
                hashTagArray.remove("#축제")
                count--;
            }
        }
        menu5_btn15.setOnClickListener{
            if (menu5_btn15.isChecked == true) {
                hashTagArray.add("#새벽기도")
                count++;
            }
            else{
                hashTagArray.remove("#새벽기도")
                count--;
            }
        }
        menu5_btn16.setOnClickListener{
            if (menu5_btn16.isChecked == true) {
                hashTagArray.add("#여유로운")
                count++;
            }
            else{
                hashTagArray.remove("#여유로운")
                count--;
            }
        }
        menu5_btn17.setOnClickListener{
            if (menu5_btn17.isChecked == true) {
                hashTagArray.add("#교회 수련회")
                count++;
            }
            else{
                hashTagArray.remove("#교회 수련회")
                count--;
            }
        }
        menu5_btn18.setOnClickListener{
            if (menu5_btn18.isChecked == true) {
                hashTagArray.add("#열정적")
                count++;
            }
            else{
                hashTagArray.remove("#열정적")
                count--;
            }
        }


        // 다음으로 버튼 -> 클릭시 hashTag 배열 shared preference로 저장
        menu5_next_btn.setOnClickListener {
            // 5개 초과 선택시 Toast로 사용자에게 메시지 알리기
            if (count > 5) {
                Toast.makeText(this@MenuActivity5, "최대 5개만 선택해주세요", Toast.LENGTH_LONG).show()
            } else { // 5개 이하로 선택해야 다음 페이지로 넘어갈 수 있게 설정
                SPEditor.putString(hashTag, hashTagArray.toString()).apply()
                val intent = Intent(this, MenuActivity6::class.java)
                startActivity(intent)
            }
        }

        // 이전으로 버튼 -> 클릭시 저장되어 있던 shared preference값 삭제
        menu5_back_btn.setOnClickListener {
            val editor : SharedPreferences.Editor = SPEditor // 데이터 기록을 위한 editor
            editor.remove(hashTag)
            editor.commit()

            val intent = Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }
    }
}