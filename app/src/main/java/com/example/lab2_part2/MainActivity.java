package com.example.lab2_part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.GridLayout.CENTER;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    EditText editText ;

    String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
            "Armenia", "Aruba", "Austrailia", "Austria", "Azerbaijan"
    };

    ArrayList <String> countryToShow = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 0; i<COUNTRIES.length; i++){
            countryToShow.add(COUNTRIES[i]);
        }

        LinearLayout screenLayout = new LinearLayout(this);
        screenLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams screenParams = new LinearLayout.LayoutParams(FILL_PARENT, FILL_PARENT);
        screenLayout.setLayoutParams(screenParams);

        LinearLayout btnLayout = new LinearLayout(this);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        btnParams.gravity = Gravity.CENTER;
        btnLayout.setOrientation(LinearLayout.HORIZONTAL);
        btnLayout.setLayoutParams(btnParams);

        ViewGroup.LayoutParams forBtnParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        Button addBtn = new Button(this);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBtnClicked();
            }
        });

        addBtn.setLayoutParams(forBtnParams);

        Button editBtn = new Button(this);
        editBtn.setLayoutParams(forBtnParams);

        Button removeBtn = new Button(this);
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBtnClicked();
            }
        });

        removeBtn.setLayoutParams(forBtnParams);


        addBtn.setText("Add");
        editBtn.setText("Edit");
        removeBtn.setText("Remove");

        btnLayout.addView(addBtn);
        btnLayout.addView(editBtn);
        btnLayout.addView(removeBtn);

        screenLayout.addView(btnLayout);

        editText = new EditText(this);
        ViewGroup.LayoutParams editParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        editText.setLayoutParams(editParams);

        screenLayout.addView(editText);

        ViewGroup.LayoutParams listParams = new LinearLayout.LayoutParams(FILL_PARENT, WRAP_CONTENT);
        listView = new ListView(this);
        listView.setLayoutParams(listParams);

        final ArrayAdapter<String> aa;

        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryToShow);

        listView.setAdapter(aa);

        screenLayout.addView(listView);
        setContentView(screenLayout);

    }

    public void addBtnClicked(){
        if(editText.getText()!=null){
            String addable = editText.getText().toString();
            countryToShow.add(addable);
            callArrayAdapter();
        }
    }

    public void removeBtnClicked(){
        boolean isThere = false;
        if(editText.getText() != null){
            String removable = editText.getText().toString();
            for(int j = 0; j<countryToShow.size(); j++ ){
                String checkTest = countryToShow.get(j);
                Log.d("Test", checkTest + " " + j);
                Log.d("removabble", removable.toUpperCase());
                Log.d("arraylist",countryToShow.get(j).toUpperCase());
                if(countryToShow.get(j).toUpperCase().equals(removable.toUpperCase())){
                    int index = countryToShow.indexOf(countryToShow.get(j));
                    countryToShow.remove(index);
                    isThere = true;
                }
                else{
                    continue;
                }
            }
            if(!isThere){
                editText.setText(removable + " is not exist in the list");
            }
            else{
                editText.setText(removable + " has Successfully deleted!");
            }
        }
        callArrayAdapter();
    }

    public void callArrayAdapter(){
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryToShow);
        listView.setAdapter(aa);

    }
}
