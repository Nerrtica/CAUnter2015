package kr.ac.cau.cse.caunter2015.eventsetupactivity;

import android.app.Dialog;

import java.sql.Timestamp;

import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;

public class EventCreationDialog {
/*
    @Overrides
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation_dialog);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_creation_dialog, menu);
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
*/
    private EventData createNewEvent(int ID, String name, Timestamp sDate, Timestamp eDate) {
        EventData newEvent = new EventData(ID,name,sDate,eDate);
        return newEvent;
    }

    private EventData createNewEvent(String name, Timestamp sDate, Timestamp eDate) {
        int ID = 0000;//this may be randomized, non-duplicating generation
        EventData newEvent = new EventData(ID,name,sDate,eDate);
        return newEvent;
    }
}
