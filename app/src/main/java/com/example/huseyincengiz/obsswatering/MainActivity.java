package com.example.huseyincengiz.obsswatering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.huseyincengiz.obsswatering.Models.DataBank;
import com.example.huseyincengiz.obsswatering.Models.Sebze;
import com.example.huseyincengiz.obsswatering.Utils.RecyclerViewCustomAdapter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewCustomAdapter.setOnWateringClickListener {

    private static final String TAG = "MainActivity";

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.1.44:8080");
        } catch (URISyntaxException e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSocket.connect();
        Init();
    }

    private void Init(){
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewCustomAdapter customAdapter=new RecyclerViewCustomAdapter(this, DataBank.getData());
        recyclerView.setAdapter(customAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void setOnWateringClick(Sebze sebze) {
        Log.d(TAG, "setOnWateringClick: emitting the forward event");
        if(sebze!=null){
            mSocket.emit("order",sebze);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
    }
}
