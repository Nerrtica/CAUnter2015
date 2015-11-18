package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by miri1 on 2015-11-18.
 */
public class SettleAdapter extends BaseAdapter {
    Context context;
    List<Integer> amountList;
    ArrayList<Product> productList;

    public SettleAdapter(Context context, List<Integer> amountList, ArrayList<Product> productList) {
        super();
        this.context = context;
        this.amountList = amountList;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.deal_product_layout, parent, false);
        }

        TextView nameView = (TextView)convertView.findViewById(R.id.itemNameText);
        TextView amountView = (TextView)convertView.findViewById(R.id.itemAmountText);

        nameView.setText(productList.get(position).getName());
        amountView.setText(String.valueOf(amountList.get(position)));
        return convertView;
    }
}
