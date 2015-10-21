package au.com.knight_fighters.Main;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.VideoView;
import au.com.knight_fighters.R;

public class Conclusion extends AppCompatActivity {
    private VideoView myVideoView;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);


        myVideoView = (VideoView)findViewById(R.id.videoView_conc);
        myVideoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.conclusion);
        myVideoView.start();
        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                CallNextActivity();
            }
        });

    }
    @Override
    public void onPause() {
        super.onPause();
        position = myVideoView.getCurrentPosition();
        myVideoView.pause();

    }

    @Override
    public void onResume() {
        super.onResume();
        myVideoView.seekTo(position);
        myVideoView.start();

    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }

        return true;
    }

    public void CallNextActivity(){
        startActivity(new Intent(this, MainActivity.class));
        MainActivity.finishActivity().finish();
        GameMap.finishActivity().finish();
        finish();
       // ( (Activity)"au.com.knight_fighters.Intro.IntroMapActivity").finish());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conclusion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}