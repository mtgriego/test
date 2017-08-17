package com.mtg.waglabstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.mtg.waglabstest.Adapters.UserAdapter;
import com.mtg.waglabstest.AsyncTasks.GetSOUsers;
import com.mtg.waglabstest.Interfaces.GetUserResponse;
import com.mtg.waglabstest.Objects.UserObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GetUserResponse{

    RecyclerView userListView;
    UserAdapter userAdapter;
    ArrayList<UserObject> userList;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar) findViewById(R.id.loading_progress);
        progress.setVisibility(View.VISIBLE);

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList, this);

        userListView = (RecyclerView) findViewById(R.id.user_list_view);
        userListView.setLayoutManager(new LinearLayoutManager(this));
        userListView.setItemAnimator(new DefaultItemAnimator());
        userListView.setAdapter(userAdapter);

        GetSOUsers getSOUsers = new GetSOUsers();
        getSOUsers.response = this;
        getSOUsers.execute();
    }

    @Override
    public void onGetUserReponse(ArrayList<UserObject> output) {
        if(output != null) {
            userList.addAll(output);
            userAdapter.notifyDataSetChanged();
        }
        progress.setVisibility(View.GONE);
    }
}
