package com.example.mytestgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mytestgraph.model.Card;
import com.example.mytestgraph.model.WordMap;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import me.jagar.mindmappingandroidlibrary.Listeners.OnItemClicked;
import me.jagar.mindmappingandroidlibrary.Views.Connection;
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage;
import me.jagar.mindmappingandroidlibrary.Views.Item;
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation;
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;

/**
 * The class needs a WordMap to work with
 * Then translate it to a visual representation.
 */



public class EditWordMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word_map);
        createMindMap();
    }

    // Test WordMap
    private void createMindMap(){
        // Create WordMap
        WordMap testWordMap =  new WordMap();
        // create card in the map
        Card testCard = testWordMap.createCard();
        testCard.setFamiliarWord("Aap");
        testCard.setForeignWord("Monkey");
        Card testCard2 = testWordMap.createCard();
        testCard2.setFamiliarWord("Brood");
        testCard2.setForeignWord("Bread");
        // Map onto the mindmap api
        MindMappingView mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);
        Item item = new Item(this, testCard.getFamiliarWord(), testCard.getForeignWord(),true);
        mindMappingView.addCentralItem(item, false);
        Item child = new Item(this, testCard2.getFamiliarWord(), testCard2.getForeignWord(),true);
        mindMappingView.addItem(child, item, 200, 10, ItemLocation.TOP, true, null);
        // set click listener on background
        mindMappingView.setOnClickListener(new BackgroundClickListener());
        mindMappingView.setOnItemClicked(new OnItemClicked() {
            @Override
            public void OnClick(Item item) {
                item.setPressed(true);
                item.setBackgroundColor(Color.WHITE);
            }
        });
    }

    // set click listener on the whole mindmap we want a popup menu to open
    // if clicked somewhere.
    class BackgroundClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Menu should open", Toast.LENGTH_SHORT).show();
        }
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
