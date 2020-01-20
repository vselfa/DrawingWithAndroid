package selfa.v.drawingwithandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();         selectOption (id);        return true;
    }

    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        selectOption (id);
        return true;
    }

    public void selectOption (int id) {
        Intent intent=null;
        if (id == R.id.home) {
            intent = new Intent (this, MainActivity.class);
        }
        if (id == R.id.myViewObject) {
            intent = new Intent (this, MyViewObjectActivity.class);
        }
        if (id == R.id.myCanvas) {
            intent = new Intent (this, MyCanvasActivity.class);
        }
        if (id == R.id.myBall) {
            intent = new Intent (this, MyBallActivity.class);
        }
        if (id == R.id.myBallAndPalette) {
            intent = new Intent (this, MyBallAndPaletteActivity.class);
        }
        startActivity(intent); //Starting the new activity

    }
}
