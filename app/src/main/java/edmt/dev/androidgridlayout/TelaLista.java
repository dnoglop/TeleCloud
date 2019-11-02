package edmt.dev.androidgridlayout;

// --- Classes Importadas --
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TelaLista extends AppCompatActivity {

    // --- Declarando as variáveis --
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista1);

        // --- Verifica se a ultima activity enviou algo atrvés da TAG 'lista'
        Intent intent = getIntent();
        Bundle dados = intent.getExtras();
        op = dados.getString("lista");  // Armazena a mensagm na variavel 'op'

        switch (op) {
            case "listaCA1":
                WebView webView = (WebView) findViewById(R.id.webview);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("https://drive.google.com/drive/folders/1B84fkbxWkirfi5A87z8YB6j3B2LAtHy_?usp=sharing"); // Lista Calculo 1
                break;

            case "listaGA1":
                WebView webView1 = (WebView) findViewById(R.id.webview);
                webView1.getSettings().setJavaScriptEnabled(true);
                webView1.setWebViewClient(new WebViewClient());
                webView1.loadUrl("https://drive.google.com/drive/folders/1EC8LjgN8yqBgplNdbqszwbMtrUc_9-8X?usp=sharing"); // Lista GA
                break;
        }
    }
}
// ====================================================== F I M ===================================================