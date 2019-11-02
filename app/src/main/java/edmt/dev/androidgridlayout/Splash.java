package edmt.dev.androidgridlayout;

// --- Classes Importadas --
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    // --- Declarando as variaveis
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // --- Linkando a imagem com a variavel criada --
        iv = (ImageView) findViewById(R.id.logo);

        // --- Realizando a animação na tela --
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.transition);
        iv.startAnimation(myanim);

        // --- Após a animação, abre a próxima activity --
        final Intent intent = new Intent(Splash.this, GridSemestre.class);

        // --- Thread para deixa a tela parada enquanto a animação ocorre --
        Thread timer = new Thread(){

            public void run(){

                try{
                    sleep(3000); // Espera o tempo de 3 segundos
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {

                    // --- Encerra a atual activity e abre a próxima --
                    finish();
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}
// ==================================================== F I M ============================================