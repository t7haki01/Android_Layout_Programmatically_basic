package lab.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int clickedNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button gameButton = new Button(this);

        gameButton.setText("Hello, i'm the button");

        setContentView(gameButton);

        gameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btn_clicked();
            }
        });


    }

    public void setClickedNumber(int clickedNumber) {
        this.clickedNumber = clickedNumber;
    }

    public int getClickedNumber() {
        return clickedNumber;
    }

    public void btn_clicked(){
        int increasedNumber = getClickedNumber()+1 ;
        setClickedNumber(increasedNumber);

        Button pressedBtn = new Button(this);
        pressedBtn.setText("YOU HAVE PRESSED THE BUTTON " + increasedNumber + " TIMES");
        pressedBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                btn_clicked();
            }
        });
        setContentView(pressedBtn);
    }
}
