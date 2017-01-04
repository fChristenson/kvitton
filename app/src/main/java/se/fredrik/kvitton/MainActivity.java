package se.fredrik.kvitton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        String[] strings = {"foo", "bar", "baz", "foo", "bar", "baz", "foo", "bar", "baz", "foo", "bar", "baz", "foo", "bar", "baz"};
        list.setAdapter(new ListAdapter(this, strings));
    }
}
