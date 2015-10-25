package au.com.knight_fighters.Level_1;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import au.com.knight_fighters.Level_2.Level2;
import au.com.knight_fighters.Main.GameMap;
import au.com.knight_fighters.R;

import au.com.knight_fighters.Main.MainActivity;

/* CREATED BY RAJAT THOMAS */

public class Level1 extends AppCompatActivity {

    private GLSurfaceView glSurface;
    private Level1_Renderer renderer;
    private MediaPlayer Background = MainActivity.getBackground_music();
    private MediaPlayer level_music= Level1background.getLevel_music();
    private Dialog dialog;
    private Button mainbutton, gamemapbutton, resumebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        RelativeLayout level1 = (RelativeLayout) findViewById(R.id.level1);

        level1.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent m) {

                        handletouch(m);

                        return true;

                    }
                }
        );
    }
    @Override
    public void onPause (){
        super.onPause();
        level_music.pause();


    }
    @Override
    public void onResume (){
        super.onResume();
        level_music.start();


    }

    public void Pause(View v){
        dialog = new Dialog(Level1.this);
        dialog.setTitle("OPTIONS");
        dialog.setContentView(R.layout.level_options);
        dialog.show();

        mainbutton = (Button)dialog.findViewById(R.id.options_main);
        gamemapbutton = (Button)dialog.findViewById(R.id.options_level);
        resumebutton = (Button)dialog.findViewById(R.id.options_cancel);

        buttonmain_action();
        buttongamemap_action();
        buttonresume_action();



    }
    public void buttonmain_action(){
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.button);
                mp.start();
                GameMap.getInstance().finish();
                CallNextActivity();
            }

        });

    }
    public void buttongamemap_action(){
        gamemapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
                mp.start();
                CallNextActivity();

            }

        });
    }
    public void buttonresume_action(){
        resumebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.button);
                mp.start();
                dialog.cancel();
            }

        });

    }

        //glSurface = new GLSurfaceView(getApplicationContext());
        //renderer = new Level1_Renderer();
        //glSurface.setRenderer(renderer);
        //setContentView(glSurface);


    public void handletouch(MotionEvent m){
        if(m.getActionMasked() == MotionEvent.ACTION_DOWN){
            CallNextActivity();

        }


    }
    public void CallNextActivity(){
                GameMap.getInstance().Level2_enable();

                Background.seekTo(0);
                finish();

    }

   /* @Override
    protected void onPause() {
        super.onPause();
        glSurface.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        glSurface.onResume();
    }



*/








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_level1, menu);
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
