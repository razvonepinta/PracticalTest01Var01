package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01.R.styleable.MenuItem;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {
    private TextView numberOfClicksTextView = null;
    private Button registerButton = null;
    private Button cancelButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.register:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);
        numberOfClicksTextView = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("count")) {
            int numberOfClicks = intent.getIntExtra("count", -1);
            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
        }

        registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }

}
