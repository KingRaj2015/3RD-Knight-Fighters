package au.com.knight_fighters.Main;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import au.com.knight_fighters.R;
/* CREATED BY RAJAT THOMAS */
/*
* Purpose: to display the creator's and benefactors of the development of this application.
 */

public class CreditsActivity extends AppCompatActivity {
    private MediaPlayer Background = MainActivity.getBackground_music();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
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
    //goes back to main activity
    public void MainMenu(View v){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
        mp.start();
       finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_credits, menu);
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
