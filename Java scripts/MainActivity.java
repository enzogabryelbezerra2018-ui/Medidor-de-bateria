package com.exemplo.bateria;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewBateria;
    private ProgressBar progressBarBateria;
    private int ultimaFaixa = -1; // Guarda a faixa anterior

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewBateria = findViewById(R.id.textViewBateria);
        progressBarBateria = findViewById(R.id.progressBarBateria);

        BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                int batteryPct = level * 100 / scale;

                textViewBateria.setText("Bateria: " + batteryPct + "%");

                // Animação suave da barra
                ObjectAnimator.ofInt(progressBarBateria, "progress", progressBarBateria.getProgress(), batteryPct)
                        .setDuration(500)
                        .start();

                // Determina a faixa da bateria
                int faixa;
                if (batteryPct <= 10) {
                    faixa = 0;
                } else if (batteryPct <= 50) {
                    faixa = 1;
                } else {
                    faixa = 2;
                }

                // Toca som apenas se a faixa mudou
                if (faixa != ultimaFaixa) {
                    ultimaFaixa = faixa;
                    MediaPlayer mediaPlayer;
                    switch (faixa) {
                        case 0:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.baixo);
                            break;
                        case 1:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.medio);
                            break;
                        default:
                            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cheio);
                            break;
                    }
                    mediaPlayer.start();
                }

                // Muda a cor da barra
                int cor;
                switch (faixa) {
                    case 0:
                        cor = Color.RED;
                        break;
                    case 1:
                        cor = Color.parseColor("#FFA500"); // laranja
                        break;
                    default:
                        cor = Color.GREEN;
                        break;
                }
                progressBarBateria.getProgressDrawable().setTint(cor);
            }
        };

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
