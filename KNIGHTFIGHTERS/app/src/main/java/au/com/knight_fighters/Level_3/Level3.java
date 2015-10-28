package au.com.knight_fighters.Level_3;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import au.com.knight_fighters.Level_1.Level1background;
import au.com.knight_fighters.Main.GameMap;
import au.com.knight_fighters.Main.MainActivity;
import au.com.knight_fighters.R;
/* CREATED BY RAJAT THOMAS */
public class Level3 extends AppCompatActivity {

    private MediaPlayer Background = MainActivity.getBackground_music();
    private MediaPlayer level_music= Level1background.getLevel_music();
    private Dialog dialog;
    private Button mainbutton, gamemapbutton, resumebutton;

    //method gets call when this class is instantiated
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout of this activity as defned in activity_level3 XML file
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
    //when this screen is no longer the active screen, this method gets called
    @Override
    public void onPause (){
        super.onPause();
        level_music.pause();


    }
    //when user returns to this screen making it active this method is invoked
    @Override
    public void onResume (){
        super.onResume();
        level_music.start();


    }
    //When the Options button is clicked , executes the following method.
    public void Pause(View v){
        dialog = new Dialog(Level3.this);
        dialog.setTitle("OPTIONS");
        //uses an XML file level_options to design the layout of the dialog
        dialog.setContentView(R.layout.level_options);
        dialog.show();

        //define button objects for menu within the dialog
        mainbutton = (Button)dialog.findViewById(R.id.options_main);
        gamemapbutton = (Button)dialog.findViewById(R.id.options_level);
        resumebutton = (Button)dialog.findViewById(R.id.options_cancel);

        //call action methods for respective buttons
        buttonmain_action();
        buttongamemap_action();
        buttonresume_action();

    }
    //calls the MainActivity class removing itself and the Game Map class
    public void buttonmain_action(){
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
                mp.start();
                GameMap.getInstance().finish();
                Background.seekTo(0);
                finish();
            }

        });

    }
    //finishes this class so that user can return to gamemap
    public void buttongamemap_action(){
        gamemapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
                mp.start();
                Background.seekTo(0);
                finish();

            }

        });
    }
    //when the user wants to resume the game they click this button
    public void buttonresume_action(){
        resumebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
                mp.start();
                dialog.cancel();
            }

        });

    }
    //handletouch method called when user clicks the screen and calls a diffent method
    public void handletouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }
    }
    //calls Game map activity and enables next activity
    public void CallNextActivity(){
        GameMap.getInstance().Level4_enable();

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
