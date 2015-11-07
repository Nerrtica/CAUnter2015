package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by miri1 on 2015-11-07.
 */
public class DealAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private ArrayList<Product> productList;

    public DealAdapter(Context context,int layoutId, ArrayList<Product> productList) {
        this.context = context;
        this.layoutId = layoutId;
        this.productList = productList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.product_deal_layout, parent, false);
        }

        TextView nameText = (TextView) convertView.findViewById(R.id.textView);
        TextView priceText = (TextView) convertView.findViewById(R.id.textView2);
        EditText numText = (EditText) convertView.findViewById(R.id.editText);

        nameText.setText(productList.get(position).getName());
        priceText.setText(String.valueOf(productList.get(position).getPrice()));
        numText.setText(String.valueOf(productList.get(position).getCurrentStock()));

        return convertView;
    }
}
