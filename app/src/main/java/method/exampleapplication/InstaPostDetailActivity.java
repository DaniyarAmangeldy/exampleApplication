package method.exampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstaPostDetailActivity extends AppCompatActivity {

    public static final String IMAGE = "image";
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insta_post_detail);
        ButterKnife.bind(this);
        String image = getIntent().getStringExtra(IMAGE);
        Picasso.with(getApplicationContext()).load(image).into(imageView);
        setResult(RESULT_CANCELED);
    }
}
