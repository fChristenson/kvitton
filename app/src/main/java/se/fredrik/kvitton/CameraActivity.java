package se.fredrik.kvitton;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // set font for headers
        Typeface boldFace = Typeface.createFromAsset(getAssets(), Constants.PRIMARY_FONT_BOLD);

        TextView store = (TextView) findViewById(R.id.store);
        TextView date = (TextView) findViewById(R.id.date);
        TextView price = (TextView) findViewById(R.id.price);
        TextView code = (TextView) findViewById(R.id.code);
        Button save = (Button) findViewById(R.id.save);

        store.setTypeface(boldFace);
        date.setTypeface(boldFace);
        price.setTypeface(boldFace);
        code.setTypeface(boldFace);
        save.setTypeface(boldFace);

        // set font for text fields
        Typeface face = Typeface.createFromAsset(getAssets(), Constants.PRIMARY_FONT);

        TextView store_field = (TextView) findViewById(R.id.store_field);
        TextView date_field = (TextView) findViewById(R.id.date_field);
        TextView price_field = (TextView) findViewById(R.id.price_field);
        TextView code_field = (TextView) findViewById(R.id.code_field);

        store_field.setTypeface(face);
        date_field.setTypeface(face);
        price_field.setTypeface(face);
        code_field.setTypeface(face);

    }

    public void goToList(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void save(View view) {
        Toast msg = Toast.makeText(this, "Kvitto sparades!", Toast.LENGTH_SHORT);
        msg.show();
        goToList(view);
    }
}
