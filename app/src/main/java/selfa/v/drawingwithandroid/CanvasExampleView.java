package selfa.v.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

public class CanvasExampleView extends View {
    private Drawable mIcon;
    private float mPosX, mPosY, mLastTouchX, mLastTouchY;

    public CanvasExampleView(Context context) {
        super(context);
        mIcon = context.getDrawable(R.drawable.icon);
        mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mPosX, mPosY);
        mIcon.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                // Remember where we started
                mLastTouchX = ev.getX(); 	        mLastTouchY = ev.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                // Calculate the distance moved
                final float dx = ev.getX() - mLastTouchX;
                final float dy = ev.getY() - mLastTouchY;
                // Remember this touch position for the next move event
                mLastTouchX = ev.getX(); 	        mLastTouchY = ev.getY();
                // Move the object
                mPosX += dx; 		        mPosY += dy;
                // Invalidate to request a redraw
                invalidate();
                break;
            }

        }
        return true;
    } // End of onTouchEvent
} // End of the class
