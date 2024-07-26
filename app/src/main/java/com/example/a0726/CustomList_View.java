package com.example.a0726;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CustomList_View extends AppCompatActivity {
    ListView list;
    String[] titles = {"Title 1", "Title 2", "Title 3", "Title 4", "Title 5"};
    Integer[] images ={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlist_view);
        CustomList adapter = new CustomList(CustomList_View.this);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),titles[+position],Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        public CustomList(Activity context){
            super(context,R.layout.listview2,titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listview2,null,true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView ratingText = (TextView) rowView.findViewById(R.id.rating);
            TextView titleText = (TextView) rowView.findViewById(R.id.title);
            TextView genreText = (TextView) rowView.findViewById(R.id.genre);
            TextView releaseYearText = (TextView) rowView.findViewById(R.id.releaseYear);

            titleText.setText(titles[position]);
            imageView.setImageResource(images[position]);
            ratingText.setText("9.0"+position);
            genreText.setText("DRAMA");
            releaseYearText.setText(1930+position+"");
            return rowView;

        }
    }
}
