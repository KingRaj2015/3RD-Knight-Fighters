package au.com.knight_fighters.Intro;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroMapActivity extends AppCompatActivity {

    private GLSurfaceView glSurface;
    private IntroMapRenderer mapRenderer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create new openGL surface view for manipulation of openGL contexts
        glSurface = new GLSurfaceView(this.getApplicationContext());

        mapRenderer = new IntroMapRenderer();
        glSurface.setRenderer(mapRenderer);

        // Set GL surface to current view
        this.setContentView(glSurface);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause openGL if user presses home button
        glSurface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resumes openGL if user returns to app.
        glSurface.onResume();
    }



    // Unlikely to be needed as this section caters for when the user presses the "menu" button on
    // their phone.
    /*
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
    */
}
