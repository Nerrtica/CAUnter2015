package kr.ac.cau.cse.caunter2015;

import android.app.Activity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Nerrtica on 15. 8. 2..
 */
public class RegisterActivity extends Activity implements View.OnClickListener {
    SQLiteDatabase productDB = openOrCreateDatabase("FILENAME", SQLiteDatabase.CREATE_IF_NECESSARY, null);
    private class product {
        private String name;
        private String category;
        private int price;
        private int initialStock;
        private int salesVolumn;
        private int currentStock;

        protected void setProduct (String name, String category, int price, int initialStock, int currentStock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.initialStock = initialStock;
            this.currentStock = currentStock;
            this.salesVolumn = this.initialStock - this.currentStock;
        }

        protected void setName (String name) {
            this.name = name;
        }

        protected void setCategory (String category) {
            this.category = category;
        }

        protected void setPrice (int price) {
            this.price = price;
        }

        protected void setInitialStock (int initialStock) {
            if (initialStock < this.currentStock) {
                Toast.makeText(getApplicationContext(), "ERROR : 최초 재고량이 현재 재고량보다 적습니다", Toast.LENGTH_SHORT).show();
                return;
            }
            this.initialStock = initialStock;
            this.salesVolumn = this.initialStock - this.currentStock;
        }

        protected void setCurrentStock (int currentStock) {
            if (currentStock > this.initialStock) {
                Toast.makeText(getApplicationContext(), "ERROR : 현재 재고량이 최초 재고량보다 많습니다", Toast.LENGTH_SHORT).show();
                return;
            }
            this.currentStock = currentStock;
            this.salesVolumn = this.initialStock - this.currentStock;
        }

        protected String getName () { return this.name; }
        protected String getCategory () { return this.category; }
        protected int getPrice () { return this.price; }
        protected int getInitialStock () { return this.initialStock;}
        protected int getCurrentStock () { return this.currentStock; }
        protected int getSalesVolumn () { return this.salesVolumn; }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                //ADD
                break;
            case R.id.modifyButton:
                //MODIFY
                break;
            case R.id.deleteButton:
                //DELETE
                break;
        }
    }
}
