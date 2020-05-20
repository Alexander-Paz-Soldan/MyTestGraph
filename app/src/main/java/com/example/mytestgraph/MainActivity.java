package com.example.mytestgraph;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.delete_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(MainActivity.this,
                       "You pressed delete",
                       Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab2 = findViewById(R.id.edit_button);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open Fragment for edit
                Toast.makeText(MainActivity.this,
                        "You pressed edit",
                        Toast.LENGTH_SHORT).show();
                // start create Node
                Intent intent = new Intent(view.getContext(), MakeNode.class);
                startActivity(intent);

            }
        });

        //MindMappingView mindMappingView = new MindMappingView(this); // init mindmap
        createMindMap();

    }

    private void userCreateMindMap(String title, String name){

        MindMappingView mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);
        Item root = new Item(MainActivity.this, "Root", "This is an root item", true);
        Item item = new Item(MainActivity.this, title, name, true);
        mindMappingView.addItem(item, root,100,10,ItemLocation.TOP,true,null);

    }

    private void createMindMap(){
        // Create the MindMap object
        MindMappingView mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);

        Item item = new Item(MainActivity.this, "Root", "This is a root item", true);
        mindMappingView.addCentralItem(item, false); //I didn't want to make the root drag able

        Item child = new Item(MainActivity.this, "Verbaasd", "Surprised", true);
        mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null);

        Item child2 = new Item(MainActivity.this, "Goed", "Good", true);
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
