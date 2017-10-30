package com.haider.expandablerecyclerview.viewholder;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import com.haider.expandablerecyclerview.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ParentHolder extends GroupViewHolder {

    private TextView groupName;
    private ImageView parentImage,dropDownImageView;

    public ParentHolder(View itemView) {
        super(itemView);

        groupName = (TextView) itemView.findViewById(R.id.groupName);
        parentImage = (ImageView) itemView.findViewById(R.id.parentImage);
        dropDownImageView = (ImageView) itemView.findViewById(R.id.dropDownImageView);
    }

    @Override
    public void expand() {
        animateCollapse();
    }

    @Override
    public void collapse() {
        animateExpand();
    }

    public void setGroupName(ExpandableGroup group) {
        groupName.setText(group.getTitle());
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(90, 0, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(100);
        rotate.setFillAfter(true);
        dropDownImageView.startAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(0, 90, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(100);
        rotate.setFillAfter(true);
        dropDownImageView.startAnimation(rotate);
    }

}
