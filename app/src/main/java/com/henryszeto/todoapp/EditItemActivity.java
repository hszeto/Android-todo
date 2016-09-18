package com.henryszeto.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    EditText editItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String todoItem = getIntent().getStringExtra("todoItem");

        editItem = (EditText) findViewById(R.id.editItem);
        editItem.setText(todoItem);   // Display item to view
        editItem.setSelection(editItem.getText().length()); //put cursor at the back
    }

    public void onEditItem(View view) {
        int pos = getIntent().getIntExtra("position", 0); // read position from intent

        Intent data = new Intent();
        data.putExtra("editedItem", editItem.getText().toString()); // put new item in intent
        data.putExtra("position", pos );  // put item array position to intent
        data.putExtra("code", 200);
        setResult(RESULT_OK, data);
        finish();
    }
}
