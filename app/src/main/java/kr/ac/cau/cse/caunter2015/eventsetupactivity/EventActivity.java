package kr.ac.cau.cse.caunter2015.eventsetupactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.Timestamp;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;
import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventList;

public class EventActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
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

    private EventList eventList = new EventList();

    private void initEventList() {
        //From database, the data of recently created events should be drawn out.
    }

    private void addEvent(EventData newEvent) {

    }

    private void deleteEvent(EventData targetEvent) {

    }

    private void editEvent(EventData targetEvent,String name,Timestamp sDate, Timestamp eDate) {
        targetEvent.setEventName(name);
        targetEvent.editStart(sDate);
        targetEvent.editEnds(eDate);
    }
}
