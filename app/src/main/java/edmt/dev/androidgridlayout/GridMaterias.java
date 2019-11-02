package edmt.dev.androidgridlayout;

// --- Classes Importadas --
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class GridMaterias extends AppCompatActivity {

    // ---- Variável do tipo GridLayout ----
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

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

                    // ---- para cada if, uma nova activity será aberta ----

                    if(finalI == 0) {

                        Intent intent = new Intent(GridMaterias.this, Opcoes.class);

                        Bundle dados = new Bundle();
                        dados.putString("op", "cal");
                        intent.putExtras(dados);

                        startActivity(intent); // Iniciando a proxima tela
                    }

                    if(finalI == 1) {

                        Intent intent1 = new Intent(GridMaterias.this, Opcoes.class);

                        Bundle dados = new Bundle();
                        dados.putString("op", "ga");
                        intent1.putExtras(dados);

                        startActivity(intent1);
                    }
                }
            });
        }
    }
}
// =============================================== F I M ========================================