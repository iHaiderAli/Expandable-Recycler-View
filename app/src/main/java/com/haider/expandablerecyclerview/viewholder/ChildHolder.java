package com.haider.expandablerecyclerview.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haider.expandablerecyclerview.model.ChildModel;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import com.haider.expandablerecyclerview.R;

public class ChildHolder extends ChildViewHolder {

    private TextView childName;
    private ImageView userImage;

    public ChildHolder(View itemView) {
        super(itemView);

        childName = (TextView) itemView.findViewById(R.id.childName);
        userImage = (ImageView) itemView.findViewById(R.id.userImage);
    }

    public void onBind(ChildModel childModel, ExpandableGroup group) {

        childName.setText(childModel.getName());
        userImage.setImageDrawable(childModel.getUserImage());
    }
}
