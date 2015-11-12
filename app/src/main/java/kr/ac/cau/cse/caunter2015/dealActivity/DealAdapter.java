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
 * Created by miri1 on 2015-11-07.
 */
public class DealAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> productList;
    private List<Integer> buyList;

    public DealAdapter(Context context, ArrayList<Product> productList, List<Integer> buyList) {
        this.context = context;
        this.productList = productList;
        this.buyList = buyList;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.deal_product_layout, parent, false);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.productNameText);
            holder.priceView = (TextView) convertView.findViewById(R.id.productPriceText);
            holder.numView = (TextView) convertView.findViewById(R.id.AmountText);

            holder.numView.setText(String.valueOf(buyList.get(position)));
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameView.setText(productList.get(position).getName());
        holder.priceView.setText(String.valueOf(productList.get(position).getPrice()));

        return convertView;
    }

    public class ViewHolder {
        public TextView nameView;
        public TextView priceView;
        public TextView numView;
    }
}
