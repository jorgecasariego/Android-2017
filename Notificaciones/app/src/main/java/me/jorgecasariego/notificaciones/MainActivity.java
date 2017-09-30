package me.jorgecasariego.notificaciones;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button imagenGrandeButton;
    private Button textoGrandeButton;
    private Button inboxStyleButton;

    // Paso 1 - Creamos un NotificationManager
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paso 2 - Inicializamos el NotificationManager
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        imagenGrandeButton = (Button) findViewById(R.id.notificar2);
        imagenGrandeButton.setOnClickListener(this);

        textoGrandeButton = (Button) findViewById(R.id.notificar3);
        textoGrandeButton.setOnClickListener(this);

        inboxStyleButton = (Button) findViewById(R.id.notificar4);
        inboxStyleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //Paso 3 - Creamos un objeto del tipo Notification
        Notification notification = null;
        int idNotificacion;

        switch (view.getId()){
            case R.id.notificar2:
                idNotificacion = 1;
                notification = bigPictureNotification(idNotificacion);
                sendNotification(notification, idNotificacion);
                break;
            case R.id.notificar3:
                idNotificacion = 2;
                notification = bigTextNotification(idNotificacion);
                sendNotification(notification, idNotificacion);
                break;
            case R.id.notificar4:
                idNotificacion = 3;
                notification = inboxStyleNotification(idNotificacion);
                sendNotification(notification, idNotificacion);
                break;
        }
    }

    // Pasos para notificar
    // 1. Obtenemos una instancia del NotificationManager
    // 2. Usamos el metodo notify para enviar la notificacion. Cuando se utiliza este metodo es
    // necesario utilizar un Notification ID. Podemos utilizar este notificacion ID para actualizar
    // las actualizaciones despues
    private void sendNotification(Notification notification, int idNotificacion) {
        notificationManager.notify(idNotificacion, notification);

    }

    //************ Creamos la apareciena de nuestras notificaciones ************

    //Caso 1 - BigPictureNotification
    @TargetApi(Build.VERSION_CODES.O)
    private Notification bigPictureNotification(int idNotificacion){
        // 1. Creamos el constructor de notificaciones
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 2. Seteamos el titulo y el texto
        builder.setContentTitle("Clase de Notificaciones");
        builder.setContentText("Este es un ejemplo de notificaciones con imagenes");

        // 3. Seteamos el icono de la aplicación
        builder.setSmallIcon(R.mipmap.ic_launcher);

        // 4. Construimos un Bitmap con la imagen  que queremos mostrar en la notificación
        Bitmap icon = BitmapFactory.decodeResource(this.getResources(), R.drawable.asuncion);
        builder.setLargeIcon(icon);

        // 5. Seteamos la apariencia de la notificacion
        NotificationCompat.BigPictureStyle bigPictureStyle =
                new android.support.v4.app.NotificationCompat.BigPictureStyle()
                .bigPicture(icon)
                .bigLargeIcon(icon)
                .setBigContentTitle("Primavera en Asunción!")
                .setSummaryText("Los lapachos son cada año parte de la primavera asuncena");

        // 6. Seteamos el estilo de la notificacion
        builder.setStyle(bigPictureStyle);

        // 7. Agregaos una acción a realizar una vez pulsada la notificación
        PendingIntent pendingIntent = agregarAccion(idNotificacion);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);

        return builder.build();

    }

    // Caso 2
    private Notification bigTextNotification(int idNotificacion) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Bitmap iconoGrande = BitmapFactory.decodeResource(getResources(), R.drawable.asuncion);

        builder.setContentTitle("Clase de Notificaciones")
                .setContentText("3 nuevas fotos")
                .setContentInfo("Asunción")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(iconoGrande);

        PendingIntent pendingIntent = agregarAccion(idNotificacion);

        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);


        return new NotificationCompat.BigTextStyle(builder)
                .bigText("¡Tus fotos fueron sincronizadas!")
                .setBigContentTitle("Notificaciones")
                .setSummaryText("Click para ver detalle de las fotos")
                .build();

    }

    // Caso 3: Inbox notification
    private Notification inboxStyleNotification(int idNotificacion) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Bitmap iconoGrande = BitmapFactory.decodeResource(getResources(), R.drawable.asuncion);

        builder.setContentTitle("Clase de Fotos")
                .setContentText("3 nuevas fotos")
                .setContentInfo("Asunción")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(iconoGrande);

        NotificationCompat.InboxStyle inboxStyle = new android.support.v4.app.NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Comentarios recibidos");
        inboxStyle.addLine("Que buena foto!");
        inboxStyle.addLine("Increible");
        inboxStyle.addLine("Segui así. No pares nunca!");
        inboxStyle.addLine("Me quiero casar contigo!");
        inboxStyle.setSummaryText("+2 mensajes");

        builder.setStyle(inboxStyle);

        PendingIntent pendingIntent = agregarAccion(idNotificacion);
        builder.setContentIntent(pendingIntent);

        PendingIntent sharedPendingIntent = generarSharedIntent();
        builder.addAction(android.R.drawable.ic_menu_share, "Compartir", sharedPendingIntent);

        builder.setAutoCancel(true);

        return builder.build();

    }

    private PendingIntent generarSharedIntent() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Texto a compartir.");
        shareIntent.setType("text/plain");

        PendingIntent sharedPendingIntent = PendingIntent.getActivity(
                this,
                (int) Calendar.getInstance().getTimeInMillis(),
                shareIntent,
                0);

        return sharedPendingIntent;
    }

    private PendingIntent agregarAccion(int idNotificacion) {
        Intent resultadoClickNotificacion = new Intent(this, ResultadoActivity.class);
        resultadoClickNotificacion.putExtra("id", idNotificacion);

        PendingIntent intent = PendingIntent.getActivity(
                this,
                0,
                resultadoClickNotificacion,
                PendingIntent.FLAG_UPDATE_CURRENT);

        return intent;
    }
}
