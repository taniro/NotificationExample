package br.com.ufrn.eaj.tads.notificationexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
@Author Lechetta
 */

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver customActionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "CLICOU NA AÇÂO!", Toast.LENGTH_SHORT).show();
            NotificationUtil.cancell(context, 3);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(customActionReceiver, new IntentFilter(NotificationUtil.ACTION_VISUALIZAR));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(customActionReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickNotificacaoSimples(View view) {
        int id = 1;
        Intent intent = new Intent(this,MensagemActivity.class);
        intent.putExtra("msg","Olá Leitor, como vai?");
        String contentTitle = "Nova mensagem simples";
        String contentText = "Você possui uma nova mensagem";
        NotificationUtil.create(this,intent,contentTitle,contentText,id);
    }
    public void onClickNotificacaoHeadsUp(View view) {
        int id = 1;
        Intent intent = new Intent(this, MensagemActivity.class);
        intent.putExtra("msg", "Olá Leitor, como vai?");
        String contentTitle = "Nova mensagem simples";
        String contentText = "Você possui uma nova mensagem";
        NotificationUtil.createHeadsUpNotification(this, intent, contentTitle, contentText, id);
    }

    public void onClickNotificacaoBig(View view) {
        int id = 2;
        Intent intent = new Intent(this,MensagemActivity.class);
        intent.putExtra("msg","Olá Leitor, como vai?");
        List<String> list = new ArrayList<>();
        list.add("Mensagem 1");
        list.add("Mensagem 2");
        list.add("Mensagem 3");
        String contentTitle = "Nova mensagem big";
        String contentText = String.format("Você possui %s novas mensagens",list.size());
        NotificationUtil.createBig(this, intent, contentTitle, contentText, list, id);
    }

    public void onClickNotificacaoComAcao(View view) {
        int id = 3;
        Intent intent = new Intent(this,MensagemActivity.class);
        intent.putExtra("msg","Música legal.");
        String contentTitle = "Nome da música";
        String contentText = "Nome do artista";
        NotificationUtil.createWithAction(this, intent, contentTitle, contentText, id);
    }
}
