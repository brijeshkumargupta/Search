package com.birjulabsinc.search.Program.Program;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.birjulabsinc.search.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import static com.birjulabsinc.search.Program.Program.Adapter.DESC;
import static com.birjulabsinc.search.Program.Program.Adapter.TITLE;
import static com.birjulabsinc.search.Program.Program.Adapter.IMAGE;
import static com.birjulabsinc.search.Program.Program.Adapter.NAME;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent =getIntent();

        final String image =intent.getStringExtra(IMAGE);
        final String name =intent.getStringExtra(NAME);
        String  id=intent.getStringExtra(TITLE);
        String desc = intent.getStringExtra(DESC);

        TextView nameText =findViewById(R.id.nameText);
        TextView descText =findViewById(R.id.descDet);
        final ImageView imageView =findViewById(R.id.imageDet);


        //toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Display custom title
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle(id);

        // Display the back arrow

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Back arrow click event to go to the parent Activity
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //idText.setText(id);
        nameText.setText(name);
        descText.setText(desc);
        //Picasso.get().load(image).into(imageView);
        Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

                Picasso.get().load(image).into(imageView);

            }
        });

    }

//    private void toolbarFunc() {
//        Intent intent =getIntent();





//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Define Back Button Function
//            }
//        });
//    }


}
