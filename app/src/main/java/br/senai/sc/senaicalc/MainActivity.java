package br.senai.sc.senaicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeironumero = "";
    private String segundonumero = "";
    private String operacao = "";
    private float resultado = 0;
    private float numero1 = 0;
    private float numero2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBotao0(View v){
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClickBotao1(View v){
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBotao2(View v){
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBotao3(View v){
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBotao4(View v){
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBotao5(View v){
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBotao6(View v){
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBotao7(View v){
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBotao8(View v){
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBotao9(View v){
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }

    public void onClickAdicao(View v){
        verificarOperacao("+");
    }

    public void onClickSubtracao(View v){
        verificarOperacao("-");
    }

    public void onClickMultiplicacao(View v){
        verificarOperacao("*");
    }

    public void onClickDivisao(View v){
        verificarOperacao("/");
    }



    public void onClickIgual(View v){
        if(!primeironumero.isEmpty() && !segundonumero.isEmpty()){
            float numero1 = Integer.parseInt(primeironumero);
            float numero2 = Integer.parseInt(segundonumero);
            if(operacao.equals("+")){
                float resultado = numero1 + numero2;
                display.setText(String.valueOf(resultado));
            }
            if(operacao.equals("-")){
                float resultado = numero1 - numero2;
                display.setText(String.valueOf(resultado));
            }
            if(operacao.equals("*")){
                float resultado = numero1 * numero2;
                display.setText(String.valueOf(resultado));
            }
            if(operacao.equals("/")){
                if(numero2 !=0){
                    float resultado = numero1 / numero2;
                    display.setText(String.valueOf(resultado));
                }else{
                    Toast.makeText(MainActivity.this, "Não é possivel dividir por 0", Toast.LENGTH_LONG).show();
                }
            }
        }else {
            Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_LONG).show();
        }
    }

    private void verificarOperacao(String texto){
        if(!primeironumero.isEmpty()){
            operacao = texto;
            atualizarDisplay(texto);
        }else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    private void atualizarDisplay(String texto){
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero){
        if(operacao.isEmpty()){
            primeironumero = primeironumero + numero;
        }else {
            segundonumero = segundonumero + numero;
        }
    }
}