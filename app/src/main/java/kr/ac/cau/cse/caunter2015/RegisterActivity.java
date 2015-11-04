package kr.ac.cau.cse.caunter2015;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import kr.ac.cau.cse.caunter2015.register.CustomAdapter;
import kr.ac.cau.cse.caunter2015.data.Category;
import kr.ac.cau.cse.caunter2015.data.Product;

/**
 * Created by Nerrtica on 15. 8. 2..
 */
public class RegisterActivity extends Activity {

    ActionBar abar;

    ExpandableListView product_ExpandableListView;
    CustomAdapter adapter;
    ArrayList<Category> categories;
    ArrayList<ArrayList<Product>> products;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        int event_pk = getIntent().getExtras().getInt("Event");

        abar = getActionBar();
        abar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
        abar.setDisplayUseLogoEnabled(false);
//      event_pk값을 이용하여 행사명을 받아와 Title로 지정
//      또한 해당 값을 이용해 setData 함수 내부에서 데이터를 받아오도록 함
//      abar.setTitle("");
        abar.setDisplayShowTitleEnabled(true);
        abar.setBackgroundDrawable(new ColorDrawable(0xFF0CA3E8));

        product_ExpandableListView = (ExpandableListView) findViewById(R.id.product_expandable_list_view);
        setData(event_pk);
        adapter = new CustomAdapter(this, categories, products);
        product_ExpandableListView.setAdapter(adapter);
        product_ExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                return false;
            }
        });

        product_ExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void setData(int event_pk) {
        // event_pk값을 이용해 데이터를 받아옴
    }
}
