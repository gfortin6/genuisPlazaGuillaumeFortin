package gfortin.life.geniusplazaguillaumefortin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import gfortin.life.geniusplazaguillaumefortin.R;

public class CreateUserActivity extends AppCompatActivity {

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
                    Toast.makeText(CreateUserActivity.this,"dashboard",Toast.LENGTH_SHORT);

                    ///mTextMessage.setText(R.string.title_dashboard);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
