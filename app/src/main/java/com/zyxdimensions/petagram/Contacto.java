package com.zyxdimensions.petagram;

import android.os.StrictMode;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    private String correo, correo_destino;
    private String contrasena;
    private String nombre;
    private String comentario;
    private Session session;

    private EditText etMensaje, etNombre, etCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etMensaje = (EditText) findViewById(R.id.etMensaje);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
    }

    public void enviarComentario(View v){
        //Estiramos el mensaje, el nombre, el correo destino
        comentario = etMensaje.getText().toString();
        nombre = etNombre.getText().toString();
        correo_destino = etCorreo.getText().toString();

        //Establecemos el correo y la contrasena
        correo = "coursera1prueba@gmail.com";
        contrasena = "876543210";

        //Establecemos las propiedades
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try {
            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo, contrasena);
                }
            });

            if (session != null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject(nombre);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo_destino));
                message.setContent(comentario, "text/html; charset=utf-8");
                Transport.send(message);
                Toast.makeText(this, getResources().getString(R.string.respuesta_mensaje), Toast.LENGTH_SHORT).show();
                finish();
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
