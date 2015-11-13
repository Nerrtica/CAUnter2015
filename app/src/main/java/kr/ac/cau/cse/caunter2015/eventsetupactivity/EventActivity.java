package kr.ac.cau.cse.caunter2015.eventsetupactivity;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import kr.ac.cau.cse.caunter2015.R;

public class EventActivity extends ActivityGroup {
    private TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        tabhost = (TabHost)findViewById(R.id.tabHost);
        tabhost.setup(this.getLocalActivityManager());

        TabHost.TabSpec tbdspec = tabhost.newTabSpec("tab_date");
        TabHost.TabSpec tbsspec = tabhost.newTabSpec("tab_sell");
        TabHost.TabSpec tbgspec = tabhost.newTabSpec("tab_graph");

        tbdspec.setIndicator("",getDrawable(R.drawable.tabselection_date));
        tbdspec.setContent(new Intent(this, DateTabActivity.class));
        tbsspec.setIndicator("", getDrawable(R.drawable.tabselection_sell));
        tbsspec.setContent(new Intent(this, SellTabActivity.class));
        tbgspec.setIndicator("", getDrawable(R.drawable.tabselection_stat));
        tbgspec.setContent(new Intent(this, GraphTabActivity.class));

        tabhost.addTab(tbdspec);
        tabhost.addTab(tbsspec);
        tabhost.addTab(tbgspec);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
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
}
