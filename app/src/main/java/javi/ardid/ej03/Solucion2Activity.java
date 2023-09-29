package javi.ardid.ej03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Solucion2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solucion2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String respuesta = null;
        int res;

        if(bundle.containsKey("LETRAS")){
            respuesta = bundle.getString("LETRAS");
            res = respuesta.length();
            Toast.makeText(this, "Letras"+res, Toast.LENGTH_SHORT).show();
        }else{
            if(bundle.containsKey("PALABRAS")){
                respuesta = bundle.getString("PALABRAS");
                res = respuesta.split(" ").length;
                Toast.makeText(this, "Palabras", Toast.LENGTH_SHORT).show();
            }
        }

    }
}