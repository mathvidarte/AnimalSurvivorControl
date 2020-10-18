package com.example.animalsurvivorcontrol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnMessageListener{

    private Button btnConectar;
    private EditText codigo;
    private String myCode;
    private TCPSingleton tcp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConectar = findViewById(R.id.btnConectar);
        codigo = findViewById(R.id.codigo);

        tcp = TCPSingleton.getInstance();
        tcp.setObserver(this);

        btnConectar.setOnClickListener(
                (view) -> {

                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        myCode = codigo.getText().toString().trim();
        tcp.getIP(myCode);



    }

    @Override
    public void cuandoLlegueElMensaje(String msg) {

    }
}