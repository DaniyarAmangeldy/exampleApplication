package method.exampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private InstaResponse instaResponse;

    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.insta_image)
    ImageView instaImage;
    @BindView(R.id.user_image)
    ImageView userImage;
    @BindView(R.id.user_location)
    TextView userLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        final Gson gson = new Gson();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("https://api.instagram.com/v1/users/275855784/media/recent/?access_token=275855784.1677ed0.4da1ffa33669461d819cf0ae595fc537")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string(); // "{asdasdk...}"
                instaResponse = gson.fromJson(responseString,InstaResponse.class);
                fillPost(instaResponse);
            }
        });

    }

    private void fillPost(final InstaResponse response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                InstaPost post = response.getData().get(0);
                User user = post.getUser();
                Location location = post.getLocation();
                Images image = post.getImages();
                userName.setText(user.getUsername());
                userLocation.setText(location.getName());
                Picasso.with(MainActivity.this).load(image.getStandard_resolution().getUrl()).into(instaImage);
            }
        });

    }




}
