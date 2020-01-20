package selfa.v.drawingwithandroid;

import android.graphics.Color;
import android.os.Bundle;

public class MyCanvasActivity extends MainMenu {

    CanvasExampleView drawView;  // A new class extending from View

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new CanvasExampleView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);  // Our layout for this application
    }
}
