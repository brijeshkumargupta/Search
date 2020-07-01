package com.birjulabsinc.search.Program.Program;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;

import com.birjulabsinc.search.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    public static final String IMAGE="image";
    public static final String NAME="name";
    public static final String ID="id";
    public static final String DESC="desc";


    DatabaseReference ref;
    ArrayList<Program> list;
    RecyclerView recyclerView;
    SearchView searchView;

    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref = FirebaseDatabase.getInstance().getReference().child("Program");
        ref.keepSynced(true);

        recyclerView = findViewById(R.id.rv);
        searchView = findViewById(R.id.searchView);



        //toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Display custom title
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setTitle("demo");



    }


    @Override
    protected void onStart() {
        super.onStart();

        if (ref != null)
        {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                    {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            list.add((ds.getValue(Program.class)));

                        }

                        mAdapter = new Adapter(getBaseContext(),list);
                        recyclerView.setAdapter(mAdapter);
//                        mAdapter.setOnItemClickListener(MainActivity.this);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
        if (searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);


                    return true;
                }
            });
        }
    }
    private void search(String str)
    {
        ArrayList<Program>myList = new ArrayList<>();

        for (Program object : list)

        {
            if (object.getTitle().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }
        }
        mAdapter  = new Adapter(getBaseContext(),myList);
        recyclerView.setAdapter(mAdapter);




    }




}
