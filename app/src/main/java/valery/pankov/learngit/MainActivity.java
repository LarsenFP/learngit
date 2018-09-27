package valery.pankov.learngit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_preview;
    private EditText et_preview;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_preview = findViewById(R.id.et_preview);
        btn_preview = findViewById(R.id.btn_preview);

        btn_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = (et_preview.getText()).toString();
                if (msg.length() != 0) {
                    //PreviewActivity.start(MainActivity.this, msg);
                } else {
                    warningToast();
                }
            }
        });
    }

    public void warningToast() {
        Toast.makeText(MainActivity.this, R.string.warning_msg, Toast.LENGTH_LONG).show();
    }
}
