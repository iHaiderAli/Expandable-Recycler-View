# ExpandableRecyclerView
Make an expandable list view by RecyclerView with support for multiple view types in Android. 

[![collapsed_list.png](https://s18.postimg.org/7nulvmugp/collapsed_list.png)](https://postimg.org/image/5w1n0qb3p/) [![brothers.png](https://s18.postimg.org/s7zfu6fdl/brothers.png)](https://postimg.org/image/n9bxfnbkl/) [![cousins.png](https://s18.postimg.org/5ja8un8ah/cousins.png)](https://postimg.org/image/56iuogq0l/) [![friends.png](https://s18.postimg.org/ta9mcsis9/friends.png)](https://postimg.org/image/56iuoi0b9/)

## Download
ExpandableRecyclerView:
```groovy
compile 'com.thoughtbot:expandablerecyclerview:1.3'
```
## Usage
Let's say you are a Father and you have to build an app to show a list of your child members `Parent`s with a list of their children `Child`s.

First, define your custom `ExpandableGroup` class:

``` java
public class Parent extends ExpandableGroup<Artist> {

  public Parent(String title, List<Child> items) {
    super(title, items);
  }
}
```

Next up, let's create the `ChildViewHolder` and `ParentViewHolder`. These are both wrappers around regular ol' `RecyclerView.ViewHolder`s so implement any view inflation and binding methods you may need.

``` java
public class ParentViewHolder extends GroupViewHolder

  private TextView parent_name;

  public ParentViewHolder(View itemView) {
    super(itemView);
    parent_name = itemView.findViewById(R.id.parent_name);
  }

  public void setParentName(ExpandableGroup group) {
    parent_name.setText(group.parentName());
  }
}
```

``` java
public class childViewHolder extends ChildViewHolder {

  private TextView child_name;

  public childViewHolder(View itemView) {
    super(itemView);
    child_name = itemView.findViewById(R.id.child_name);
  }

  public void onBind(Child child) {
    child_name.setText(child.getChildName());
  }
}
```

Now we are ready for the juicy part - let's make our `ExpandableRecyclerViewAdapter`

By including your `ParentViewHolder` and `ChildViewHolder` in the definition of the class, you'll see that the `onCreateGroupViewHolder` and `onCreateChildViewHolder` methods return the correct type :thumbsup:

``` java
public class ParentAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder, ChildViewHolder> {

  public ParentAdapter(List<? extends ExpandableGroup> groups) {
    super(groups);
  }

  @Override
  public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.list_item_parent, parent, false);
    return new ParentViewHolder(view);
  }

  @Override
  public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.list_item_child, parent, false);
    return new ChildViewHolder(view);
  }

  @Override
  public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group,
      int childIndex) {
    final Child child = ((Child) group).getItems().get(childIndex);
    holder.setchildName(child.getChildName());
  }

  @Override
  public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition,
      ExpandableGroup group) {
    holder.setParentName(group);
  }
}
```

Lastly let's you'll need either an `Activity` or `Fragment` to host your adapter. Once you've got that up and running, all that's left if to instantiate your fancy new `ParentAdapter` with a `List<Parent>`

``` java
public class ParentActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    ...

    List<Parent> parents = getParents();
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);

    //instantiate your adapter with the list of genres
    ParentAdapter adapter = new ParentAdapter(genres);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    ...

  }
}
```

## Saving And Restoring Expand / Collapse State

If you want to save the expand and collapse state of your adapter, you have to explicitly call through to the adapters `onSaveInstanceState()` and `onRestoreInstanceState()`in the calling `Activity`

```java
public class ParentActivity extends Activity {

  ...

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

```

## Adding Custom Expand / Collapse Animations

If you want to add a custom `Drawable` that animates based on a groups state, override the `expand()` and `collapse()` methods in your `ParentpViewHolder`:

``` java
public class ParentpViewHolder extends GroupViewHolder {

  ...

  @Override
  public void expand() {
    animateExpand();
  }

  @Override
  public void collapse() {
    animateCollapse();
  }
}
```

## Listening to Expand/Collapse events

If you want register an `ExpandCollapseListener` outside of the adapter, you can simply call `setOnGroupExpandCollapseListener` on the `ExpandableRecyclerViewAdapter`

``` java
  adapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
    @Override
    public void onGroupExpanded(ExpandableGroup group) {

    }

    @Override
    public void onGroupCollapsed(ExpandableGroup group) {

    }
  });
```
## Authors
* **Haider Ali**

## Contact Me
 if you have any query or want to discuss some thing realted to project or anything else please feel free to contact me.
 ```
Gmail: ihaiderali.arif@gmail.com
Skype: haider7577 
Linked in: https://www.linkedin.com/in/haider-ali-203ab7126/
```
