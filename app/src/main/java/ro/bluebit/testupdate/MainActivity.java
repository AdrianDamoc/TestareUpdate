package ro.bluebit.testupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUpdater appUpdater = new AppUpdater(this)
                .setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("AdrianDamoc", "TestareUpdate")
                .setTitleOnUpdateAvailable("Update available")
                .setDisplay(Display.NOTIFICATION);
        appUpdater.start();
    }
}
