package kr.ac.cau.cse.caunter2015.register;

import kr.ac.cau.cse.caunter2015.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by Nerrtica on 15. 11. 5..
 */
public class CustomAdapter extends BaseExpandableListAdapter {
    public ArrayList<Category> categories;
    public ArrayList<ArrayList<Product>> products;
    public LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Category> categories, ArrayList<ArrayList<Product>> products) {
        this.categories = categories;
        this.products = products;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.register_child_layout, null);
        }
        TextView product_name_TextView = (TextView) convertView.findViewById(R.id.product_text_view);
        product_name_TextView.setText(products.get(groupPosition).get(childPosition).getName());

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
        return products.get(groupPosition).size();
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
