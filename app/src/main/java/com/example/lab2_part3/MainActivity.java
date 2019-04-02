package com.example.lab2_part3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout screenLayout = new LinearLayout(this);
        screenLayout.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams screenParams = new LinearLayout.LayoutParams(FILL_PARENT, FILL_PARENT);
        screenLayout.setLayoutParams(screenParams);

        editText = new EditText(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                editTextAfter();
            }
        });

        ViewGroup.LayoutParams editParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        editText.setLayoutParams(editParams);


        screenLayout.addView(editText);

        LinearLayout btnLayout1 = new LinearLayout(this);
        LinearLayout.LayoutParams btnParams1 = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        btnParams1.gravity = Gravity.CENTER;
        btnLayout1.setOrientation(LinearLayout.HORIZONTAL);
        btnLayout1.setLayoutParams(btnParams1);

        LinearLayout btnLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams btnParams2 = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        btnParams2.gravity = Gravity.CENTER;
        btnLayout2.setOrientation(LinearLayout.HORIZONTAL);
        btnLayout2.setLayoutParams(btnParams2);

        ViewGroup.LayoutParams forBtnParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        Button engBtn = new Button(this);
        engBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engBtn_clicked();
            }
        });

        engBtn.setLayoutParams(forBtnParams);

        Button sweBtn = new Button(this);
        sweBtn.setLayoutParams(forBtnParams);
        sweBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweBtn_clicked();
            }
        });



        Button finBtn = new Button(this);
        finBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finBtn_clicked();
            }
        });

        finBtn.setLayoutParams(forBtnParams);

        Button supBtn = new Button(this);
        supBtn.setLayoutParams(forBtnParams);
        supBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supBtn_clicked();
            }
        });


        engBtn.setText("ENGLISH");
        sweBtn.setText("SVERIGE");
        finBtn.setText("SUOMEKSI");
        supBtn.setText("SURPRISE");

        btnLayout1.addView(engBtn);
        btnLayout1.addView(sweBtn);
        btnLayout2.addView(finBtn);
        btnLayout2.addView(supBtn);

        screenLayout.addView(btnLayout1);
        screenLayout.addView(btnLayout2);

        ViewGroup.LayoutParams forTextParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        textView = new TextView(this);

        textView.setLayoutParams(forTextParams);

        textView.setTextSize(24);

        screenLayout.addView(textView);

        setContentView(screenLayout);

    }

    public void engBtn_clicked(){
        String name = editText.getText().toString();
        textView.setText( "Hi " + name);
    }

    public void sweBtn_clicked(){
        String name = editText.getText().toString();
        textView.setText( "Hejjsan " + name);
    }

    public void finBtn_clicked(){
        String name = editText.getText().toString();
        textView.setText( "Terve " + name);
    }

    public void supBtn_clicked(){
        String name = editText.getText().toString();
        textView.setText( "Hola " + name);
    }

    public void editTextAfter(){
        textView.setText(editText.getText().toString());
    }
}
