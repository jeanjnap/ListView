package com.jeanjnap.listview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jeanjnap.listview.Adapters.MessageAdapter;
import com.jeanjnap.listview.Models.Message;
import com.jeanjnap.listview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    Button button;
    EditText message;

    List<Message> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        list = (ListView) findViewById(R.id.lista);
        list.setDivider(null);

        getMessages();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();

                messages.add( new Message((long) 1, msg));
                list.setSelection(list.getCount() - 1);
                message.setText(null);
            }
        });
    }

    private void getMessages() {
        messages = new ArrayList<>();

        messages.add( new Message((long) 0, "Hi "));
        MessageAdapter adapter = new MessageAdapter(this, messages);

        list.setAdapter(adapter);

        list.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                list.setSelection(list.getCount() - 1);
            }
        });
    }
}
