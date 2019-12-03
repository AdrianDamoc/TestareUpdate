package ro.bluebit.testupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    TextView versiune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        versiune=findViewById(R.id.versiune_id);
        AppUpdater appUpdater = new AppUpdater(this);
        appUpdater.setUpdateFrom(UpdateFrom.GITHUB);
        appUpdater.setGitHubUserAndRepo("AdrianDamoc", "TestareUpdate");
        appUpdater.setTitleOnUpdateAvailable("Update available");
        appUpdater.setDisplay(Display.NOTIFICATION);
        appUpdater.start();
    }
}
