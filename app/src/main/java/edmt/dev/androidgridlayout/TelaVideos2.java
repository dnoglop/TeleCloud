package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class TelaVideos2 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static  String API_KEY = "AIzaSyA4YLfkzpc0o-mg_aekndtiX22pIq57_74";
    //public static  String VIDEO = "q8CZADZvr84";

    public String op;

    public Button btnLimite;
    public Button btnDerivada;
    public Button btnIntegral;
    public Button feed;
    public Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        btnLimite = (Button) findViewById(R.id.limites);
        btnDerivada = (Button) findViewById(R.id.derivada);
        btnIntegral = (Button) findViewById(R.id.integral);

        feed = (Button) findViewById(R.id.feed);
        back = (Button) findViewById(R.id.btbback);

        Intent intent1 = getIntent();
        Bundle dados = intent1.getExtras();

        op = dados.getString("ma");

        switch (op){
            case "videosCA":
                btnIntegral.setText("Playlit Integrais");
                btnDerivada.setText("Playlist Derivadas");
                btnLimite.setText("Playlist Limites");
                break;

            case "videosGA":
                btnIntegral.setText("Geometria Analítica");
                btnDerivada.setText("Geometria Plana");
                btnLimite.setText("Algebra Linear");
                break;
        }


        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.video_youtube1);
        youTubePlayerView.initialize(API_KEY, this);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent9 = new Intent(TelaVideos2.this, Feed.class);
                startActivity(intent9);
            }
        });

        btnLimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (op){
                    case "videosCA":
                        Intent intent1 = new Intent(TelaVideos2.this, TelaVideos.class);
                        Bundle dados4 = new Bundle();
                        dados4.putString("ma", "videosCA");
                        intent1.putExtras(dados4);
                        startActivity(intent1);
                        finish();
                        break;

                    case "videosGA":
                        Intent intent2 = new Intent(TelaVideos2.this, TelaVideos2.class);
                        Bundle dados3 = new Bundle();
                        dados3.putString("ma", "videosGA");
                        intent2.putExtras(dados3);
                        startActivity(intent2);
                        finish();
                        break;
                }
            }
        });

        btnDerivada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (op){
                    case "videosCA":
                        Intent intent3 = new Intent(TelaVideos2.this, TelaVideos1.class);
                        Bundle dados5 = new Bundle();
                        dados5.putString("ma", "videosCA");
                        intent3.putExtras(dados5);
                        startActivity(intent3);
                        finish();
                        break;

                    case "videosGA":
                        Intent intent4 = new Intent(TelaVideos2.this, TelaVideos1.class);
                        Bundle dados6 = new Bundle();
                        dados6.putString("ma", "videosGA");
                        intent4.putExtras(dados6);
                        startActivity(intent4);
                        finish();
                        break;
                }
            }
        });

        btnIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (op){
                    case "videosCA":
                        Intent intent5 = new Intent(TelaVideos2.this, TelaVideos2.class);
                        Bundle dados7 = new Bundle();
                        dados7.putString("ma", "videosCA");
                        intent5.putExtras(dados7);
                        startActivity(intent5);
                        finish();
                        break;

                    case "videosGA":
                        Intent intent6 = new Intent(TelaVideos2.this, TelaVideos.class);
                        Bundle dados8 = new Bundle();
                        dados8.putString("ma", "videosGA");
                        intent6.putExtras(dados8);
                        startActivity(intent6);
                        finish();
                        break;
                }
            }
        });


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Erro no Carregamento!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /** Start buffering **/
        if (!wasRestored) {
            Intent intent = getIntent();
            Bundle dados = intent.getExtras();

            op = dados.getString("ma");

            switch (op){
                case "videosCA":

                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent9 = new Intent(TelaVideos2.this, Opcoes.class);
                            Bundle dados8 = new Bundle();
                            dados8.putString("op", "cal");
                            intent9.putExtras(dados8);
                            startActivity(intent9);
                            finish();
                        }
                    });

                    player.cuePlaylist("PLf1lowbdbFIAGzFSFAB-MRrXgJKV-YAHc");break;

                case "videosGA":

                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent intent9 = new Intent(TelaVideos2.this, Opcoes.class);
                            Bundle dados8 = new Bundle();
                            dados8.putString("op", "ga");
                            intent9.putExtras(dados8);
                            startActivity(intent9);
                            finish();
                        }
                    });

                    player.cuePlaylist("PLEfwqyY2ox858XssXB_f-Jx42fgTb0Vsn");break;
            }
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onBuffering(boolean arg0) {
            }
            @Override
            public void onPaused() {
            }
            @Override
            public void onPlaying() {
            }
            @Override
            public void onSeekTo(int arg0) {
            }
            @Override
            public void onStopped() {
            }
        };

        private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onAdStarted() {
            }
            @Override
            public void onError(YouTubePlayer.ErrorReason arg0) {
            }
            @Override
            public void onLoaded(String arg0) {
            }
            @Override
            public void onLoading() {
            }
            @Override
            public void onVideoEnded() {
            }
            @Override
            public void onVideoStarted() {
            }
        };
    }