package method.exampleapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import method.exampleapplication.responseModels.InstaPost;

/**
 * Created by daniyaramangeldy on 23.06.17.
 */

public class instaAdapter extends RecyclerView.Adapter<instaAdapter.instaViewHolder> {

    List<InstaPost> instaPostList;

    @Override
    public instaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_insta_post,parent,false);
        return new instaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(instaViewHolder holder, int position) {
        holder.bind(instaPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return instaPostList.size();
    }

    public void setInstaList(List<InstaPost> instaPostList){
        this.instaPostList = instaPostList;
    }

    class instaViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.user_image) ImageView userImage;
        @BindView(R.id.user_location) TextView userLocation;
        @BindView(R.id.user_name) TextView userName;
        @BindView(R.id.insta_image) ImageView instaImage;


        public instaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnCheckedChanged(R.id.insta_like_btn)
        public void toggleLike(View v, boolean checked){
            Toast.makeText(itemView.getContext(), checked ? ":)" : ":(", Toast.LENGTH_SHORT).show();
        }

        public void bind(InstaPost post){
            userName.setText(post.getUser().getUsername());
            if(post.getLocation()!=null) {
                userLocation.setText(post.getLocation().getName());
            }
            Picasso
                    .with(itemView.getContext())
                    .load(post.getImages().getStandard_resolution().getUrl())
                    .into(instaImage);
            Picasso
                    .with(itemView.getContext())
                    .load(post.getUser().getProfile_picture())
                    .into(userImage);

        }

    }
}
