package valery.pankov.learngit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewActivity extends AppCompatActivity
{
    public static final String KEY_MSG = "KEY_MSG";
    private Button btn_send;
    private TextView tv_preview;
    private String msg;

    public static void start(@NonNull Activity activity, @NonNull String msg) {
        final Intent intent = new Intent(activity, PreviewActivity.class);
        intent.putExtra(KEY_MSG, msg);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = getIntent().getStringExtra("KEY_MSG");
        //tv_preview = findViewById(R.id.tv_preview);
        //btn_send = findViewById(R.id.btn_send);
        tv_preview.setText(msg);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share();
            }
        });
    }

    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
        sendIntent.setType("text/plain");
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        } else {
            warningToast();
            // do something else
        }

    }

    public void warningToast(){
        Toast.makeText(PreviewActivity.this, R.string.warning_msg, Toast.LENGTH_LONG).show();
    }


}
