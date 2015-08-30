package au.com.knight_fighters.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import au.com.knight_fighters.R;
import au.com.knight_fighters.Intro.StoryIntroActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void NewButton(View v){

         startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
         mp.start();
    }
    public void resume(View v){

        //startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
    }
    public void settings(View v){

        //startActivity(new Intent(this, StoryIntroActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
    }

    public void Credits(View v){

        startActivity(new Intent(this,CreditsActivity.class));
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
    }
    public void exit(View v){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
        AlertDialog.Builder message = new AlertDialog.Builder(MainActivity.this);
        message.setTitle("             Are you sure you want to exit?");
        message.setCancelable(true);
        message.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }

                }

        );
        message.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }

                }

        );

        message.create();
        message.show();


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