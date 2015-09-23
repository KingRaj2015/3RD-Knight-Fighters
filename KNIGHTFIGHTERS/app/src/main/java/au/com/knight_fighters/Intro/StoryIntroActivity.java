package au.com.knight_fighters.Intro;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.VideoView;

import au.com.knight_fighters.Main.GameMap;
import au.com.knight_fighters.R;

/*
* Purpose: This activity will show the introductory storyline animation in a pre-rendered form.
* This will be used when the user chooses to begin a new game.
 */

public class StoryIntroActivity extends AppCompatActivity {
private VideoView myVideoView;
    private int position;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_back_ground);

        myVideoView = (VideoView)findViewById(R.id.videoView);
        myVideoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.intro);
        myVideoView.start();
        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                CallNextActivity();
            }
        });

        RelativeLayout gamebg = (RelativeLayout)findViewById(R.id.gamebg);

        gamebg.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {
                        handleTouch(m);


                        return true;

                    }
                }
        );



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


    public void handleTouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }



    }
    public void CallNextActivity(){
        startActivity(new Intent(this, GameMap.class));
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_back_ground, menu);
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
