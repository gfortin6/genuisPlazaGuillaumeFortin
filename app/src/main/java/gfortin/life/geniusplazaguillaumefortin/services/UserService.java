package gfortin.life.geniusplazaguillaumefortin.services;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import org.json.JSONObject;

import gfortin.life.geniusplazaguillaumefortin.asyncTask.CreateUserTask;
import gfortin.life.geniusplazaguillaumefortin.asyncTask.GetUsersTask;

public class UserService {

    public static void createUser(Context context, JSONObject jsonObject){
        new CreateUserTask(context).execute(jsonObject.toString());
    }

    public static void loadUsers(String url, Activity activity, ListView listView){
        new GetUsersTask(url, activity,listView).execute();
    }
}
