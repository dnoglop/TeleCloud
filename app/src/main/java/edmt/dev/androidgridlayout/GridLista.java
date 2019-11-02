package edmt.dev.androidgridlayout;

// --- Classes Importadas --
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLista extends AppCompatActivity {

    // ---- Declarando as variáveis do programa ----
    GridLayout mainGrid;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lista);

        // ---- Chamando o GrindLayout na inicialização ----
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        // ---- Função para identificar qual botão pressionou ----
        setSingleEvent(mainGrid);
    }


    // ---- Função que identifica qual botão foi pressionado e abre a tela correspondente ----
    private void setSingleEvent(GridLayout mainGrid) {

        // Loop para analizar cada botão separado
        for (int i = 0; i < mainGrid.getChildCount(); i++) {

            // Como todos são Button, vamos apenas separar para analisar eles separadamente
            Button cardView = (Button) mainGrid.getChildAt(i);

            // ---- variável para receber o valor de i (ou seja, qual botão foi pressionado) ----
            final int finalI = i;

            // ---- Verificando se algum botão foi pressionado ----
            cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    // ---- Verifica se a activity anterior mandou alguma informação através da chave "ma"

                    Intent intent = getIntent();
                    Bundle dados = intent.getExtras();
                    op = dados.getString("ma");

                    // ---- Dependendo da palavra enviada, abre a lista da materia

                    switch (op){
                        case "listaCA":
                            if (finalI == 0) {

                                Intent intent1 = new Intent(GridLista.this, TelaLista.class);

                                Bundle dados1 = new Bundle();
                                dados1.putString("lista", "listaCA1");
                                intent1.putExtras(dados1);

                                startActivity(intent1);
                                finish();
                            }

                            if (finalI == 1) {

                                Intent intent1 = new Intent(GridLista.this, TelaLista.class);

                                Bundle dados2 = new Bundle();
                                dados2.putString("lista", "livroCA2");
                                intent1.putExtras(dados2);

                                startActivity(intent1);
                                finish();
                            }break;

                        case "listaGA":
                            if (finalI == 0) {

                                Intent intent1 = new Intent(GridLista.this, TelaLista.class);

                                Bundle dados1 = new Bundle();
                                dados1.putString("lista", "listaGA1");
                                intent1.putExtras(dados1);

                                startActivity(intent1);
                                finish();
                            }

                            if (finalI == 1) {

                                Intent intent1 = new Intent(GridLista.this, TelaLista.class);

                                Bundle dados2 = new Bundle();
                                dados2.putString("lista", "livroGA2");
                                intent1.putExtras(dados2);

                                startActivity(intent1);
                                finish();
                            }break;
                    } // Fim do Switch
                }
            }); // Fim do onClick
        } // Fim do loop for
    }
}
// ================================================== F I M =========================================