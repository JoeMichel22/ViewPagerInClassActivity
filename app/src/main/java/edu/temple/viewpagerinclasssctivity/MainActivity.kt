package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    //ctrl+B opens the functionality definition of functions and componenets in andriod studio
    //supportFragmentManager.findFragmentByTag("f" + position of fragment) needed for assignment 8

    private var numberOfPages= 0
    private val btnAdd: Button by lazy{
        findViewById(R.id.btnAdd)
    }
    private val pager: ViewPager2 by lazy {
        findViewById(R.id.pageViewer)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            numberOfPages ++
            //pager.adapter?.notifyDataSetChanged() //used to let adapter know that data has been changed outside of it
            pager.adapter?.notifyItemInserted(numberOfPages - 1)

            pager.currentItem= numberOfPages-1
        }

        pager.adapter= object: FragmentStateAdapter(this){
            override fun getItemCount()= numberOfPages

            override fun createFragment(position: Int)= TextFragment.newInstance((position + 1).toString())
        }

    }
}