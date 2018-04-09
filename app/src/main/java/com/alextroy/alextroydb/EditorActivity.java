package com.alextroy.alextroydb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.alextroy.alextroydb.model.local.NodeContract;
import com.alextroy.alextroydb.model.local.NodeDbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        valueEditText = (EditText) findViewById(R.id.edit_node_value);
    }

    private void insertPet() {
        String nameStr = valueEditText.getText().toString().trim();

        NodeDbHelper dbHelper = new NodeDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NodeContract.NodeEntry.COLUMN_NODE_VALUE, nameStr);

        long newRowId = db.insert(NodeContract.NodeEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this, "Error saving node", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Node saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertPet();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
