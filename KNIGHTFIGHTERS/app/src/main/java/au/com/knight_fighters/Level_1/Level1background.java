package au.com.knight_fighters.Level_1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import au.com.knight_fighters.Main.GameMap;
import au.com.knight_fighters.Main.MainActivity;
import au.com.knight_fighters.R;


/* CREATED BY RAJAT THOMAS */

public class Level1background extends AppCompatActivity {
    private VideoView myVideoView;
    private int position;
    private static MediaPlayer level_music;

    //get method for background music
    public static MediaPlayer getLevel_music(){

        return level_music;
    }
    //this method is called when this class is instantiated
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1background);

        //assigning a level background music to a media player object
        level_music = MediaPlayer.create(getApplicationContext(), R.raw.levels);
        level_music.start();
        level_music.setLooping(true);

        //assigning a videoview
        myVideoView = (VideoView)findViewById(R.id.videoView);
        myVideoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.level1);
        myVideoView.start();
        myVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            @Override
            public void onCompletion(MediaPlayer mp) {
                CallNextActivity();
            }
        });
        //setting the layout of this activity to be taken from activity_level1background
        RelativeLayout levelbg = (RelativeLayout)findViewById(R.id.levelbg);
        //set onTouchListener on the entire screen
        levelbg.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {

                        handletouch(m);

                        return true;

                    }
                }
        );

    }
    //when this screen is no longer the active screen, this method gets called
    @Override
    public void onPause() {
        super.onPause();
        position = myVideoView.getCurrentPosition();
        myVideoView.pause();
        level_music.pause();


    }
    //when user returns to this screen making it active this method is invoked
    @Override
    public void onResume() {
        super.onResume();
        myVideoView.seekTo(position);
        myVideoView.start();
        level_music.start();

    }
    //handletouch method called when user clicks the screen and calls a different method
    public void handletouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }


    }
    //calls the appropriate level that follows this story
    public void CallNextActivity(){
        startActivity(new Intent(this, Level1.class));
        level_music.seekTo(0);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level1background, menu);
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
