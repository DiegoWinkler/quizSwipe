package com.adalto.quiz_2019_1;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView tvAfirmacao;
    private ImageView ivEsquerda, ivDireita;

    private String tipo;
    private String[] afirmacoes;
    private boolean[] gabarito;
    private int contadorRespostas=  1;

    private LinearLayout layout;

    private int contador, acertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        afirmacoes = new String[] {
                "Os humanos podem respirar e engolir ao mesmo tempo.",
                "Tomar leite quente induz o sono.",
                "Um pão com manteiga jogado ao ar cai pelo lado da manteiga três de cada quatro vezes.",
                "Os redemoinho que se criam na pia vão em direções opostas dependendo do hemisfério em que estejam.",
                "As digitais acostumam estar determinadas pelos nossos genes, então podem ser parecidas com as dos nossos pais."
        };

        gabarito = new boolean[]{  false, true, false, false, false};

        tipo = getIntent().getExtras().getString("tipo");
        contador = 0;

        layout = (LinearLayout) findViewById(R.id.layout);
        tvAfirmacao = (TextView) findViewById(R.id.tvAfirmacao);
        ivDireita = (ImageView) findViewById(R.id.ivDireita);
        ivEsquerda = (ImageView) findViewById(R.id.ivEsquerda);

        if (tipo.equals("vertical")){
            ivEsquerda.setImageResource(R.drawable.abaixo);
            ivDireita.setImageResource(R.drawable.acima);
        }

        tvAfirmacao.setText( afirmacoes[contador] );

        layout.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                contador --;
                tvAfirmacao.setText( afirmacoes[contador]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if(contadorRespostas == afirmacoes.length){
                    tvAfirmacao.setText("Acertou! " + acertos);
                }
                contadorRespostas++;


                contador ++;
                tvAfirmacao.setText( afirmacoes[contador]);
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                if( !gabarito[contador]){
                    acertos ++;
                }
                this.onSwipeLeft();
            }


            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                if(gabarito[contador]){
                    acertos ++;
                }
                this.onSwipeLeft();

            }

        });


    }


}


















