package it.dekz.appshortcut;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buat list untuk menampung shortcut
        List<ShortcutInfo> shortcutInfos = new ArrayList<>();

        //cek jika os menggunakan API 25
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            //inisiasi ShortcutManager
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

            //membuat object shortcutInfo
            ShortcutInfo shortcutInfo = new ShortcutInfo.Builder(this, "web_shortcut")
                    .setShortLabel("dekzitfz.github.io")
                    .setLongLabel("Visit dekzitfz github pages")
                    .setIcon(Icon.createWithResource(this, R.drawable.ic_web))
                    .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://dekzitfz.github.io/")))
                    .build();

            ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(this, "shortcut_dinamis")
                    .setShortLabel("Dinamis")
                    .setLongLabel("buka shortcut dinamis")
                    .setIcon(Icon.createWithResource(this, R.drawable.ic_today))
                    .setIntents(
                            new Intent[]{
                                    new Intent(Intent.ACTION_MAIN, Uri.EMPTY, this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                                    new Intent(Intent.ACTION_VIEW, Uri.EMPTY, this, Activity3.class)
                            })
                    .build();

            //tambahkan objeck ke dalam list
            shortcutInfos.add(shortcutInfo);
            shortcutInfos.add(dynamicShortcut);

            //set shortcut dinamis
            shortcutManager.setDynamicShortcuts(shortcutInfos);
        }

    }
}
