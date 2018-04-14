package com.lifeistech.android.dev_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    ArrayAdapter adapter;
    int Count = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                String item = (String) adapter.getItem(position);
                if (Count == position) {
                    adapter.remove(item);
                    adapter.insert(item, 0);

                } else {
                    adapter.insert(item, position + 2);
                    adapter.remove(item);

                    // adapter.remove(item);
                    // adapter.add(item);
                }
            }

        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
                String item = (String) adapter.getItem(position);

                Toast.makeText(getApplicationContext(), item + "を削除しました", Toast.LENGTH_SHORT).show();//thisむり
                adapter.remove(item);
                Count--;
                return false;
            }

        });

    }


    public void add(View v) {
        String text = editText.getText().toString();

            Toast.makeText(this, text + "を追加しました", Toast.LENGTH_SHORT).show();
            adapter.add(text);
            editText.setText(null);
            Count++;


    }
}
