package com.elhady.donation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.elhady.donationp.Interface.ItemClickListener;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DrugsList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference drugsList;
    String categoryId ="";
    FirebaseRecyclerAdapter<Drugs,DrugsViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        drugsList = database.getReference("Drugs");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_drugs);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent here
        if (getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");

        if (!categoryId.isEmpty() && categoryId != null)
        {

            loadListDrugs(categoryId);
        }
    }

    private void loadListDrugs(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Drugs, DrugsViewHolder>(Drugs.class,
                R.layout.drugs_item,
                DrugsViewHolder.class,
                drugsList.orderByChild("MenuId").equalTo(categoryId) // like: Select * from foods where mneu Id
        ) {
            @Override
            protected void populateViewHolder(DrugsViewHolder viewHolder, Drugs model, int position) {
                viewHolder.drugs_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.drugs_image);

                final Drugs local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override

                    public void onClick(View view, int position, boolean isLongClick) {
                        //Start new activity
                        Intent drugsDetail = new Intent(DrugsList.this,DrugsDetail.class);
                        drugsDetail.putExtra("DrugsId",adapter.getRef(position).getKey());
                        startActivity(drugsDetail);
                    }
                });

            }
        };
        //Set adapter
        recyclerView.setAdapter(adapter);
    }


}

