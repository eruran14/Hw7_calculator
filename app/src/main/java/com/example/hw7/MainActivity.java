package com.example.hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                addNumber("1");
                break;
            case R.id.btn_two:
                addNumber("2");
                break;
            case R.id.btn_three:
                addNumber("3");
                break;
            case R.id.btn_four:
                addNumber("4");
                break;
            case R.id.btn_five:
                addNumber("5");
                break;
            case R.id.btn_six:
                addNumber("6");
                break;
            case R.id.btn_seven:
                addNumber("7");
                break;
            case R.id.btn_eight:
                addNumber("8");
                break;
            case R.id.btn_nine:
                addNumber("9");
                break;
            case R.id.btn_zero:
                addNumber("0");
                break;
            case R.id.btn_clear:
                textView.setText("0");
                first = 0;
                second = 0;
                break;
        }
    }

    public void onOperationClick(View view) {
        first = Integer.parseInt(textView.getText().toString());
        switch (view.getId()){
            case R.id.btn_plus:
                operation = "+";
                break;
            case R.id.btn_minus:
                operation = "-";
                break;
            case R.id.btn_multiply:
                operation = "x";
                break;
            case R.id.btn_divide:
                operation = "/";
                break;
        }
        isOperationClick = true;
        }

    public void onResultClick(View view) {
        Integer result;
        second = Integer.parseInt(textView.getText().toString());
        switch (operation){
            case "+": result = first + second;
                    textView.setText(result.toString());
                    break;
            case "-": result = first - second;
                    textView.setText(result.toString());
                    break;
            case "x": result = first * second;
                    textView.setText(result.toString());
                    break;
            case "/": result = first / second;
                    textView.setText(result.toString());
                    break;
        }
        isOperationClick = true;
    }



    public void addNumber(String number){
        if (textView.getText().toString().equals("0")){
            textView.setText(number);
        }
        else if (isOperationClick){
            textView.setText(number);
        }
        else {
            textView.append(number);
        }
        exceedLength();
        isOperationClick = false;
    }

    private void exceedLength() {
        if (textView.getText().toString().length() > 10) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
}

    public void onPlusMinusClick(View view) {
        if (Integer.parseInt(textView.getText().toString()) > 0 && !isOperationClick && textView.getText().length() != 0){
            textView.setText(Integer.parseInt(textView.getText().toString()) * -1);
        }
    }
}