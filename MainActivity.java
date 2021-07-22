package com.example.clipboard_activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText copyText, pasteText;
    Button btncopy, btnpaste;

    private ClipboardManager cbm;
    private ClipData cd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copyText = findViewById(R.id.copy);
        pasteText = findViewById(R.id.paste);

        btncopy = findViewById(R.id.buttoncopy);
        btnpaste = findViewById(R.id.buttonpaste);

        cbm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = copyText.getText().toString();
                cd = ClipData.newPlainText("text",text);
                cbm.setPrimaryClip(cd);
            }
        });

        btnpaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData cd2 = cbm.getPrimaryClip();
                ClipData.Item item = cd2.getItemAt(0);
                String copied = item.getText().toString();
                pasteText.setText(copied);

            }
        });
    }
}

