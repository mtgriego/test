package com.mtg.waglabstest.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.mtg.waglabstest.Interfaces.GetUserResponse;
import com.mtg.waglabstest.Objects.UserObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Matt on 8/17/2017.
 */

public class GetSOUsers extends AsyncTask<Void, Void,Void> {

    public GetUserResponse response;
    ArrayList<UserObject> users;

    @Override
    protected Void doInBackground(Void... voids) {
        HttpURLConnection conn = null;
        users = new ArrayList<>();

        try {
            URL urls = new URL("https://api.stackexchange.com/2.2/users?page=1&order=desc&sort=reputation&site=stackoverflow");

            conn = (HttpURLConnection) urls.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            try {

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sBuilder = new StringBuilder();

                    String line = null;
                    while ((line = bReader.readLine()) != null) {
                        sBuilder.append(line + "\n");
                    }

                    String response = sBuilder.toString();

                    if(response != null && response.length() > 0) {
                        Gson gson = new Gson();
                        JSONObject json = new JSONObject(response);
                        JSONArray jsonArray = json.getJSONArray("items");
                        for(int i = 0; i < jsonArray.length(); i++) {
                            JSONObject userJson = jsonArray.getJSONObject(i);
                            UserObject user = gson.fromJson(userJson.toString(), UserObject.class);
                            users.add(user);
                        }

                    }
                }

            } catch (Exception e) {
                Log.e("Actv8AsyncTask", Log.getStackTraceString(e));
            }
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        response.onGetUserReponse(users);
    }
}
