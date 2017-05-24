package ma.com.ma.activities;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ma.com.ma.models.ConfigActivity;
import ma.com.ma.R;

import ma.com.ma.business.MyTabStatePagerAdapter;
import ma.com.ma.fragments.FirstTab;
import ma.com.ma.fragments.SecondTab;

public class UserActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private static final int PERMISSIONS_REQUEST = 100;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        // Vinculamos el Tablayout con el ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);

        // Añadimos un layout Adapter al ViewPager
        MyTabStatePagerAdapter adapter = new MyTabStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstTab(), "News");
        adapter.addFragment(new SecondTab(), "Emergency phones");
        viewPager.setAdapter(adapter);



        // Check permission (Api 22 check in Manifest, Api 23 check by requestPermissions)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Dont have permission => request one or many permissions (String[])
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            // Have permission
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                Intent i = new Intent(this, ConfigActivity.class);
                this.startActivity(i);
                return true;
            case R.id.maps:
                Intent inn = new Intent(this, MapsActivity.class);
                this.startActivity(inn);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
