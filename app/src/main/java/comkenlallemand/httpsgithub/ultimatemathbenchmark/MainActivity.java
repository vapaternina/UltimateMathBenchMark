package comkenlallemand.httpsgithub.ultimatemathbenchmark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Fibonacci(View view){
        Intent siguiente = new Intent(this,BenchMark.class);
        siguiente.putExtra("name","Calculo de Fibonacci");
        Toast.makeText(this,"Espera a que se ejecute",Toast.LENGTH_LONG).show();
        startActivity(siguiente);
    }

    public void PI(View view){
        Intent siguiente = new Intent(this,BenchMark.class);
        siguiente.putExtra("name","Calculo de PI");
        Toast.makeText(this,"Espera a que se ejecute",Toast.LENGTH_LONG).show();
        startActivity(siguiente);
    }

    public void Both(View view){
        Intent siguiente = new Intent(this,BenchMark.class);
        siguiente.putExtra("name","Calculo Completo");
        Toast.makeText(this,"Espera a que se ejecute",Toast.LENGTH_LONG).show();
        startActivity(siguiente);
    }

    public void History(View view){
        Intent siguiente = new Intent(this,History.class);
        siguiente.putExtra("name","Historial");
        startActivity(siguiente);
    }
}
