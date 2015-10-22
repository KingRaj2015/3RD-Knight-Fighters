package au.com.knight_fighters.Main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
    private static MediaPlayer Background = MainActivity.getBackground_music();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gamemap = this;
         setContentView(R.layout.activity_game_map);




    }
     public static GameMap getInstance(){
        return gamemap;
    }

    public void Options(View v){
        Dialog dialog = new Dialog(GameMap.this);
        dialog.setTitle("OPTIONS");
        dialog.setContentView(R.layout.options);
        dialog.show();


    }

    public void Level1(View v){

        startActivity(new Intent(this, Level1background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.pause();
    }
    public void Level2(View v){

        startActivity(new Intent(this, Level2background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.pause();
    }
    public void Level3(View v){

        startActivity(new Intent(this, Level3background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.pause();
    }
    public void Level4(View v){

        startActivity(new Intent(this, Level4background.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        Background.pause();
    }
    public void Menu(View v){


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
