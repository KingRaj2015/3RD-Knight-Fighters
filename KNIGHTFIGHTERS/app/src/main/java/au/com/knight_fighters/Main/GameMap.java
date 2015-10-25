package au.com.knight_fighters.Main;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import au.com.knight_fighters.R;
import au.com.knight_fighters.Level_1.Level1background;
import au.com.knight_fighters.Level_2.Level2background;
import au.com.knight_fighters.Level_3.Level3background;
import au.com.knight_fighters.Level_4.Level4background;
/* CREATED BY RAJAT THOMAS */
/*
* Activity to be displayed after the StoryIntroActivity and before each new level.
* Purpose: to provide an overview map of where the knight avatar's activities will take him. Each
* button leads to a corresponding level, and will be unlocked only when the previous level has been
* completed.
 */

public class GameMap extends AppCompatActivity {
    public static GameMap gamemap;
    private MediaPlayer Background = MainActivity.getBackground_music();
    private Dialog dialog;
    private Button mainbutton, cancelbutton, level1, level2, level3, level4;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gamemap = this;
         setContentView(R.layout.activity_game_map);
        Toast toast =Toast.makeText(getApplicationContext(),"UNLOCK EACH LEVEL TO GET TO THE FINAL BATTLE", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();

        this.findViewById(R.id.level2).setAlpha(.2f);
        this.findViewById(R.id.level3).setAlpha(.2f);
        this.findViewById(R.id.level4).setAlpha(.2f);




    }
    @Override
    public void onPause (){
        super.onPause();
        Background.pause();


    }
    @Override
    public void onResume (){
        super.onResume();
        Background.start();


    }
     public static GameMap getInstance(){
        return gamemap;
    }

    public void Options(View v){
        dialog = new Dialog(GameMap.this);
        dialog.setTitle("OPTIONS");
        dialog.setContentView(R.layout.options);
        dialog.show();

        mainbutton = (Button)dialog.findViewById(R.id.options_main);
        cancelbutton = (Button)dialog.findViewById(R.id.options_cancel);

        buttonmain_action();
        buttoncancel_action();



    }
    public void buttonmain_action(){
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
                mp.start();
                finish();
            }

        });

    }
    public void buttoncancel_action(){
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
                mp.start();
                dialog.cancel();
            }

        });
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void Level2_enable(){
        this.findViewById(R.id.level2).setEnabled(true);
        this.findViewById(R.id.level2).setAlpha(1f);


    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void Level3_enable(){
        this.findViewById(R.id.level3).setEnabled(true);
        this.findViewById(R.id.level3).setAlpha(1f);

    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void Level4_enable(){
        this.findViewById(R.id.level4).setEnabled(true);
        this.findViewById(R.id.level4).setAlpha(1f);




    }


    public void Level1(View v){

        startActivity(new Intent(this, Level1background.class));
       backgroudmusic();
    }
    public void Level2(View v){

        startActivity(new Intent(this, Level2background.class));
        backgroudmusic();
    }
    public void Level3(View v){

        startActivity(new Intent(this, Level3background.class));
       backgroudmusic();
    }
    public void Level4(View v){

        startActivity(new Intent(this, Level4background.class));
        backgroudmusic();
    }
    public void backgroudmusic(){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.pause();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_map, menu);
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
