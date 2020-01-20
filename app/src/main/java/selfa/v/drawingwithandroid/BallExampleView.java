package selfa.v.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class BallExampleView extends View {
    private Drawable mIcon;
    private float mPosX, mPosY,mLastTouchX, mLastTouchY;
    int width, height ;
    int xDirection = 10, yDirection = 10, radius = 10;
    boolean even = false;  // Nombre parell de clics

    public BallExampleView(Context context) {
        super(context);
        mIcon = context.getDrawable(R.drawable.little_ball);
        mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = canvas.getWidth(); height = canvas.getHeight() ;
        canvas.translate(mPosX, mPosY);
        mIcon.draw(canvas);
        motion();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX(); 	        final float y = ev.getY();
                // Remember where we started
                mLastTouchX = x; mLastTouchY = y;
                if (even) {
                    xDirection = 10; yDirection = 10;
                    even =false;
                }
                else { // Stop the ball
                    xDirection = 0; yDirection = 0;
                    even = true;
                }
                Log.d("msg","ACTION_DOWN. Even = " + even + " " + mPosX + " " + mPosY );
                invalidate(); 	        break;
            }
            /*case MotionEvent.ACTION_MOVE: {
                final float x = ev.getX();        final float y = ev.getY();
                // Calculate the distance moved
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;
                // Move the object
                mPosX += dx; 		        mPosY += dy;
                // Remember this touch position for the next move event
                mLastTouchX = x; 	        mLastTouchY = y;
                // Invalidate to request a redraw
                invalidate(); 	        break;
            }*/
        }
        return true;
    }

    public void motion () {
        // The new position
        mPosX += xDirection;    mPosY += yDirection;
        // Controling the bounds of the canvas
        if ((mPosX + radius > width)  || (mPosX - radius < 0) ) xDirection = -xDirection;
        if ((mPosY + radius > height) || (mPosY - radius  < 0) ) yDirection = -yDirection;
        invalidate(); // To redraw the ball
    }


} // End of the class
