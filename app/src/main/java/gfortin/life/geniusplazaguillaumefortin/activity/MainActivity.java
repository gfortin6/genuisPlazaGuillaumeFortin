package gfortin.life.geniusplazaguillaumefortin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import gfortin.life.geniusplazaguillaumefortin.R;
import gfortin.life.geniusplazaguillaumefortin.services.UserService;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.list);
        String url = "https://reqres.in/api/users";

        UserService.loadUsers(url,this,lv);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;

            switch (item.getItemId()) {
                case R.id.navigation_user_list:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    MainActivity.this.startActivity(intent);
                    return true;
                case R.id.navigation_create_user:
                    intent = new Intent(MainActivity.this, CreateUserActivity.class);
                    MainActivity.this.startActivity(intent);
                    return true;
            }
            return false;
        }
    };


}
