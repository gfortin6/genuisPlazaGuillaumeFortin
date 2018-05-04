package gfortin.life.geniusplazaguillaumefortin.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gfortin.life.geniusplazaguillaumefortin.R;
import gfortin.life.geniusplazaguillaumefortin.activity.MainActivity;
import gfortin.life.geniusplazaguillaumefortin.asyncTask.DownloadImageTask;
import gfortin.life.geniusplazaguillaumefortin.model.User;

public class UserAdapter  extends ArrayAdapter<User> {
        private Activity activity;
        private ArrayList<User> users;
        private static LayoutInflater inflater = null;

        public UserAdapter (Activity activity, int textViewResourceId,ArrayList<User> users) {
            super(activity, textViewResourceId, users);
            try {
                this.activity = activity;
                this.users = users;

                inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            } catch (Exception e) {

            }
        }

        public int getCount() {
            return users.size();
        }

        public User getItem(User position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public static class ViewHolder {
            public TextView firstName;
            public TextView lastName;
            public ImageView avatar;

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            final ViewHolder holder;
            try {
                if (convertView == null) {
                    vi = inflater.inflate(R.layout.list_item, null);
                    holder = new ViewHolder();

                    holder.firstName = (TextView) vi.findViewById(R.id.first_name);
                    holder.lastName = (TextView) vi.findViewById(R.id.last_name);
                    holder.avatar = (ImageView) vi.findViewById(R.id.avatar);

                    vi.setTag(holder);
                } else {
                    holder = (ViewHolder) vi.getTag();
                }

                holder.firstName.setText(users.get(position).getFirstName());
                holder.lastName.setText(users.get(position).getLastName());

                new DownloadImageTask(holder.avatar).execute(users.get(position).getAvatar());

            } catch (Exception e) {
                Log.e(MainActivity.class.getSimpleName(), "Error: " + e.getMessage());
            }
            return vi;
        }
}
