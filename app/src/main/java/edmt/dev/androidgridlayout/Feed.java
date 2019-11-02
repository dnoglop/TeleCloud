package edmt.dev.androidgridlayout;

// --- Classes Importadas
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Feed extends AppCompatActivity {

    // ---- Declarando as variáveis utilizadas na tela

    public EditText mEmail;
    public EditText mSubject;
    public EditText mMessage;
    public EditText mNome;
    public Button  btnEnviar;
    public ImageView iv;

    // ---- Inflando a tela com os componentes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        // ---- Linkando os elementos da tela com as variáveis declaradas

        mEmail = (EditText)findViewById(R.id.mailId);
        mMessage = (EditText)findViewById(R.id.mensageID);
        mSubject = (EditText)findViewById(R.id.assuntoID);
        mNome = (EditText) findViewById(R.id.nomeID);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        iv = (ImageView) findViewById(R.id.logo);

        // ---- Quando clicarmos em 'Enviar Mensagem' os dados são enviados

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    // ---- Função para realizar o envio das informaçãoes inseridas

    private void sendMail() {

        String mail = mEmail.getText().toString().trim();
        String name = mNome.getText().toString();
        String message = mMessage.getText().toString();
        String subject = mSubject.getText().toString().trim();

        // ---- Mensagem que será enviada no corpo do e-mail

        String ms = ("Olá, uma nova mensagem de " + name + "\n\n" + "Mensagem: \n" + message + "\n\n" + "Email: " + mail);

        // ---- Função que realiza o envio tendo como parâmetros o assunto e a mensagem
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,subject,ms);
        javaMailAPI.execute();

        // ---- Limpa todos os campos da tela

        mEmail.setText("");
        mNome.setText("");
        mSubject.setText("");
        mMessage.setText("");
    }
}
// ============================================ F I M =========================================