package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private TextView text = null;
    private Button northButton = null;
    private Button southButton = null;
    private Button eastButton = null;
    private Button westButton = null;
    private Button navigateButton = null;

    int numberOfClicks = 0;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String concat = "";
            switch(view.getId()) {
                case R.id.north_button:
                    numberOfClicks++;
                    concat = text.getText().toString();
                    concat += "North,";
                    text.setText(String.valueOf(concat));
                    break;
                case R.id.south_button:
                    numberOfClicks++;
                    concat = text.getText().toString();
                    concat += "South,";
                    text.setText(String.valueOf(concat));
                    break;
                case R.id.west_button:
                    numberOfClicks++;
                    concat = text.getText().toString();
                    concat += "West,";
                    text.setText(String.valueOf(concat));
                    break;
                case R.id.east_button:
                    numberOfClicks++;
                    concat = text.getText().toString();
                    concat += "East,";
                    text.setText(String.valueOf(concat));
                    break;
                case R.id.navigate_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    intent.putExtra("count", numberOfClicks);
                    numberOfClicks = 0;
                    text.setText("");
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);


        text = (TextView)findViewById(R.id.textView);
        northButton = (Button)findViewById(R.id.north_button);
        southButton = (Button)findViewById(R.id.south_button);
        eastButton = (Button)findViewById(R.id.east_button);
        westButton = (Button)findViewById(R.id.west_button);
        navigateButton = (Button)findViewById(R.id.navigate_button);

        northButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        navigateButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("count")) {
                numberOfClicks = Integer.valueOf(savedInstanceState.getString("count"));
            }
        }
        Log.d("[Razvan App]", "Numarul de clock-uri este = " + numberOfClicks);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("count", String.valueOf(numberOfClicks));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("count")) {
            numberOfClicks = Integer.valueOf(savedInstanceState.getString("count"));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
