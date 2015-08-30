package au.com.knight_fighters.Intro;

import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by rdaykin on 26/08/2015.
 */

public class IntroMapRenderer implements Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrthof(0, width, 0, height, 1, -1);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    @Override
    public void onDrawFrame(GL10 gl) {

    }
}
