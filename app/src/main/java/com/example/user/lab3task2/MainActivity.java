package com.example.user.lab3task2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText value;
    Button callbutton;
    Button camerabutton;
    Button contactbutton;
    Button browserbutton;
    Button calllogbutton;
    Button gallerybutton;
    Button dialpadbutton;
    String number;
    String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value = findViewById(R.id.entervalue);
        callbutton = findViewById(R.id.callb);
        camerabutton = findViewById(R.id.contactb);
        contactbutton = findViewById(R.id.contactb);
        browserbutton = findViewById(R.id.browserb);
        calllogbutton = findViewById(R.id.calllogb);
        gallerybutton = findViewById(R.id.galleryb);
        dialpadbutton = findViewById(R.id.dialpadb);


        callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = value.getText().toString();
                Intent calli = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(calli);
        }
    });
    camerabutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent camerai = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(camerai);
        }
    });
contactbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent contacti= new Intent(Intent.ACTION_VIEW);
        contacti.setData(Uri.parse("content://contacts/people/"));
        startActivity(contacti);
        }
});
browserbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        website = value.getText().toString();
Intent browseri = new Intent (Intent.ACTION_VIEW,Uri.parse("http://"+website));
startActivity(browseri);
    }
});
calllogbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent calllogi= new Intent(Intent.ACTION_VIEW);
        calllogi.setData(Uri.parse("content://call_log/calls/1"));
        startActivity(calllogi);
    }
});
gallerybutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent galleryi = new Intent(Intent.ACTION_VIEW);
        galleryi.setData(Uri.parse("content://media/external/images/media/"));
        startActivity(galleryi);
        }
});
dialpadbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        number=value.getText().toString();
        Intent dialpadi = new Intent(Intent.ACTION_DIAL);
        dialpadi.setData(Uri.parse("tel:"+number));
        startActivity(dialpadi);

    }
});

    }
}
