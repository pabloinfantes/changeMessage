package com.example.changemessage.ul;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.changemessage.ChangeMessageApplication;
import com.example.changemessage.R;
import com.example.changemessage.model.Message;

/**
 * <h1>Función de la clase</h1>
 * <p>Esta clase envia un texto a otra actividad y le indica el tamaño del texto.</p>
 * <h2>Aprendizaje</h2>
 * <ul>
 *     <li>Qué es un Contexto</li>
 *     <li>Qué se pueden introducir etiquetas HTML dentro de los comentario Javadod</li>
 *     <li>Qué es un objeto {@link android.os.Bundle} </li>
 *     <li>El paso de mensaje de dos Activity mediante la clase <a target="_blank" href="https://developer.android.com/reference/android/content/Intent">Intent</a></li>
 * </ul>
 *
 * @author Pablo Infantes
 * @version 1.0
 * @see ViewMessageActivity#onCreate(Bundle)
 */

public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private Button btSendMessage;
    private EditText edMessage;
    private SeekBar skSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        btSendMessage = findViewById(R.id.btSendMessage);
        edMessage = findViewById(R.id.edMessage);
        skSize = findViewById(R.id.skSize);
        btSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.Crear un objeto contenedor o Bundle para añadir los datos
                Bundle bundle = new Bundle();
                //bundle.putString("message", edMessage.getText().toString());
                //bundle.putInt("size", skSize.getProgress());
                //1.1 Crear un objeto message
                Message message = new Message(((ChangeMessageApplication)getApplication()).getUser(),
                        edMessage.getText().toString(),"16/10/2020",skSize.getProgress());
                bundle.putSerializable("message",message);


                //2. Se crea el objeto Intent explicito se concoce la Activity origen y la Activity destino
                Intent intent = new Intent(SendMessageActivity.this, ViewMessageActivity.class);

                //3. Añadir el objeto Bundle al Intent
                intent.putExtras(bundle);

                //4. Iniciar la Activity destino ViewMessageActivity
                startActivity(intent);
            }
        });
        Log.i(TAG, "SendMessageActivity: onCreate()");


    }

    /**
     * Método que se ejecuta cuando se pulsa el boton btAbout
     * Se ha implementado mediante el atributo android:onclick en
     * activity sendmessage.
     * @param view botón donde de ha realizado click
     */
    public void showAbout(View view){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
    //region Ciclo de vida de la Activity
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SendMessageActivity: onStart()");


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "SendMessageActivity: onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "SendMessageActivity: onPause()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SendMessageActivity: onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SendMessageActivity: onDestroy()");

    }
//endregion de

}