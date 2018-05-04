package gfortin.life.geniusplazaguillaumefortin.asyncTask;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import gfortin.life.geniusplazaguillaumefortin.activity.MainActivity;
import gfortin.life.geniusplazaguillaumefortin.adapter.UserAdapter;
import gfortin.life.geniusplazaguillaumefortin.handler.HttpHandler;
import gfortin.life.geniusplazaguillaumefortin.model.User;

/**
 * Async task class to get json by making HTTP call
 */
public class GetUsersTask extends AsyncTask<Void, Void, ListView> {

    private String url;
    private String TAG;
    private ArrayList<User> userList;
    private Activity activity;
    private ListView lv;

    public GetUsersTask(String url, String TAG, Activity activity, ListView lv) {
        this.url = url;
        this.TAG = TAG;
     //   this.userList = userList;
        this.activity = activity;
        this.lv = lv;

        this.userList = new ArrayList<>();
    }

    @Override
    protected ListView doInBackground(Void... arg0) {
        HttpHandler sh = new HttpHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url);

        Log.e(TAG, "Response from url: " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                JSONArray users = jsonObj.getJSONArray("data");

                // looping through All Contacts
                for (int i = 0; i < users.length(); i++) {
                    JSONObject c = users.getJSONObject(i);
                    int id = c.getInt("id");
                    String firstName = c.getString("first_name");
                    String lastName = c.getString("last_name");
                    String avatarStringUrl = c.getString("avatar");
                    User user = new User(id,firstName,lastName,avatarStringUrl);
                    userList.add(user);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }

        return null;
    }

        @Override
        protected void onPostExecute(ListView result) {
            super.onPostExecute(result);
            UserAdapter userAdapter = new UserAdapter(activity, 0, userList);
            lv.setAdapter(userAdapter);
        }

}
