package com.example.calculaterapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Parcelable {

    private static String TAG = "MainActivity";

    private double valueOne = Double.NaN;
    private double valueTwo = Double.NaN;
    private double result = Double.NaN;

    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION = ' ';

    private ArrayList<String> histories;



    private Button btnDot, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnMultiplication, btnSubtraction, btnAddition, btnDivision,
            btnDel, btnClear, btnCalculate, btnHistory;

    private TextView infoTextView, editTextView, operationTextView;

    private boolean canPlaceNewOperator;
    private boolean isValidNumber = false;


    protected MainActivity(Parcel in) {
        valueOne = in.readDouble();
        valueTwo = in.readDouble();
        result = in.readDouble();
        CURRENT_ACTION = (char) in.readInt();
        histories = in.createStringArrayList();
        canPlaceNewOperator = in.readByte() != 0;
        isValidNumber = in.readByte() != 0;
    }

    public MainActivity() {
    }

    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel in) {
            return new MainActivity(in);
        }

        @Override
        public MainActivity[] newArray(int size) {
            return new MainActivity[size];
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");

        init();
    }

    private void init()
    {
        Log.d(TAG, "init()");

        histories = new ArrayList<>();

        canPlaceNewOperator = true;

        infoTextView = findViewById(R.id.textView);
        editTextView = findViewById(R.id.textView2);
        operationTextView = findViewById(R.id.textView3);

        btnDot = findViewById(R.id.btnDot);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnSubtraction = findViewById(R.id.btnSubstraction);
        btnAddition = findViewById(R.id.btnAddition);
        btnDivision = findViewById(R.id.btnDivision);
        btnDel = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        btnHistory = findViewById(R.id.btnHistory);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnDot.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnSubtraction.setOnClickListener(this);
        btnAddition.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
    }

    private void computeCalculation()
    {
        //  if valueOne is a number
        if (!Double.isNaN(result))
        {
            if (Double.isNaN(valueOne))
            {
                valueOne = result;
            }

            valueTwo = Double.parseDouble(editTextView.getText().toString());

            //  check for action
            switch (CURRENT_ACTION)
            {
                case ADDITION:
                    result = valueOne + valueTwo;
                    break;

                case SUBSTRACTION:
                    result = valueOne - valueTwo;
                    break;

                case MULTIPLICATION:
                    result = valueOne * valueTwo;
                    break;

                case DIVISION:
                    result = valueOne / valueTwo;
                    break;

                default:
                    result = Double.parseDouble(editTextView.getText().toString());
                    break;

            }
        }
        else
        {
            //  result has not been assigned
            try
            {
              result = Double.parseDouble(editTextView.getText().toString());
            }
            catch (Exception e){ e.printStackTrace();}
        }
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnDot:
                if (editTextView.getText().length() > 0 &&
                        !editTextView.getText().toString().contains("."))
                {
                    editTextView.setText(editTextView.getText() + ".");
                }
                break;


            case R.id.btn0:
                editTextView.setText(editTextView.getText() + "0");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn1:
                editTextView.setText(editTextView.getText() + "1");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn2:
                editTextView.setText(editTextView.getText() + "2");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn3:
                editTextView.setText(editTextView.getText() + "3");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn4:
                editTextView.setText(editTextView.getText() + "4");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn5:
                editTextView.setText(editTextView.getText() + "5");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn6:
                editTextView.setText(editTextView.getText() + "6");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn7:
                editTextView.setText(editTextView.getText() + "7");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn8:
                editTextView.setText(editTextView.getText() + "8");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;

            case R.id.btn9:
                editTextView.setText(editTextView.getText() + "9");
                computeCalculation();
                infoTextView.setText(String.valueOf(result));
                break;


            case R.id.btnMultiplication:
                CURRENT_ACTION = MULTIPLICATION;
                operationTextView.setText(String.valueOf(CURRENT_ACTION));
                if (editTextView.getText().length() > 0 &&
                        !Double.isNaN(Double.parseDouble(editTextView.getText().toString())))
                {
                    computeCalculation();
                    infoTextView.setText(String.valueOf(result));
                }
                break;


            case R.id.btnAddition:
                CURRENT_ACTION = ADDITION;
                operationTextView.setText(String.valueOf(CURRENT_ACTION));
                if (editTextView.getText().length() > 0 &&
                        !Double.isNaN(Double.parseDouble(editTextView.getText().toString())))
                {
                    computeCalculation();
                    infoTextView.setText(String.valueOf(result));
                }
                break;

            case R.id.btnSubstraction:
                CURRENT_ACTION = SUBSTRACTION;
                operationTextView.setText(String.valueOf(CURRENT_ACTION));
                if (editTextView.getText().length() > 0 &&
                        !Double.isNaN(Double.parseDouble(editTextView.getText().toString())))
                {
                    computeCalculation();
                    infoTextView.setText(String.valueOf(result));
                }
                break;

            case R.id.btnDivision:
                CURRENT_ACTION = DIVISION;
                operationTextView.setText(String.valueOf(CURRENT_ACTION));
                if (editTextView.getText().length() > 0 &&
                        !Double.isNaN(Double.parseDouble(editTextView.getText().toString())))
                {
                    computeCalculation();
                    infoTextView.setText(String.valueOf(result));
                }
                break;

            case R.id.btnDelete:
                if (editTextView.getText().length() > 0)
                {
                   editTextView.setText(editTextView.getText().subSequence(0, editTextView.getText().length()-1));

                   if (editTextView.getText().length() == 0)
                   {
                       infoTextView.setText(String.valueOf(valueOne));
                   }
                   else
                   {
                       computeCalculation();
                       infoTextView.setText(String.valueOf(result));
                   }
                }
                break;


            case R.id.btnClear:
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                result = Double.NaN;

                infoTextView.setText(null);
                editTextView.setText(null);
                operationTextView.setText(null);
                CURRENT_ACTION = ' ';
                break;


            case R.id.btnHistory:
                Intent intent = new Intent(this, ResultPageWulff.class);

                intent.putStringArrayListExtra("HISTORIES", histories);
                intent.putExtra("valueOne", valueOne);
                intent.putExtra("valueTwo", valueTwo);
                intent.putExtra("result", result);
                intent.putExtra("CURRENT_ACTION", CURRENT_ACTION);
                startActivity(intent);

                break;


            case R.id.btnCalculate:
                if (editTextView.getText().length() > 0 &&
                        !Double.isNaN(Double.parseDouble(editTextView.getText().toString())))
                {
                    try
                    {
                        histories.add("   " + valueOne + "\n" + CURRENT_ACTION + " " + valueTwo + "\n= " + result);
                    }
                    catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                    valueOne = result;
                    editTextView.setText(null);
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSavedInstance()");

        outState.putString("OPERATION_TEXT_VIEW_TEXT", operationTextView.getText().toString());
        outState.putString("INFO_TEXT_VIEW_TEXT", infoTextView.getText().toString());
        outState.putString("EDIT_TEXT_VIEW_TEXT", editTextView.getText().toString());
        outState.putStringArrayList("HISTORIES", histories);
        outState.putDouble("VALUE_ONE", valueOne);
        outState.putDouble("VALUE_TWO", valueTwo);
        outState.putDouble("RESULT", result);
        outState.putChar("CURRENT_ACTION", CURRENT_ACTION);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");

        operationTextView.setText(savedInstanceState.getString("OPERATION_TEXT_VIEW_TEXT"));
        infoTextView.setText(savedInstanceState.getString("INFO_TEXT_VIEW_TEXT"));
        editTextView.setText(savedInstanceState.getString("EDIT_TEXT_VIEW_TEXT"));
        histories = savedInstanceState.getStringArrayList("HISTORIES");
        valueOne = savedInstanceState.getDouble("VALUE_ONE");
        valueTwo = savedInstanceState.getDouble("VALUE_TWO");
        result = savedInstanceState.getDouble("RESULT");
        CURRENT_ACTION = savedInstanceState.getChar("CURRENT_ACTION");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(valueOne);
        dest.writeDouble(valueTwo);
        dest.writeDouble(result);
        dest.writeInt((int) CURRENT_ACTION);
        dest.writeStringList(histories);
        dest.writeByte((byte) (canPlaceNewOperator ? 1 : 0));
        dest.writeByte((byte) (isValidNumber ? 1 : 0));
    }
}
