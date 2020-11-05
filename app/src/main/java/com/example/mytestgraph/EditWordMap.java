package com.example.mytestgraph;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytestgraph.model.Arrow;
import com.example.mytestgraph.model.Card;
import com.example.mytestgraph.model.WordMap;
import java.util.HashMap;
import java.util.Map;
import me.jagar.mindmappingandroidlibrary.Listeners.OnItemClicked;
import me.jagar.mindmappingandroidlibrary.Views.Connection;
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage;
import me.jagar.mindmappingandroidlibrary.Views.Item;
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation;
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView;

/**
 * The class needs a WordMap to work with
 * Then translate it to a visual representation.
 * View	Extends
 *
 * Item	                    LinearLayout
 * MindMappingView	        RelativeLayout
 * ConnectionTextMessage	TextView
 * Item's Title	            TextView
 * Item's Content	        TextView
 */
public class EditWordMap extends AppCompatActivity {

    // Item as key and Card as value
    final private Map<Item, Card> cards = new HashMap<Item, Card>();
    final private Map<Connection, Long> arrows = new HashMap<>();
    // MindMapView
    MindMappingView mindMappingView;
    // Create WordMap (or load it from database)
    WordMap wordMap = new WordMap();
    Item selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word_map);
        mindMappingView = (MindMappingView) findViewById(R.id.mind_mapping_view);
        // begin with a single item (the root)
        Card card = wordMap.createCard();
        card.setFamiliarWord("new word");
        card.setForeignWord("new word");
        Item item = new Item(this,
                              card.getFamiliarWord(),
                              card.getForeignWord(),
                   true);

        cards.put(item, card);
        Item newItem = resetItemStyle(item);
        mindMappingView.addCentralItem(newItem, true);
        mindMappingView.setOnItemClicked(new ItemListener());
    }


    public void showMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(new PopupListener());
        popup.inflate(R.menu.item_menu);
        popup.show();
    }

    private class PopupListener implements PopupMenu.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Item i = selectedItem;
                switch (item.getItemId()) {
                    case R.id.delete:
                        // delete item
                        deleteItem(i);
                        return true;
                    case R.id.add:
                        // create item
                        createItem(i);
                        return true;
                    case R.id.edit:
                        // edit item
                        editItem(i);
                    default:
                        return false;
                }
        }
    }


    private Item resetItemStyle(Item item){

        LinearLayout myItem = (LinearLayout) item.getRootView();
        GradientDrawable shape = new GradientDrawable();
        shape.setColor(Color.WHITE);
        shape.setCornerRadius(2);
        myItem.setBackgroundColor(Color.WHITE);
        myItem.setGravity(Gravity.CENTER);
        myItem.setPadding(50, 20, 50, 20);
        return (Item) myItem;

    }

    private void setItemEditable(LinearLayout layout){

        EditText title = new EditText(layout.getContext());
        EditText context = new EditText(layout.getContext());
        layout.removeAllViews();
        layout.addView(title);
        layout.addView(context);

    }


    private void setItemBack(LinearLayout layout){

        TextView title = new TextView(layout.getContext());
        TextView context = new TextView(layout.getContext());
        layout.removeAllViews();
        layout.addView(title);
        layout.addView(context);

    }


    // listen for items clicked.
    private class ItemListener implements OnItemClicked {

        @Override
        public void OnClick(Item item) {
            //Toast.makeText(item.getContext(),"item " +item.toString(),Toast.LENGTH_SHORT).show();
            selectedItem = item;
            showMenu(item);
        }
    }

    /**
     * delete item from map
     * public HashMap<Connection, Integer> getAllConnections(){
     *         return connections;
     *     }
     */
    private void deleteItem(Item item){
        RelativeLayout layout = (RelativeLayout) mindMappingView;
        layout.removeView(item);
        wordMap.removeCard(cards.get(item));
        cards.remove(item);
    }

    /**
     * creating a node in the map.
     * create new empty card, then create the item as well
     * no arrow needed.
     */
    private void createItem(Item from){

        Card card = wordMap.createCard();
        card.setFamiliarWord("");
        card.setForeignWord("");

        Item item = new Item(this,
                card.getFamiliarWord(),
                card.getForeignWord(),true);
        cards.put(item, card);
        selectedItem = item;
        resetItemStyle(item);
        mindMappingView.addItem(item,from,2,1,ItemLocation.TOP,
                        true,null);
        Toast.makeText(this,"Created Item",Toast.LENGTH_SHORT).show();
        LinearLayout layout = (LinearLayout) item;
        setItemEditable(layout);
    }

    /**
     * edit the text in the item in the wordmap.
     */
    private void editItem(Item item){
         LinearLayout layout = (LinearLayout) item;
         setItemEditable(layout);
         // the item should store things in the card once done

         item.setOnContextClickListener(new EditListener());

    }

    private class EditListener implements View.OnContextClickListener{

        // when in here no listening on items

        @Override
        public boolean onContextClick(View view) {

            return false;
        }
    }

    private void storeCardFromItem(Item item){
        String first = (String) item.getTitle().getText();
        String second = (String) item.getContent().getText();
        Card card = cards.get(item);
        card.setFamiliarWord(first);
        card.setForeignWord(second);
    }

    /**
     * Connections should be arrows in the wordmap.
     */
    // create connection
    private void createConnection(Item from, Item to){

    }

    // delete connection
    private void deleteConnection(Item from, Item to){
        // remove the arrow as well.
        Card fCard = cards.get(from);
        //Arrow arrow = wordMap.arrows.get();
        //wordMap.removeArrow();

    }

    // editConnection (maybe relay to another node)
    private void editConnection(){

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
        mindMappingView.setOnItemClicked(new OnItemClicked() {
            @Override
            public void OnClick(Item item) {
                item.setPressed(true);

            }
        });
    }




}
