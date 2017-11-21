package com.haider.expandablerecyclerview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;

import com.haider.expandablerecyclerview.adapter.FamilyAdapter;
import com.haider.expandablerecyclerview.model.ChildModel;
import com.haider.expandablerecyclerview.model.ParentModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExpandableGroup expandedGroup;
    private ArrayList<ParentModel> relashionShipsList = new ArrayList<>();

    private FamilyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        setData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FamilyAdapter(this, relashionShipsList);
        recyclerView.setAdapter(adapter);
        adapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
            @Override
            public void onGroupExpanded(ExpandableGroup group) {
                if (expandedGroup != null
                        && !expandedGroup.equals(group)
                        && adapter.isGroupExpanded(expandedGroup)) {
                    adapter.toggleGroup(expandedGroup);
                    adapter.notifyDataSetChanged();
                }
                expandedGroup = group;
            }
            @Override
            public void onGroupCollapsed(ExpandableGroup group) {
            }
        });

    }


    private void setData() {

        ArrayList<ChildModel> brothersNames = new ArrayList<>();
        brothersNames.add(new ChildModel("Hamdaan Shahzad", ContextCompat.getDrawable(getApplicationContext(),R.drawable.hamdaan)));
        brothersNames.add(new ChildModel("Haider Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.haider)));
        brothersNames.add(new ChildModel("Sabir Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.ahmad)));
        brothersNames.add(new ChildModel("Jafer Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.jafer)));
        brothersNames.add(new ChildModel("Faryad Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.hamdaan)));
        brothersNames.add(new ChildModel("Shahbaz Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.shahbaz)));
        brothersNames.add(new ChildModel("Shahzad Arif",ContextCompat.getDrawable(getApplicationContext(),R.drawable.shahzad)));

        ArrayList<ChildModel> cousinsNamesList = new ArrayList<>();
        cousinsNamesList.add(new ChildModel("Umar Irshad",ContextCompat.getDrawable(getApplicationContext(),R.drawable.umar)));
        cousinsNamesList.add(new ChildModel("Usman Irshad",ContextCompat.getDrawable(getApplicationContext(),R.drawable.usman)));
        cousinsNamesList.add(new ChildModel("Ali Irshad",ContextCompat.getDrawable(getApplicationContext(),R.drawable.ali)));
        cousinsNamesList.add(new ChildModel("Abubakar Irshad",ContextCompat.getDrawable(getApplicationContext(),R.drawable.bakar)));

        ArrayList<ChildModel> friendNames = new ArrayList<>();
        friendNames.add(new ChildModel("Noshaid Ali",ContextCompat.getDrawable(getApplicationContext(),R.drawable.noshaid)));
        friendNames.add(new ChildModel("Yasir Rafique",ContextCompat.getDrawable(getApplicationContext(),R.drawable.yasir)));
        friendNames.add(new ChildModel("Wasif Ali",ContextCompat.getDrawable(getApplicationContext(),R.drawable.wasif)));
        friendNames.add(new ChildModel("Nouman Talish",ContextCompat.getDrawable(getApplicationContext(),R.drawable.nouman)));

        relashionShipsList.add(new ParentModel("Family Names", brothersNames));
        relashionShipsList.add(new ParentModel("Cousins Names", cousinsNamesList));
        relashionShipsList.add(new ParentModel("Friends Name", friendNames));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}
