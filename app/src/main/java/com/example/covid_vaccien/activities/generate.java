package com.example.covid_vaccien.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_vaccien.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class generate extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate_qr);
        imageView=findViewById(R.id.imageView3);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();



        String  stext=bundle.getString("builder").toString().trim();
        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        try {
            BitMatrix matrix = multiFormatWriter.encode(stext, BarcodeFormat.QR_CODE, 350, 350);
            BarcodeEncoder encoder=new BarcodeEncoder();
            Bitmap bitmap=encoder.createBitmap(matrix);
            imageView.setImageBitmap(bitmap);
            InputMethodManager manager =(InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );
            manager.hideSoftInputFromWindow(imageView.getApplicationWindowToken(),0);
        }
        catch (WriterException e)
        {
                e.printStackTrace();
        }


    }



}
