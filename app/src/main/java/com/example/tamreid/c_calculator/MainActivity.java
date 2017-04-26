package com.example.tamreid.c_calculator;

import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.Button;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

import static com.example.tamreid.c_calculator.R.id.result1;

public class MainActivity extends AppCompatActivity {

    //Declare
/*    TextView result;
    EditText number1, number2;
    android.widget.Button num7;
    android.widget.Button num8;
    android.widget.Button num9;
    android.widget.Button add;
    android.widget.Button subtract;
    android.widget.Button divide;
    android.widget.Button multiply;*/


    //    float result_num;
//    int num1, num2,temp2;
//    String temp2;
    private EditText Scr;//Textbox Screen
    private float NumberBf;//Save screen before pressing button operation
    private String Operation;
    public ButtonClickListener btnClick;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Scr = (EditText) findViewById(result1);
        Scr.setEnabled(false);
        btnClick = new ButtonClickListener();
      //  final Button Percent = (Button) findViewById(R.id.percent);
        //reference --- finds view by id and typecast
       /* result = (TextView) findViewById(R.id.result);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
*/

        int idList[] = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5, R.id.num6, R.id.num7,
                R.id.num8, R.id.num9, R.id.numzero, R.id.percent, R.id.plus, R.id.decimal, R.id.division,
                R.id.mm, R.id.equal, R.id.decimal, R.id.subtract1, R.id.clear, R.id.multiply1};

        for (int id : idList) {
            View v = findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }
/*

//Pressing 7
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 // sharedpreference.edit().putString("button_value",num7.getText().toString()).apply();
                temp2 = Integer.parseInt(num7.getText().toString());
                result.setText(String.valueOf(temp2));
                result_num  = temp2;
                result.setText(String.valueOf(result_num));
               // then on other activities declare SharedPreferences again then:
             //   String temp1 = sharedpreference.getString("button_value","");

                //getting result_num and changing it to a string then the velue to result
             //   result.setText(String.valueOf(result_num));

            }
*/

        //);

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/

    public void mMath(String str) {
        NumberBf = Float.parseFloat(Scr.getText().toString());  //save the screen
        Operation = str; //save the operation
        Scr.setText("");  //Clear screen
    }


    public void getKeyboard(String str) {
        String ScrCurrent = Scr.getText().toString();
        if (ScrCurrent != "") {
            ScrCurrent = "";
        }

        if (ScrCurrent.equals("0")) {
            ScrCurrent = "";
        }

        ScrCurrent += str;
        Scr.setText(ScrCurrent);
    }


/*
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
*/

    public void mResult() {
        float NumAf = Float.parseFloat(Scr.getText().toString());
        float result = 0;
        Scr.setText("");  //Clear screen
    //    double percent=Double.parseDouble(Scr.getText().toString());
    //    double obtained = 0;

        if (Operation.equals("+")) {
            result = NumAf+NumberBf;
      //      obtained = NumAf + NumberBf;
        }

        if (Operation.equals("-")) {
            result = NumAf-NumberBf;
      //      obtained = NumAf - NumberBf;
        }
        if (Operation.equals("*")) {
            result = NumAf*NumberBf;
      //      obtained = NumAf * NumberBf;
        }
        if (Operation.equals("/")) {
            result = NumAf/NumberBf;
       //     obtained = NumAf / NumberBf;
        }
/*
        if (Operation.equals("%")) {
          result= (float) (obtained *((1.0f - percent)));
          result= (float) (obtained*(100.0f -percent)/100.0f);

        }
*/


        Scr.setText(String.valueOf(result));

    }




//new class ButtonClickListener

    private class ButtonClickListener implements View.OnClickListener {

        public void onClick(View v) {
              switch (v.getId()) {
                case R.id.clear:  //clear Screen
                    Scr.setText("0");
                    NumberBf = 0;
                    Operation = "";
                    break;
                case R.id.plus:
                    mMath("+");
                    break;
                case R.id.subtract1:
                    mMath("-");
                    break;
                case R.id.multiply1:
                    mMath("*");
                    break;
                case R.id.division:
                    mMath("/");
                    break;
                case R.id.equal:
                    mResult();
                    break;
                case R.id.mm:
                    mMath("-/+");
                    break;
//                case R.id.percent:
  //                  mMath("%");
    //                  break;
                default:
                    String numb = ((Button)v).getText().toString();
                    getKeyboard(numb);
                    break;

              }

        }
    }


}

/*

//ADD FUNCTION
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from number 1 and changing it to a string then parsing it to a int and assigned to num1
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());


                //add
                result_num = num1 + num2;
                //getting result_num and changing it to a string then the velue to result
                result.setText(String.valueOf(result_num));


            }
        });




//Subtract FUNCTION
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from number 1 and changing it to a string then parsing it to a int and assigned to num1
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add
                result_num = num1 - num2;
                //getting result_num and changing it to a string then the velue to result
                result.setText(String.valueOf(result_num));


            }
        });


//Divide FUNCTION
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from number 1 and changing it to a string then parsing it to a int and assigned to num1
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add
                result_num = num1 / num2;
                //getting result_num and changing it to a string then the velue to result
                result.setText(String.valueOf(result_num));


            }
        });

//Multiply FUNCTION
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from number 1 and changing it to a string then parsing it to a int and assigned to num1
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());

                //add
              result_num = num1 * num2;
                //getting result_num and changing it to a string then the velue to result
               result.setText(String.valueOf(result_num));

            }
        });


    }
}
*/
