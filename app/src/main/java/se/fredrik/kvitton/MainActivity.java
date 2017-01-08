package se.fredrik.kvitton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        String[] strings = {"foo", "bar", "baz", "foo", "bar", "baz", "foo", "bar", "baz",
                "foo", "bar", "baz", "foo", "bar", "baz"};
        list.setAdapter(new ListAdapter(this, strings));

    }

    public void goToCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        } else {
            Toast msg = Toast.makeText(this, "Kunde inte starta kameran =(", Toast.LENGTH_SHORT);
            msg.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            try {
                String parsedText = OcrUtils.getText(imageBitmap);
                Log.d("parsedText", parsedText);
                startActivity(new Intent(this, CameraActivity.class));

            } catch(Exception e) {
                Log.e("getText", e.getMessage());
                Toast msg = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
                msg.show();
            }
        }
    }

}
