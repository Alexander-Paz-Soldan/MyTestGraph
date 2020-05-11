package com.example.mytestgraph;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import me.jagar.mindmappingandroidlibrary.Views.Connection;
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage;
import me.jagar.mindmappingandroidlibrary.Views.Item;
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation;
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        createMindMap();

    }

    private void createMindMap(){
        // Create the MindMap object
        MindMappingView mindMappingView = new MindMappingView(this);
        Item item = new Item(this, "Root", "This is an root item", true);
        mindMappingView.addCentralItem(item, false);
        Item child = new Item(MainActivity.this, "Child", "This is a child", true);
        mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null);

        Item child2 = new Item(MainActivity.this, "Child", "This is another child", true);
        Connection connection = new Connection(item, child);
        ConnectionTextMessage connectionTextMessage = new ConnectionTextMessage(MainActivity.this);
        connectionTextMessage.setText("message");
        mindMappingView.addItem(child2, item, 150, 10, ItemLocation.BOTTOM, true,connectionTextMessage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
