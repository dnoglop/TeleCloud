package edmt.dev.androidgridlayout;

// ---- Classes Importadas --
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailAPI extends AsyncTask<Void,Void,Void>  {

    // --- Declaração das variaveis

    private Context mContext;  // Contexto (tela onde está o formulário)
    private Session mSession;
    private String  mSubject;
    private String  mMessage;
    private ProgressDialog mProgressDialog;

    // --- Construtor da Classe --
    public JavaMailAPI(Context mContext, String mSubject, String mMessage) {
        this.mContext = mContext;
        this.mSubject = mSubject;
        this.mMessage = mMessage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // --- Mostrando mensagem de carregamento enquanto envia o email --
        mProgressDialog = ProgressDialog.show(mContext,"Enviando Mensagem", "Aguarde...",false,false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        // --- Encerra a tela de carregamento quando o email for enviado --
        mProgressDialog.dismiss();

        // --- Mostra Toast de sucesso --
        Toast.makeText(mContext,"Mensagem Enviada, muito obrigado pelo Feedback",Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //--- Criando a classe de configuração --
        Properties props = new Properties();

        //--- Configurando as configurações do Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // --- Criando uma nova sessão --
        mSession = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    // --- Autenticação da conta --
                    protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication(Utils.EMAIL, Utils.SENHA); }
                });

        try {
            // --- Criando objeto da classe e passando a sessão criada --
            MimeMessage mm = new MimeMessage(mSession);

            // --- Configurando o email de Remetente --
            mm.setFrom(new InternetAddress(Utils.EMAIL));

            // --- Adicionando o Destinatário --
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress("d169692@dac.unicamp.br"));

            // --- Incluindo o Assunto --
            mm.setSubject(mSubject);

            // --- Adicionando a mensagem --
            mm.setText(mMessage);

            // --- Realizando o envio do e-mail --
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    } // Fim da função
}
// ===================================================== F I M =========================================