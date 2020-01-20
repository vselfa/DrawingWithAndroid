package selfa.v.drawingwithandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class MyBallActivity extends MainMenu {

    BallExampleView ballView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ballView = new BallExampleView(this);
        ballView.setBackgroundColor(Color.WHITE);
        setContentView(ballView);  // Our layout for this activity
    }

}