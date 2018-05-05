package gfortin.life.geniusplazaguillaumefortin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import gfortin.life.geniusplazaguillaumefortin.R;
import gfortin.life.geniusplazaguillaumefortin.asyncTask.CreateUserTask;
import gfortin.life.geniusplazaguillaumefortin.handler.HttpHandler;
import gfortin.life.geniusplazaguillaumefortin.services.UserService;

public class CreateUserActivity extends AppCompatActivity {

    private EditText nameInput, jobInput;
    private Button submitBtn;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent = null;

            switch (item.getItemId()) {
                case R.id.navigation_user_list:
                    intent = new Intent(CreateUserActivity.this, MainActivity.class);
                    CreateUserActivity.this.startActivity(intent);
                    return true;
                case R.id.navigation_create_user:
                    intent = new Intent(CreateUserActivity.this, CreateUserActivity.class);
                    CreateUserActivity.this.startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        nameInput = findViewById(R.id.name_input);
        jobInput = findViewById(R.id.job_input);
        submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject obj = new JSONObject();
                try {
                    obj.put("name", nameInput.getText());
                    obj.put("job", jobInput.getText());

                    UserService.createUser(getApplicationContext(),obj);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });


        // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
