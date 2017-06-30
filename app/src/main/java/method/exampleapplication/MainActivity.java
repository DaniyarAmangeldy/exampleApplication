package method.exampleapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import method.exampleapplication.responseModels.Images;
import method.exampleapplication.responseModels.InstaPost;
import method.exampleapplication.responseModels.InstaResponse;
import method.exampleapplication.responseModels.Location;
import method.exampleapplication.responseModels.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    ViewPager pager;
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        BottomNavigationAdapter adapter = new BottomNavigationAdapter(getSupportFragmentManager());
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("",R.drawable.ic_home_black_24dp);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("",R.drawable.ic_add_box_black_24dp);
        bottomNavigation.setAccentColor(R.color.colorPrimary);
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        pager.setAdapter(adapter);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                pager.setCurrentItem(position);
                return true;
            }
        });


    }




}
