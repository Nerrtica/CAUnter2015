package kr.ac.cau.cse.caunter2015.dealActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by miri1 on 2015-11-09.
 */
public class DealExpandableAdapter extends BaseExpandableListAdapter {
    private ArrayList<Category> categories;
    private ArrayList<ArrayList<Product>> products;
    private LayoutInflater inflater;
    private Context context;

    public DealExpandableAdapter(Context context, ArrayList<Category> categories, ArrayList<ArrayList<Product>> products) {
        this.context = context;
        this.categories = categories;
        this.products = products;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Product getChild(int groupPosition, int childPosition) {
        return products.get(groupPosition).get(childPosition);
    }

    @Override
    public Category getGroup(int groupPosition) {
        return categories.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return products.get(groupPosition).get(childPosition).getId();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return categories.get(groupPosition).getId();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        GridView gridView;
        DealAdapter adapter;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.deal_grid_layout, null);
        }

        gridView = (GridView) convertView.findViewById(R.id.productGrid);
        adapter = new DealAdapter(context, products.get(groupPosition));
        gridView.setAdapter(adapter);

        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastGroup, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.register_group_layout, null);
        }
        TextView category_name_TextView = (TextView) convertView.findViewById(R.id.category_text_view);
        category_name_TextView.setText(categories.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return products.size();
    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}

