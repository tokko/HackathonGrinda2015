package com.beamon.hackathongrinda2015;

import android.app.ListActivity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CuddleActivity extends ListActivity {

    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cuddle);
        adapter = new MessageAdapter(this, R.layout.message_entry);
        final int id = getSharedPreferences(MainActivity.class.getSimpleName(), MODE_PRIVATE).getInt(MainActivity.USER_ID, -1);
        adapter.setId(id);
        //setListAdapter(adapter);
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {
                //TODO: get chat history
                return null;
            }
        }.execute();
    }

    public void onCLick(View v){
        //todo: send messages
    }

    private class Message{
        public int sender;
        public String message;
        public long dateReceived;
    }

    private class MessageAdapter extends ArrayAdapter<Message>{
        private ArrayList<Message> messages = new ArrayList<>();
        private int id;

        public MessageAdapter(Context context, int resource) {
            super(context, resource);
        }

        public MessageAdapter(Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public MessageAdapter(Context context, int resource, Message[] objects) {
            super(context, resource, objects);
        }

        public MessageAdapter(Context context, int resource, int textViewResourceId, Message[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public MessageAdapter(Context context, int resource, List<Message> objects) {
            super(context, resource, objects);
        }

        public MessageAdapter(Context context, int resource, int textViewResourceId, List<Message> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public void addItems(ArrayList<Message> messages){
            this.messages.addAll(messages);
        }

        public void setId(int id){
            this.id = id;
        }
        @Override
        public Message getItem(int position) {
            return messages.get(position);
        }

        @Override
        public int getItemViewType(int position) {
            return 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ((TextView)convertView.findViewById(R.id.message)).setText(getItem(position).message);
            ((TextView)convertView.findViewById(R.id.message)).setText(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date(getItem(position).dateReceived)));
            if(getItem(position).sender == id)
                ((LinearLayout) convertView.findViewById(R.id.messageBox)).setGravity(Gravity.END);
            else
                ((LinearLayout) convertView.findViewById(R.id.messageBox)).setGravity(Gravity.START);
            return convertView;
        }

    }
}
