package ro.bluebit.testupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.AppUpdaterUtils;
import com.github.javiersantos.appupdater.enums.AppUpdaterError;
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

        UpdateVers2();
        UpdateVersiune();
    }


    public void UpdateVers2(){
        AppUpdaterUtils appUpdaterUtils = new AppUpdaterUtils(this)
                .setUpdateFrom(UpdateFrom.XML)
                .setGitHubUserAndRepo("AdrianDamoc","TestareUpdate")
                .setUpdateXML("https://raw.githubusercontent.com/AdrianDamoc/TestareUpdate/master/app/update.xml")
                //...
                .withListener(new AppUpdaterUtils.UpdateListener() {
                    @Override
                    public void onSuccess(Update update, Boolean isUpdateAvailable) {
                        Log.d("Latest Version", update.getLatestVersion());
                        Log.d("Latest Version Code", String.valueOf(update.getLatestVersionCode()));
                        Log.d("URL", String.valueOf(update.getUrlToDownload()));
                    }

                    @Override
                    public void onFailed(AppUpdaterError error) {
                        Log.d("AppUpdater Error", "Something went wrong");
                    }
                });
        appUpdaterUtils.start();
    }
    public void UpdateVersiune(){
        AppUpdater appUpdater = new AppUpdater(this)
                .setUpdateFrom(UpdateFrom.XML)
                .setUpdateXML("https://raw.githubusercontent.com/AdrianDamoc/TestareUpdate/master/app/update.xml")
                .setTitleOnUpdateAvailable("Update available")
                .setDisplay(Display.NOTIFICATION);
        appUpdater.start();
    }
}
