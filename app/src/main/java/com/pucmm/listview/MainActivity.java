package com.pucmm.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter mAdapter;
    private String[] cars = { "Subaru", "Tesla", "Toyota" };
    public static final String EXTRA = "CAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.userlist);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cars);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = mListView.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra(EXTRA, o.toString());
                startActivity(intent);
            }
        });
    }
}