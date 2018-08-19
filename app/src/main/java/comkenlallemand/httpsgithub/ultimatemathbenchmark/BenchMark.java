package comkenlallemand.httpsgithub.ultimatemathbenchmark;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class BenchMark extends AppCompatActivity {
    TextView Resultado,Head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_mark);
        Resultado = findViewById(R.id.Resultado);
        Head = findViewById(R.id.head);
        String nombre = getIntent().getStringExtra("name");

        long ini,fin,n;
        String saved = "";
        n=10000000;

        switch (nombre){
            case "Calculo de PI": {
                Head.setText(nombre);
                ini = milis();
                Pi();
                fin = milis();
                //System.out.println(ini);
                //System.out.println(fin);
                long temp = fin - ini;
                temp = n/temp;
                saved = String.valueOf(temp);
                Resultado.setText(saved);
                break;
            }

            case "Calculo de Fibonacci": {
                Head.setText(nombre);
                ini = milis();
                Fibonacci();
                fin = milis();
                System.out.println(ini);
                System.out.println(fin);
                long temp = fin - ini;
                temp = n/temp;
                saved = String.valueOf(temp);
                Resultado.setText(saved);
                break;
            }

            case "Calculo Completo": {
                Head.setText(nombre);
                ini = milis();
                Pi();
                fin = milis();
                long temp = fin - ini;
                temp = n/temp;
                Resultado.setText(String.valueOf(temp));
                ini = milis();
                Fibonacci();
                fin = milis();
                temp = fin - ini;
                temp = n/temp;
                saved = Resultado.getText()+"   "+String.valueOf(temp);
                Resultado.setText(Resultado.getText()+"\n"+String.valueOf(temp));
                break;
            }

            default:{
                Toast.makeText(this,"Error Desconocido",Toast.LENGTH_LONG).show();
            }
        }
        save(saved);
    }

    private void Pi(){
        BigInteger pi = new BigInteger("0");
        BigInteger num = new BigInteger("4");
        BigInteger den;
        BigInteger temp;
        int n;
        for(int i = 1; i<=100000; i++){
            if(i%2==0){
                n = (i*2)-1;
                den = new BigInteger(Integer.toString(n));
                System.out.println(num);
                temp = num.divide(den);
                System.out.println(num);
                pi = pi.add(temp);

            }else{
                n = (i*2)-1;
                den = new BigInteger(Integer.toString(n));
                System.out.println(num);
                temp = num.divide(den);
                System.out.println(num);
                pi = pi.subtract(temp);
            }
        }
        //System.out.println(pi);
    }

    private void Fibonacci(){
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger temp;

        for(int i = 1; i<=100000; i++){
            temp = a.add(b);
            a = b;
            b = temp;
        }
        //System.out.println(b);
    }

    private long milis(){
        return System.currentTimeMillis();
    }

    public void Return(View view){
        Intent anterior = new Intent(this,MainActivity.class);
        startActivity(anterior);
    }

    private void save(String saved){
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String texto = preferencias.getString("Resultados","");
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("Resultados",texto + Head.getText().toString() +" --- "+ saved+"\n");
        obj_editor.commit();
    }
}
