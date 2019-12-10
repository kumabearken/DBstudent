package com.example.sqliteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import static com.example.sqliteapp.DatabaseHelper.TABLE_NAME;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    ListView listView;
    static DatabaseHelper myDb;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        myDb.retrieve();
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.student);
        listView.setAdapter(new EfficientAdapter(this));
    }
    public void addStudent(View view) {
        startActivity(new Intent(MainActivity.this, AddStud.class));
    }

    private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return Students.firstName.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.two_col_row, null);
                convertView.setClickable(true);
                holder = new ViewHolder();
                holder.text1 = (TextView) convertView
                        .findViewById(R.id.TextView01);
                holder.text2 = (TextView) convertView
                        .findViewById(R.id.TextView02);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text1.setText(Students.firstName.get(position));
            holder.text2.setText(Students.lastName.get(position));

            return convertView;
        }

        static class ViewHolder {
            TextView text1;
            TextView text2;
        }
    }
}