package com.example.mytestgraph;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button editBtn = findViewById(R.id.editBtn);
        Button practiseBtn = findViewById(R.id.practiseBtn);
        Button loadBtn = findViewById(R.id.loadBtn);

        // add listeners to the buttons
        editBtn.setOnClickListener(new EditListener());
        practiseBtn.setOnClickListener(new PractiseListener());
        loadBtn.setOnClickListener(new LoadListener());

    }

    // geen Button maar een Spinner nodig


     class EditListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Toast.makeText(v.getContext(),"Pressed edit",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), EditWordMap.class);
            startActivity(intent);
        }
    }

    class LoadListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Toast.makeText(v.getContext(),"Pressed load",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(),EditWordMap.class);
            startActivity(intent);

        }
    }

   class PractiseListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Pressed practise",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(),PractiseWordMap.class);
            startActivity(intent);
        }
    }



}
