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
    private MediaPlayer Background = MainActivity.getBackground_music();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);
        //set the mediaplayer to start from the beginning
        Background.seekTo(0);
        //declaring a video view object that will store a video and play it when this method executes
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
    //when this screen is no longer the active screen, this method gets called
    @Override
    public void onPause() {
        super.onPause();
        position = myVideoView.getCurrentPosition();
        myVideoView.pause();

    }
    //when user returns to this screen making it active this method is invoked
    @Override
    public void onResume() {
        super.onResume();
        myVideoView.seekTo(position);
        myVideoView.start();

    }

    //onTouchEvent method called when user clicks the screen and calls a diffent method
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }

        return true;
    }
    //calls the MainActivity ending the GameMap and the initial instance of MainActivity
    public void CallNextActivity(){
        startActivity(new Intent(this, MainActivity.class));
        MainActivity.getInstance().finish();
        GameMap.getInstance().finish();
        finish();




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
