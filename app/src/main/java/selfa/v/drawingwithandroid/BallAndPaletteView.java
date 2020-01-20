package selfa.v.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class BallAndPaletteView extends View {

    // Painting a ball
    Paint ball = new Paint();
    private int x, y; // The center of the ball
    private static int radius = 40;  // The radius
    // Painting a palette
    Paint paleta = new Paint();
    Paint background = new Paint();
    private float xPaleta = 100, yPaleta;
    private float ample = 200; private float alt = 30;
    private float ultimaXPaleta,  ultimaYPaleta;
    private int width, height ;
    private int xDirection = 10, yDirection = 10;

    public BallAndPaletteView(Context context) {
        super(context);
    }

    @Override
    public void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        width = canvas.getWidth() ; height = canvas.getHeight();
        yPaleta = height - radius; // Near of the bottom  of the screen
        background.setColor(Color.WHITE);   // The background of the canvas
        ball.setColor(Color.RED);  // The ball
        paleta.setColor(Color.BLUE); // The palette
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);
        canvas.drawCircle(x, y, radius, ball);    // The ball
        canvas.drawRect(xPaleta, yPaleta, xPaleta + ample, yPaleta + alt, paleta);
        motion();
    }


    @Override
    public boolean onTouchEvent (MotionEvent ev) {
        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                ultimaXPaleta = ev.getX();   ultimaYPaleta = ev.getY();   break;
            }
            case MotionEvent.ACTION_MOVE: {
                // Calculate the distance moved
                final float dx = ev.getX() - ultimaXPaleta;
                final float dy = ev.getY() - ultimaYPaleta;
                xPaleta += dx; // Move the palette. Only in horizontal!
                // Remember this touch position for the next move event
                ultimaXPaleta = ev.getX();    ultimaYPaleta = ev.getY();
                // Invalidate to request a redraw
                invalidate();     break;
            }
        }
        return true;
    } // End of onTouchEvent


    public void motion () {
        // Controlling the bounds
        if ((x + radius > width)  || (x < 0) ) xDirection = -xDirection;
        if ((y + radius > height) || (y < 0) ) yDirection = -yDirection;
        if (y  + radius > yPaleta ) { // Controlling the palette
            if ((x + radius > xPaleta) && (x - radius < xPaleta + ample)) {
                yDirection = -yDirection;
            }
        }
        // New movement
        x += xDirection;    y += yDirection;
        invalidate();  // Call to onDraw to repaint the canvas
    }

}
