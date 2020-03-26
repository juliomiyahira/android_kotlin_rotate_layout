package com.example.kotlinorientacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var names : ArrayList<String> = arrayListOf<String>();

    var adapter: ArrayAdapter<String>? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState!= null) {
            this.names = savedInstanceState.getStringArrayList("names_list") as ArrayList<String>;
        }
        
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, this.names);
        lstNames.adapter = adapter;
    }

    fun btnAddCLick(view: View) {
        names.add(edtName.text.toString());
        edtName.text.clear();
        adapter?.notifyDataSetChanged();
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("names_list", this.names);
    }
}
