package au.com.knight_fighters.Main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;
import android.util.DisplayMetrics;

import au.com.knight_fighters.R;
import au.com.knight_fighters.Intro.StoryIntroActivity;

/* CREATED BY RAJAT THOMAS */
/*
* Purpose: This class is the main menu activity for the app.
* It has buttons to launch a new game (view intro story), resume an existing game, change settings,
* view the credits and exit the game.
*/

public class MainActivity extends AppCompatActivity {

    public static Context appContext;
    public static float scrWidth;
    public static float scrHeight;
    private static MainActivity main;
    private static MediaPlayer Background;

    //getter for background music
    public static MediaPlayer getBackground_music (){
        return Background;
    }

    //method gets call when this class is instantiated
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout of this activity as defned in activity_mainmenu XML file
        setContentView(R.layout.activity_main_menu);
        main = this;
        Background = MediaPlayer.create(getApplicationContext(), R.raw.background);
        Background.start();
        Background.setLooping(true);

    }
    //when this screen is no longer the active screen, this method gets called
    @Override
    public void onPause (){
        super.onPause();
        Background.pause();


    }
    //when user returns to this screen making it active this method is invoked
    @Override
    public void onResume (){
        super.onResume();
        Background.start();


    }
    //getter for object of this class
    public static MainActivity getInstance (){
        Background.pause();
         return main;
    }
    //when new game is clicked
    public void btn_New(View v){

         startActivity(new Intent(this, StoryIntroActivity.class));
        backgroudmusic();

    }
    //when help button is clicked
    public void help(View v){

        startActivity(new Intent(this, Help.class));
        backgroudmusic();

    }
    //when credit button is clicked
    public void Credits(View v){

        startActivity(new Intent(this,CreditsActivity.class));
        backgroudmusic();
    }
    //when exit button is clicked
    public void exit(View v){
        backgroudmusic();
        //instantiating a new alert dialog
        AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
        message.setTitle("             Are you sure you want to exit?");
        message.setCancelable(true);
        //action when user clicks NO
        message.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }

        );
        //action when user click Yes
        message.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Background.stop();
                        System.exit(0);
                        finish();

                    }

                }

        );

        message.create();
        message.show();


    }
    //creates a new mediaplayer object assigned to each button
    public void backgroudmusic(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.seekTo(0);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
