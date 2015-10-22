package au.com.knight_fighters.Level_3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import au.com.knight_fighters.Level_1.Level1background;
import au.com.knight_fighters.Main.GameMap;
import au.com.knight_fighters.Main.MainActivity;
import au.com.knight_fighters.R;
/* CREATED BY RAJAT THOMAS */
public class Level3 extends AppCompatActivity {

    private static MediaPlayer Background = MainActivity.getBackground_music();
    private static MediaPlayer level_music= Level1background.getLevel_music();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        RelativeLayout level3 = (RelativeLayout)findViewById(R.id.level3);

        level3.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {

                        handletouch(m);

                        return true;

                    }
                }
        );
    }





    public void handletouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }


    }
    public void CallNextActivity(){
        level_music.pause();
        Background.start();
        Background.seekTo(0);
                finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level3, menu);
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
