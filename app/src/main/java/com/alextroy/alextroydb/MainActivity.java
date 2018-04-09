package com.alextroy.alextroydb;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alextroy.alextroydb.model.local.Node;
import com.alextroy.alextroydb.model.local.NodeContract;
import com.alextroy.alextroydb.model.local.NodeDbHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NodeRecyclerAdapter adapter;
    private List<Node> nodes;
    private FloatingActionButton fab;
    private NodeDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NodeRecyclerAdapter(this, nodes);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        dbHelper = new NodeDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                NodeContract.NodeEntry._ID,
                NodeContract.NodeEntry.COLUMN_NODE_VALUE};

//        Cursor cursor = db.query(
//                NodeContract.NodeEntry.TABLE_NAME,
//                projection,
//                null,
//                null,
//                null,
//                null,
//                null);
//
//        TextView displayView = (TextView) findViewById(R.id.value);
//
//        try {
//            displayView.setText("The nodes table contains " + cursor.getCount() + " nodes.\n\n");
//            displayView.append(
//                    NodeContract.NodeEntry._ID + " - " +
//                            NodeContract.NodeEntry.COLUMN_NODE_VALUE + "\n");
//
//            int idColumnIndex = cursor.getColumnIndex(NodeContract.NodeEntry._ID);
//            int nameColumnIndex = cursor.getColumnIndex(NodeContract.NodeEntry.COLUMN_NODE_VALUE);
//
//            while (cursor.moveToNext()) {
//                int currentID = cursor.getInt(idColumnIndex);
//                String currentName = cursor.getString(nameColumnIndex);
//
//                displayView.append("\n" + currentID + " - " +
//                        currentName);
//            }
//
//        } finally {
//            cursor.close();
//        }
    }
}
