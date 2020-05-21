package com.example.mytestgraph;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import me.jagar.mindmappingandroidlibrary.Views.Connection;
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage;
import me.jagar.mindmappingandroidlibrary.Views.Item;
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation;
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;


public class EditWordMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word_map);
    }

    private void userCreateMindMap(String title, String name){

        MindMappingView mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);
        Item root = new Item(this, "Root", "This is an root item", true);
        Item item = new Item(this, title, name, true);
        mindMappingView.addItem(item, root,100,10,ItemLocation.TOP,true,null);

    }

    private void createMindMap(){
        // Create the MindMap object
        MindMappingView mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);

        Item item = new Item(this, "Root", "This is a root item", true);
        mindMappingView.addCentralItem(item, false); //I didn't want to make the root drag able

        Item child = new Item(this, "Verbaasd", "Surprised", true);
        mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null);

        Item child2 = new Item(this, "Goed", "Good", true);
        Connection connection = new Connection(item, child);
        ConnectionTextMessage connectionTextMessage = new ConnectionTextMessage(this);
        connectionTextMessage.setText("message");
        mindMappingView.addItem(child2, item, 150, 10, ItemLocation.BOTTOM, true,connectionTextMessage);


    }

    /**
     * Edit WordMap methods
     * Need to create objects and then display.
     */
    // creating a new wordmap.
    private void createWordMap(){
         createMindMap();
    }
    // if the wordmap exists create a node in the map.
    private void createNode(){

    }

    // edit the node, text or connection
    private void editNode(){

    }
    // delete a node from an existing wordmap
    private void deleteNode(){

    }

    /**
     * Connection stuff
     */
    // create connection
    private void createConnection(){

    }

    // delete connection (are connectionless nodes allowed?
    private void deleteConnection(){

    }

    // editConnection (maybe to another node)
    private void editConnection(){

    }




}
