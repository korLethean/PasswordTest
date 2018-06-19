package com.test.lethean.passwordtest;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text_output)
    TextView textPassword;
    @BindView(R.id.text_result)
    TextView textMessage;
    @BindView(R.id.button_delete)
    Button buttonDelete;
    @BindView(R.id.button_clear)
    Button buttonClear;
    @BindView(R.id.button_one)
    Button button1;
    @BindView(R.id.button_two)
    Button button2;
    @BindView(R.id.button_three)
    Button button3;
    @BindView(R.id.button_four)
    Button button4;
    @BindView(R.id.button_five)
    Button button5;
    @BindView(R.id.button_six)
    Button button6;
    @BindView(R.id.button_seven)
    Button button7;
    @BindView(R.id.button_eight)
    Button button8;
    @BindView(R.id.button_nine)
    Button button9;
    @BindView(R.id.button_zero)
    Button button0;
    @BindView(R.id.layout_panel)
    LinearLayout layoutPanel;
    Unbinder unbinder;

    int deviceWidth;
    int deviceHeight;

    String PASSWORD = "1234";
    ArrayList<String> num = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Display d = getWindowManager().getDefaultDisplay();
        Point p = new Point();
        d.getSize(p);

        deviceWidth = p.x;
        deviceHeight = p.y;

        for(int i = 0; i < 10 ; i++) {
            num.add(String.valueOf(i));
        }
//        buttonReset();

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button)view;

                textPassword.setText(textPassword.getText().toString() + button.getText().toString());
                screenReset();
            }
        };
        button1.setOnClickListener(buttonListener);
        button2.setOnClickListener(buttonListener);
        button3.setOnClickListener(buttonListener);
        button4.setOnClickListener(buttonListener);
        button5.setOnClickListener(buttonListener);
        button6.setOnClickListener(buttonListener);
        button7.setOnClickListener(buttonListener);
        button8.setOnClickListener(buttonListener);
        button9.setOnClickListener(buttonListener);
        button0.setOnClickListener(buttonListener);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textPassword.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

/*
    private void buttonReset() {
        int index = 1;
        button1.setText(num.get(index++));
        button2.setText(num.get(index++));
        button3.setText(num.get(index++));
        button4.setText(num.get(index++));
        button5.setText(num.get(index++));
        button6.setText(num.get(index++));
        button7.setText(num.get(index++));
        button8.setText(num.get(index++));
        button9.setText(num.get(index++));
        button0.setText(num.get(index++));
    }
*/

    private void screenReset() {
        if(textPassword.getText().length() == 4) {
/*
            int x, y;
            Random rand = new Random();
            textPassword.setText("");

            x = rand.nextInt(deviceWidth) - 180;
            y = rand.nextInt(deviceHeight) - 240;

            if(x < 0)
                x = 0;
            if(y < 0)
                y = 0;

            layoutPanel.setPadding(x, y, 0, 0);
*/
            if(textPassword.getText().equals(PASSWORD)) {
                textMessage.setText("correct password");
            }
            else {
                textMessage.setText("wrong password");
            }
        }
    }
}
