package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Product;
import kr.ac.cau.cse.caunter2015.database.DBManager;

public class DealActivity extends Activity implements View.OnClickListener {
    private int totalPrice = 0;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);

        dbManager = new DBManager(this);
        ArrayList<Product> productList = new ArrayList<>();

        //get data from event select activity
        Intent intentEvent = getIntent();
        int eventId = intentEvent.getIntExtra("eventId",0);

        productList = dbManager.selectProduct(eventId);

        createButton(productList);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_search) {
            //search implement
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
    }


    private void createButton(final ArrayList<Product> productList) {
    //  Make button List
        /*
        int size = productList.size();
        final Button btnList[] = new Button[size];

        for(int i=0;i<size;i++){
            btnList[i]=new Button(this);
            btnList[i].setWidth(150);
            btnList[i].setHeight(150);
            btnList[i].setText(productList.get(i).getName()+"\n"+productList.get(i).getPrice()+"\n"+productList.get(i).getInitialStock());
            btnList[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
        */
    }
}
