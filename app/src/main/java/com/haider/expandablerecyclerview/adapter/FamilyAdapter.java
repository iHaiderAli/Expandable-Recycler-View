package com.haider.expandablerecyclerview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.haider.expandablerecyclerview.model.ChildModel;
import com.haider.expandablerecyclerview.model.ParentModel;
import com.haider.expandablerecyclerview.viewholder.ChildHolder;
import com.haider.expandablerecyclerview.viewholder.ParentHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import com.haider.expandablerecyclerview.R;

public class FamilyAdapter extends ExpandableRecyclerViewAdapter<ParentHolder, ChildHolder> {

    private Activity activity;

    public FamilyAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public ParentHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new ParentHolder(view);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new ChildHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildHolder holder, int flatPosition, ExpandableGroup group, final int childIndex) {
        final ChildModel phone = ((ParentModel) group).getItems().get(childIndex);
        holder.onBind(phone,group);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Item Clicked "+phone.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(ParentHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);

    }
}
