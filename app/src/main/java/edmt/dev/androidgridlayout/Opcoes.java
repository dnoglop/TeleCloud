package edmt.dev.androidgridlayout;

// --- Classes Importadas --
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class Opcoes extends AppCompatActivity {

    // ---- Variável do tipo GridLayout ----
    GridLayout mainGrid;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

        // ---- Chamando o GrindLayout na inicialização ----
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        // ---- Função para identificar qual botão pressionou ----
        setSingleEvent(mainGrid);
    }


    // ---- Função que identifica qual card foi pressionado e abre a tela correspondente ----
    private void setSingleEvent(GridLayout mainGrid) {

        // Loop para analizar cada card separado
        for (int i = 0; i < mainGrid.getChildCount(); i++) {

            // Como todos são cardview, vamos apenas separar para analisar eles separadamente
            CardView cardView = (CardView) mainGrid.getChildAt(i);

            // ---- variável para receber o valor de i (ou seja, qual card foi pressionado) ----
            final int finalI = i;

            // ---- Verificando se algum cardview foi pressionado ----
            cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    // --- Verifica se algo foi enviado da ultima activity ---
                    Intent intent = getIntent();
                    Bundle dados = intent.getExtras();
                    op = dados.getString("op");  // Armazenando na variavel 'op'

                    switch (op){
                        case "cal":

                            // ---- para cada if, uma nova activity será aberta ----
                            if (finalI == 0) {

                                Intent intent1 = new Intent(Opcoes.this, GridLista.class);

                                Bundle dados1 = new Bundle();
                                dados1.putString("ma", "listaCA");
                                intent1.putExtras(dados1);

                                startActivity(intent1);
                                finish();
                            }

                            if (finalI == 1) {

                                Intent intent2 = new Intent(Opcoes.this, TelaLivros.class);

                                Bundle dados2 = new Bundle();
                                dados2.putString("ma", "livroCA");
                                intent2.putExtras(dados2);

                                startActivity(intent2);
                                finish();
                            }

                            if (finalI == 2) {

                                Intent intent3 = new Intent(Opcoes.this, TelaVideos.class);

                                Bundle dados3 = new Bundle();
                                dados3.putString("ma", "videosCA");
                                intent3.putExtras(dados3);

                                startActivity(intent3);
                                finish();
                            }

                            if (finalI == 3) {

                                Intent intent4 = new Intent(Opcoes.this, Feed.class);
                                startActivity(intent4);
                                finish();
                            }
                            break; // Fim do case 'ca'

                    case "ga":
                    if (finalI == 0) {

                        Intent intent1 = new Intent(Opcoes.this, GridLista.class);

                        Bundle dados1 = new Bundle();
                        dados1.putString("ma", "listaGA");
                        intent1.putExtras(dados1);

                        startActivity(intent1);
                        finish();
                    }

                    if (finalI == 1) {

                        Intent intent1 = new Intent(Opcoes.this, TelaLivros.class);

                        Bundle dados2 = new Bundle();
                        dados2.putString("ma", "livroGA");
                        intent1.putExtras(dados2);

                        startActivity(intent1);
                        finish();
                    }

                    if (finalI == 2) {

                        Intent intent1 = new Intent(Opcoes.this, TelaVideos.class);

                        Bundle dados3 = new Bundle();
                        dados3.putString("ma", "videosGA");
                        intent1.putExtras(dados3);

                        startActivity(intent1);
                        finish();
                    }

                        if (finalI == 3) {

                            Intent intent1 = new Intent(Opcoes.this, Feed.class);
                            startActivity(intent1);
                            finish();
                        }
                    break; // Fim do case 'ga'
                } // Fim do switch
                }
            });
        }
    }
}
// =================================================== F I M ======================================