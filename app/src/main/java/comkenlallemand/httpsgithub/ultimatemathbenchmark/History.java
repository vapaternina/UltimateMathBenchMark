package comkenlallemand.httpsgithub.ultimatemathbenchmark;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class History extends AppCompatActivity {
    TextView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lista = findViewById(R.id.lista);

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        Toast.makeText(this, "Consultando Resultados", Toast.LENGTH_SHORT).show();
        String texto = preferencias.getString("Resultados","");
        if(texto.length()>0){
            lista.setText(texto);
        }else{
            lista.setText("Nada que ver aqui");
        }
    }

    public void Return(View view){
        Intent anterior = new Intent(this,MainActivity.class);
        startActivity(anterior);
    }

    public void Delete(View view){
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("Resultados","");
        obj_editor.commit();
        Toast.makeText(this,"Historial Borrado",Toast.LENGTH_SHORT).show();
    }
}
