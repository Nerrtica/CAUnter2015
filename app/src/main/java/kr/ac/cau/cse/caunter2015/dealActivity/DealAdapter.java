package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by miri1 on 2015-11-07.
 */
public class DealAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> productList;

    public DealAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.deal_product_layout, parent, false);
        }

        TextView nameText = (TextView) convertView.findViewById(R.id.productNameText);
        TextView priceText = (TextView) convertView.findViewById(R.id.productPriceText);
        final EditText numText = (EditText) convertView.findViewById(R.id.productStockText);
        ImageView stockImg = (ImageView) convertView.findViewById(R.id.stockIncImg);

        nameText.setText(productList.get(position).getName());
        priceText.setText(String.valueOf(productList.get(position).getPrice()));
        numText.setText(String.valueOf(0));
        stockImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wantBuy = Integer.parseInt(numText.getText().toString());
                if (wantBuy >= productList.get(position).getCurrentStock()) ;
                else {
                    numText.setText(String.valueOf(wantBuy+1));
                }
            }
        });

        return convertView;
    }
}
