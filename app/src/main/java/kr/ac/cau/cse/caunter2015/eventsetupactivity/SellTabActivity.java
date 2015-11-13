package kr.ac.cau.cse.caunter2015.eventsetupactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.dealActivity.DealActivity;
import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;
import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventList;

public class SellTabActivity extends Activity {
    private ListView listView;
    private EventAdapter listAdapter;
    private EventList eventListInstance;
    private ArrayList<EventData> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_tab);
        eventListInstance = new EventList();
        eventList = eventListInstance.getEventList();

        listAdapter = new EventAdapter(getApplicationContext(),eventList);
        listView = (ListView)findViewById(R.id.date_listView);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new ListViewItemClickListener());
    }

    private class ListViewItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(SellTabActivity.this, DealActivity.class);
            intent.putExtra("Event",SellTabActivity.this.eventList.get(position).getEventID());
            startActivity(intent);
        }
    }
}
