package com.haider.expandablerecyclerview.model;

import android.annotation.SuppressLint;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

@SuppressLint("ParcelCreator")
public class ParentModel extends ExpandableGroup<ChildModel> {

    public ParentModel(String title, List<ChildModel> items) {
        super(title, items);
    }
}

