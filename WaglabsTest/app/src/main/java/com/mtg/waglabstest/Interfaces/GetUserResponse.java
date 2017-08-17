package com.mtg.waglabstest.Interfaces;

import com.mtg.waglabstest.Objects.UserObject;

import java.util.ArrayList;

/**
 * Created by Matt on 8/17/2017.
 */

public interface GetUserResponse {
    void onGetUserReponse(ArrayList<UserObject> output);
}
