package javi.ardid.ej03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtFrase;
    private Button btnPalabras;
    private Button btnCaracteres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        inicializarVista();

       /* btnPalabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frase = txtFrase.getText().toString();
                if(frase.length()>0){
                    int contarPalabras = frase.split(" ").length; //Split se usa para trocear el texto que tu le das y devuelve un array de String.
                    String mensaje = "El número de palabras es "+contarPalabras;
                    crearNuevaActividad(mensaje);
                }else{
                    Toast.makeText(MainActivity.this, "Escribe algo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCaracteres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frase = txtFrase.getText().toString();
                if(frase.length()>0){
                    int contarCaracteres = frase.trim().length();
                    String mensaje = "El número de caracteres es "+contarCaracteres;
                    crearNuevaActividad(mensaje);
                }else{
                    Toast.makeText(MainActivity.this, "Escribe algo", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
    }

    public void onClick(View boton){
        String frase = txtFrase.getText().toString();
        int contarPalabras=0;

        if(frase.length()>0){
            if(boton.getId()==R.id.btnPalabrasMain){
                contarPalabras = frase.split(" ").length;
            }else{
                if(boton.getId()==R.id.btnCaracteresMain){
                    contarPalabras = frase.trim().length();
                }
            }

            String mensaje = "El número de caracteres es "+contarPalabras;
            crearNuevaActividad(mensaje);
        }else{
            Toast.makeText(MainActivity.this, "Escribe algo", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick2(View boton){
        String frase = txtFrase.getText().toString();

        Intent intent = new Intent(MainActivity.this, Solucion2Activity.class);
        Bundle bundle = new Bundle();
        if(boton.getId()==R.id.btnCaracteresMain) {
            bundle.putString("FRASe", frase);
            bundle.putInt("BOTON", boton.getId());

            startActivity(intent);
        }

    }

    private void crearNuevaActividad(String mensaje) {
        Intent intent = new Intent(MainActivity.this, MostrarResultadoActivity.class); //Para cambiar de actividad (main)
        Bundle bundle = new Bundle();
        bundle.putString("MSG", mensaje);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void inicializarVista() {
        txtFrase = findViewById(R.id.txtFraseMain);
        btnPalabras = findViewById(R.id.btnPalabrasMain);
        btnCaracteres = findViewById(R.id.btnCaracteresMain);
    }
}