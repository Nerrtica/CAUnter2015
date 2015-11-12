package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by miri1 on 2015-11-09.
 */
public class DealExpandableAdapter extends BaseExpandableListAdapter {
    private ArrayList<Category> categories;
    private ArrayList<ArrayList<Product>> products;
    private ArrayList<List<Integer>> howMany;
    private LayoutInflater inflater;
    private Context context;
    OnDataChangedListener mOnDataChangedListener;


    public DealExpandableAdapter(Context context, ArrayList<Category> categories, ArrayList<ArrayList<Product>> products) {
        this.context = context;
        this.categories = categories;
        this.products = products;
        howMany = new ArrayList<>();
        howMany.add(Arrays.asList(0,0));
        howMany.add(Arrays.asList(0,0));
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
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        DealAdapter adapter;
        ChildHolder holder;

        if (convertView == null) {
            holder = new ChildHolder();
            convertView = inflater.inflate(R.layout.deal_grid_layout, null);
            holder.gridView = (GridView)convertView.findViewById(R.id.productGrid);
            convertView.setTag(holder);
        }
        else{
            holder = (ChildHolder)convertView.getTag();
        }

        adapter = new DealAdapter(context, products.get(groupPosition),howMany.get(groupPosition));
        holder.gridView.setAdapter(adapter);

        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView amountText = (TextView) view.findViewById(R.id.AmountText);
                int amount = Integer.parseInt(String.valueOf(amountText.getText()));
                if (amount >= products.get(groupPosition).get(position).getCurrentStock()) ;
                else {
                    amountText.setText(String.valueOf(amount + 1));
                    howMany.get(groupPosition).set(position, amount + 1);

                    if(mOnDataChangedListener != null) {
                        mOnDataChangedListener.onDataChanged();
                    }
                }
            }
        });

        holder.gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("input amount");
                final EditText editNum = new EditText(context);
                editNum.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(editNum);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int storage = Integer.parseInt(String.valueOf(products.get(groupPosition).get(position).getCurrentStock()));

                        if (Integer.parseInt(editNum.getText().toString()) >= storage) {
                            howMany.get(groupPosition).set(position, storage);
                        } else if (Integer.parseInt(editNum.getText().toString()) < 0) {
                            howMany.get(groupPosition).set(position, 0);
                        } else {
                            howMany.get(groupPosition).set(position, Integer.valueOf(editNum.getText().toString()));
                        }
                        if(mOnDataChangedListener != null) {
                            mOnDataChangedListener.onDataChanged();
                        }
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });


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
        return 1;
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
        return false;
    }

    public int getTotalPrice() {
        int totalprice = 0;
        for (int i=0;i<products.size();i++) {
            for(int j=0;j<products.get(i).size();j++){
                totalprice += products.get(i).get(j).getPrice() * howMany.get(i).get(j);
            }
        }
        return totalprice;
    }

    public interface OnDataChangedListener {
        public void onDataChanged();
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener){
        mOnDataChangedListener = onDataChangedListener;
    }

    public class ChildHolder {
        public GridView gridView;
    }

}

