package com.demo.verifyapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try
        {
            Bundle localBundle = getIntent().getExtras();
            if ((localBundle != null) && (localBundle.containsKey("class_name")) && (localBundle.containsKey("package_name")))
            {
                String str1 = localBundle.getString("class_name");
                String str2 = localBundle.getString("package_name");
                if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)))
                {
                    Intent localIntent = new Intent();
                    localIntent.setComponent(new ComponentName(str2, str1));
//                    localIntent.setComponent(new ComponentName("com.demo.homeapp", "com.demo.homeapp.ExportedActivity"));
                    localIntent.putExtra("serializable_key", new DataSchema());
                    startActivity(localIntent);
                }
            }
//            finish();
//            return;
        }
        catch (Exception localException)
        {
//            while (true)
                localException.printStackTrace();
        }
    }
}
