package kr.ac.cau.cse.caunter2015.eventsetupactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.cau.cse.caunter2015.R;
import kr.ac.cau.cse.caunter2015.eventsetupactivity.model.EventData;

/**
 * Created by Julian on 2015-11-11.
 */
public class EventAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<EventData> dataList;
    private static LayoutInflater inflater;

    EventAdapter(Context context,ArrayList<EventData> list) {
        this.context = context;
        this.dataList = list;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        String dateInText="";
        if(vi == null) vi = inflater.inflate(R.layout.custom_item,null);
        TextView eventName = (TextView)vi.findViewById(R.id.item_event_name);
        TextView eventDate = (TextView)vi.findViewById(R.id.item_event_date);
        eventName.setText(dataList.get(position).getName());
        eventDate.setText(dateInText);
        return vi;
    }
}
