package au.com.knight_fighters.Level_1;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import au.com.knight_fighters.R;

import au.com.knight_fighters.Main.MainActivity;

public class Level1 extends AppCompatActivity {

    private GLSurfaceView glSurface;
    private Level1_Renderer renderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        

        glSurface = new GLSurfaceView(getApplicationContext());
        renderer = new Level1_Renderer();
        glSurface.setRenderer(renderer);
        setContentView(glSurface);

    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurface.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        glSurface.onResume();
    }












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
