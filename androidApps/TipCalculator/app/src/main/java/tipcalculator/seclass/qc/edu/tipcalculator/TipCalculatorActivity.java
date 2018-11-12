package tipcalculator.seclass.qc.edu.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import java.lang.Double;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;


public class TipCalculatorActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        buttonClicked();
    }

    public void buttonClicked() {
        Button btn = (Button) findViewById(R.id.buttonCompute);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try{
                    double check;
                    int partySize;

                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                    if(imm.isAcceptingText()) {    //closes the keyboard after the compute is pressed
                        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }


                    TextView fifteenp = (TextView) findViewById(R.id.fifteenPercentTipValue);            //Percentage
                    TextView twentyp = (TextView) findViewById(R.id.twentyPercentTipValue);
                    TextView twentyFivep = (TextView) findViewById(R.id.twentyfivePercentTipValue);

                    TextView fifteenT = (TextView) findViewById(R.id.fifteenPercentTotalValue);            //Totals
                    TextView twentyT = (TextView) findViewById(R.id.twentyPercentTotalValue);
                    TextView twentyFiveT = (TextView) findViewById(R.id.twentyfivePercentTotalValue);

                    TextView checkk = (TextView) findViewById(R.id.checkAmountValue);
                    TextView numPeoplek = (TextView) findViewById(R.id.partySizeValue);


                    check = Double.valueOf(checkk.getText().toString());
                    partySize = Integer.valueOf(numPeoplek.getText().toString());

                    if(partySize<1){
                       Toast.makeText(getApplicationContext(),"Party size cannot be less then One or Blank!", Toast.LENGTH_LONG ).show();
                       check=0;
                   }

                    if(check<0){
                        Toast.makeText(getApplicationContext(),"Please enter a valid check amount!", Toast.LENGTH_LONG ).show();
                        check=0;
                    }
                    if(check<1){
                        Toast.makeText(getApplicationContext(),"Must spend more than a dollar!", Toast.LENGTH_LONG ).show();

                    }


                    fifteenp.setText("" + p15(check, partySize));
                    twentyp.setText("" + p20(check, partySize));
                    twentyFivep.setText("" + p25(check, partySize));

                    fifteenT.setText("" + t15(check, partySize));
                    twentyT.setText("" + t20(check, partySize));
                    twentyFiveT.setText("" + t25(check, partySize));

                }
                catch(Exception E){
                    Toast.makeText(getApplicationContext(),"Check amount or Party size cannot be less then One or Blank!", Toast.LENGTH_LONG ).show();

                }
            }
        });


    }

    public int p15(double check, int partySize) {
        int tips = (int) Math.round((check / partySize) * .15);
        return tips;
    }

    public int p20(double check, int partySize) {
        int tips = (int) Math.round((check / partySize) * .20);
        return tips;
    }

    public int p25(double check, int partySize) {
        int tips = (int) Math.round((check / partySize) * .25);
        return tips;
    }


    private int t15(double check, int partySize) {                                 // getting the total values
        double total = p15(check, partySize) + (check / partySize);
        return (int) total;
    }

    public int t20(double check, int partySize) {
        double total = p20(check, partySize) + (check / partySize);
        return (int) total;
    }

    public int t25(double check, int partySize) {
        double total = p25(check, partySize) + (check / partySize);
        return (int) total;
    }

}