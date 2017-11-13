package br.com.ufrn.eaj.tads.notificationexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        String msg = getIntent().getStringExtra("msg");

        TextView text = (TextView) findViewById(R.id.text);
        text.setText(msg);
    }
}
