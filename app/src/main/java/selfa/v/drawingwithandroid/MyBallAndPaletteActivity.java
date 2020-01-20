package selfa.v.drawingwithandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MyBallAndPaletteActivity extends MainMenu {

    BallAndPaletteView ballAndPaletteView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ballAndPaletteView = new BallAndPaletteView(this);
        ballAndPaletteView.setBackgroundColor(Color.WHITE);
        setContentView(ballAndPaletteView);  // Our layout for this activity
    }
}
