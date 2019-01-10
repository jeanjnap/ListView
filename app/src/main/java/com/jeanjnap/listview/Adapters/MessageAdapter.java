package com.jeanjnap.listview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jeanjnap.listview.Models.Message;
import com.jeanjnap.listview.R;

import java.util.List;


public class MessageAdapter extends BaseAdapter {

    private Context context;
    private final List<Message> messages;

    public MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
    }


    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_message, parent, false);

        Message m = messages.get(position);

        TextView message_r, message_e;

        message_r = view.findViewById(R.id.message_r);
        message_e = view.findViewById(R.id.message_e);

        if(m.getId() == 1){
            //Log.i("_res", "Sent message");
            //Log.i("_res", String.format("msg: %s, type: %s", m.getMessage(), m.getId()));
            message_e.setText(m.getMessage());
            message_r.setVisibility(View.GONE);
        } else {
            //Log.i("_res", "Received message");
            //Log.i("_res", String.format("msg: %s, type: %s", m.getMessage(), m.getId()));
            message_r.setText(m.getMessage());
            message_e.setVisibility(View.GONE);
        }


        return view;
    }
}
