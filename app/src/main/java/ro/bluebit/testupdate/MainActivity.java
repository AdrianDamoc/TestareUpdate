package ro.bluebit.testupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.github.javiersantos.appupdater.objects.Update;

public class MainActivity extends AppCompatActivity {

    TextView versiune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        versiune=findViewById(R.id.versiune_id);
        UpdateVersiune();
    }

    public void UpdateVersiune(){
        AppUpdater appUpdater = new AppUpdater(this)
                .setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("AdrianDamoc", "TestareUpdate")
                .setTitleOnUpdateAvailable("Update available")
                .setDisplay(Display.NOTIFICATION);
        appUpdater.start();
    }
}
