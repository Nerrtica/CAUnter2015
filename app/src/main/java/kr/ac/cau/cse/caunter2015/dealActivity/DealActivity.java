package kr.ac.cau.cse.caunter2015.dealActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Product;
import kr.ac.cau.cse.caunter2015.database.DBManager;

public class DealActivity extends Activity implements View.OnClickListener {
    private int totalPrice = 0;
    private ActionBar abar;
    private DBManager dbManager;
    ExpandableListView deal_expandableListView;
    DealExpandableAdapter adapter;
    ArrayList<ArrayList<Product>> productList;
    ArrayList<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);

    //    dbManager = new DBManager(this);


        //get data from event select activity
    //    Intent intentEvent = getIntent();

    //    int eventId = intentEvent.getIntExtra("eventId",0);
    //    int categoryId = intentEvent.getIntExtra("categoryId",0);

        abar = getActionBar();
        abar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
        abar.setDisplayUseLogoEnabled(false);
//      set title on action bar
//      abar.setTitle("");
        abar.setDisplayShowTitleEnabled(true);
        abar.setBackgroundDrawable(new ColorDrawable(0xFF0CA3E8));


//      button for start SettleActivity

//        ImageButton calcButton = (ImageButton)findViewById(R.id.calcButton);
//        final Intent intent = new Intent(this, SettleActivity.class);

//        calcButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(intent);
//            }
//        });

        // set data by dbManager
        // productList = dbManager.selectProduct(categoryId);
        // categoryList = dbManager.selectCategory(eventId);

        deal_expandableListView = (ExpandableListView) findViewById(R.id.dealExpandableListView);
        adapter = new DealExpandableAdapter(this,categoryList,productList);
        deal_expandableListView.setAdapter(adapter);

        adapter.setOnDataChangedListener(new DealExpandableAdapter.OnDataChangedListener() {
            @Override
            public void onDataChanged() {
                TextView totalView = (TextView)findViewById(R.id.totalPriceText);
                totalView.setText(String.valueOf(adapter.getTotalPrice()));
            }
        });

        deal_expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        deal_expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
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

 }

