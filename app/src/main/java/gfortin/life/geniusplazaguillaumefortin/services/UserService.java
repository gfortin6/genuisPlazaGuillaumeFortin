package gfortin.life.geniusplazaguillaumefortin.services;

import android.app.Activity;
import android.content.Context;
import android.util.JsonReader;
import android.util.JsonToken;
import android.widget.ListView;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gfortin.life.geniusplazaguillaumefortin.asyncTask.CreateUserTask;
import gfortin.life.geniusplazaguillaumefortin.asyncTask.GetUsersTask;
import gfortin.life.geniusplazaguillaumefortin.model.User;

public class UserService {

    public static void createUser(Context context, JSONObject jsonObject){
        new CreateUserTask(context).execute(jsonObject.toString());
    }

    public static void loadUsers(String url, Activity activity, ListView listView){
        new GetUsersTask(url, activity,listView).execute();
    }
}
