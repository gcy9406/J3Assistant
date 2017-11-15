package cn.mycats.j3assistant;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Binder;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

public class ListeningServer extends Service {

    private NotificationCompat.Builder builder;
    private SoundPool soundPool;
    private int soundId;
    private int mPlay;
    private SP sp;
    private Vibrator vibrator;
    private long[] pattern;

    public ListeningServer() {

    }
    private boolean bListen = true;
    @Override
    public void onCreate() {
        super.onCreate();
        sp = SP.getInstance(this);
        builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.icon_logo);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.icon_logo));
        builder.setContentTitle("毛毛抱我");
        builder.setContentText("开服监控中");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity
                (this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        startForeground(10, notification);

        soundPool = new SoundPool(1, AudioManager.STREAM_SYSTEM, 5);
        soundId = soundPool.load(ListeningServer.this, R.raw.alarm, 1);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        pattern = new long[]{100,400,100,400};

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            soundPool.stop(mPlay);
            soundPool.release();
        }
    }

    class MyBinder extends Binder{
        public void startListener(){
            bListen = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (bListen){
                        boolean b = ConnectUtil.checkConnect();
                        if (b){
                            if (sp.getBoolean("voice",false)){
                                mPlay = soundPool.play(soundId, 1, 1, 0, -1, 1);
                            }
                            if (sp.getBoolean("vibrate",false)){
                                vibrator.vibrate(pattern,0);
                            }
                        }
                        bListen = !b;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Log.d("@@@", "onCreate: server"+b);
                    }
                }
            }).start();
        }

        public void stopListener(){
            if (soundPool != null) {
                soundPool.stop(mPlay);
            }
            if (vibrator != null) {
                vibrator.cancel();
            }
        }
    }
}
