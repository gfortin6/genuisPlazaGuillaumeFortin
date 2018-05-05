package gfortin.life.geniusplazaguillaumefortin.asyncTask;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

import gfortin.life.geniusplazaguillaumefortin.handler.HttpHandler;

public class CreateUserTask extends AsyncTask<String, Void, String> {

    private Context context;

    public CreateUserTask(final Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        String result = "";
        HttpHandler httpHandler = new HttpHandler();


        HttpURLConnection httpURLConnection = null;
        try {
            result = httpHandler.executePost("https://reqres.in/api/users", params[0]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject jsonObj = new JSONObject(result);
            int id = jsonObj.getInt("id");
            String name = jsonObj.getString("name");
            Toast.makeText(context, "User " + name +" was successfully created" , Toast.LENGTH_SHORT).show();
            Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
        } catch (final JSONException e) {
            Toast.makeText(context, "Something went wrong. The user was not created" , Toast.LENGTH_SHORT).show();
            Log.e(CreateUserTask.class.getSimpleName(), "Json parsing error: " + e.getMessage());
        }
    }
}