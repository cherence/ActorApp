package com.example.cher.actorapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomAdapter customAdapter;
    Button button;
    Button bigPictureButton;
    Button bigTextButton;
    Button listNoteButton;
    Intent intent;
    public static final int NOTIFICATION_ID = 123;
    NotificationManager mNotifcationManager;
    NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.makeNotificationID);
        bigPictureButton=(Button)findViewById(R.id.bigPictureID);
        bigTextButton = (Button)findViewById(R.id.bigTextID);
        listNoteButton=(Button)findViewById(R.id.listNotificationID);

        ArrayList<Actor> mActorArrayList = new ArrayList<>();
        mActorArrayList.add(new Actor("Brad Pitt", "Nov 11, 1974", "2"));
        mActorArrayList.add(new Actor("Seth Rogen", "Oct 8, 1970", "1"));
        mActorArrayList.add(new Actor("Owen Wilson", "Nov 18, 1968", "1"));
        listView = (ListView)findViewById(R.id.listView_id);
        customAdapter = new CustomAdapter(MainActivity.this,mActorArrayList);
        listView.setAdapter(customAdapter);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Network Connected?");
        mBuilder.setContentIntent(pIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setPriority(Notification.PRIORITY_HIGH);
        mNotifcationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        if (networkInfo!=null && networkInfo.isConnected()) bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.connected)).build();
        else bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.notconnected)).build();
        mBuilder.setStyle(bigPictureStyle);
        mNotifcationManager.notify(NOTIFICATION_ID, mBuilder.build());


//
//        intent = new Intent(this, SecondActivity.class);
//        PendingIntent pIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);
//        mBuilder = new NotificationCompat.Builder(this);
//        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
//        mBuilder.setContentTitle("Notification works");
//        mBuilder.setContentText("l;sjdfaosdjfaiwejf;awjef;aoweifja;welifj;awiejf;aiwoejf awejfapow eijfapowiej fpaowijefpaio");
//        mBuilder.setContentIntent(pIntent);
//        mBuilder.setPriority(Notification.PRIORITY_HIGH);
//        mBuilder.setAutoCancel(true);
//        mNotifcationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotifcationManager.notify(NOTIFICATION_ID, mBuilder.build());

            }
        });
        bigPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.cabin)).build();
                mBuilder.setStyle(bigPictureStyle);
                mNotifcationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
        });
        bigTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("Big Text Content Title");
                bigTextStyle.bigText("When the app is launched, there should be an expanded notification with a big picture informing the user about network connectivity. When the notification is clicked, the user should redirected to another activity. If network is available, the notification should be dismissed in the second activity. If network is not available, the notification icon should be kept at the top left corner of the app.");
                bigTextStyle.setSummaryText("Notification stuff, etc, etc");
                mBuilder.setStyle(bigTextStyle);
                mNotifcationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
        });
        listNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("Inbox Notification");
                inboxStyle.addLine("Message 1.");
                inboxStyle.addLine("Message 2.");
                inboxStyle.addLine("Message 3.");
                inboxStyle.addLine("Message 4.");
                inboxStyle.addLine("Message 5.");
                inboxStyle.setSummaryText("+2 more");
                mBuilder.setStyle(inboxStyle);
                mNotifcationManager.notify(NOTIFICATION_ID,mBuilder.build());
            }
        });
    }
}