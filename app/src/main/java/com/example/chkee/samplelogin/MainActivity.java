package com.example.chkee.samplelogin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.example.chkee.samplelogin.R.mipmap.ic_launcher;


public class MainActivity extends AppCompatActivity {
    public static final int IMAGE_RESOLUTION = 15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void buttonClicks(View v) {
        Log.d("Keerthi", "in the function");
        switch (v.getId()) {
            case R.id.fb_share_button:
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 3;
                Bitmap image = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().toString()
                        + File.separator + "DCIM" + File.separator + "Camera" + File.separator + "IMG_20151029_204606.jpg", options);
                // File sdcard = Environment.getExternalStorageDirectory();
                // Bitmap image = BitmapFactory.decodeFile(new File(Environment.getExternalStorageDirectory()+"/DCIM/Camera/IMG_20151029_204606.jpg").getAbsolutePath());
                //SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();
                //SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
                //ShareApi.share(content,null);
                //Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                SharePhoto photo = new SharePhoto.Builder().setBitmap(image).setCaption("Test").build();
                SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
                ShareApi.share(content, null);
               // Intent shareIntent = new Intent(Intent.ACTION_SEND);
                //shareIntent.setType("image/jpg");
                //Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().toString()
                  //      + File.separator + "DCIM" + File.separator + "Camera","IMG_20151029_204606.jpg"));
                //shareIntent.putExtra(Intent.EXTRA_STREAM, uri.toString());
                //startActivity(Intent.createChooser(shareIntent, "Share image using"));
                break;
        //  String message = "Text I want to share.";
        //Intent share = new Intent(Intent.ACTION_SEND);
        //share.setType("text/plain");
        //share.putExtra(Intent.EXTRA_TEXT, message);
        //startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
