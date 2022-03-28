package hcmute.edu.vn.calculator_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingTV;
    TextView resultTV;
    String workingText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCalculator();
    }
    public  void initCalculator(){
        workingTV = (TextView) findViewById(R.id.workingTV);
        resultTV = (TextView) findViewById(R.id.resultTV);
    }
    public void setWorking(String value){
        workingText = workingText + value;
        workingTV.setText(workingText);
    }

    public void equalOnclick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(workingText);
        } catch (ScriptException e) {
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
        if (result != null){
            resultTV.setText(String.valueOf(result.doubleValue()));
        }
        else {
            resultTV.setText("");
        }

    }
    public void sevenOnclick(View view) {
        setWorking("7");
    }
    public void eightOnclick(View view) {
        setWorking("8");
    }
    public void nineOnclick(View view) {
        setWorking("9");
    }
    public void verOnclick(View view) {
        setWorking("/");
    }
    public void fourOnclick(View view) {
        setWorking("4");
    }
    public void fiveOnclick(View view) {
        setWorking("5");
    }
    public void sixOnclick(View view) {
        setWorking("6");
    }
    public void mulOnclick(View view) {
        setWorking("*");
    }
    public void oneOnclick(View view) {
        setWorking("1");
    }
    public void twoOnclick(View view) {
        setWorking("2");
    }
    public void threeOnclick(View view) {
        setWorking("3");
    }
    public void minusOnclick(View view) {
        setWorking("-");
    }
    public void zeroOnclick(View view) {
        setWorking("0");
    }
    public void dotOnclick(View view) {
        setWorking(".");
    }
    public void plusOnclick(View view) {
        setWorking("+");
    }
    public void clearOnclick(View view) {
        workingTV.setText("");
        workingText = "";
    }

}