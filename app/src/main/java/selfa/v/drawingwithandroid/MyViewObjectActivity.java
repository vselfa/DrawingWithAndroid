package selfa.v.drawingwithandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyViewObjectActivity extends MainMenu {

   ImageView myImageView;
   View myBase;
   Integer maxHeight, maxWidth, offsetX, offsetY, step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_object);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200,200);
        myBase =  findViewById(R.id.myBase);
        myImageView = myBase.findViewById(R.id.myImageView);
        myImageView.setLayoutParams(layoutParams);
        maxHeight = myBase.getLayoutParams().height;
        maxWidth = myBase.getLayoutParams().width;
        offsetX = 10; offsetY = 10; // To control the borders
        step = 100;
        Log.d ("msg", "maxHeight = " + maxHeight );
        Log.d ("msg", "maxWidth = " + maxWidth );
    }

    public void moveLeft(View view) {
        if (offsetX > 10) { // Border left
            offsetX = offsetX - step;
            myImageView.offsetLeftAndRight(-step);
        }
    }
    public void moveRight(View view) {
        if (offsetX < maxWidth -100){  // Border right
            offsetX = offsetX + step;
            myImageView.offsetLeftAndRight(step);
        }
    }
    public void moveUp(View view) {
        if (offsetY > 10) { // Bordem up
            offsetY = offsetY - step;
            myImageView.offsetTopAndBottom(-step);
        }
    }
    public void moveDown(View view) {
        if (offsetY < maxHeight - 100) { // Border down
            offsetY = offsetY + step;
            myImageView.offsetTopAndBottom(step);
        }
    }
}

