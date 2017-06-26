package method.exampleapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import method.exampleapplication.responseModels.InstaPost;
import method.exampleapplication.responseModels.Location;

/**
 * Created by daniyaramangeldy on 23.06.17.
 */

public class instaAdapter extends RecyclerView.Adapter<instaAdapter.instaViewHolder> {

    List<InstaPost> instaPostList;
    Context context;

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

    public void setContext(Context context){
        this.context = context;
    }






    class instaViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.user_image) ImageView userImage;
        @BindView(R.id.user_location) TextView userLocation;
        @BindView(R.id.user_name) TextView userName;
        @BindView(R.id.insta_like_count) TextView instaLikeCount;
        @BindView(R.id.insta_image) ImageView instaImage;


        public instaViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }

        @OnCheckedChanged(R.id.insta_like_btn)
        public void toggleLike(CompoundButton v, boolean checked){
            Toast.makeText(itemView.getContext(), checked ? ":)" : ":(", Toast.LENGTH_SHORT).show();
        }

        @OnClick(R.id.user_location)
        public void goToLocation(){
            Location location = instaPostList.get(getAdapterPosition()).getLocation();
            Intent intent = new Intent(
                    Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+location.getLatitude()+","+location.getLongitude())
            );
            ((Activity) context).startActivity(intent);
        }

        @OnClick(R.id.insta_image)
        public void showDetail(){
            Intent intent = new Intent(itemView.getContext(),InstaPostDetailActivity.class);
            intent.putExtra("image",instaPostList
                    .get(getAdapterPosition())
                    .getImages()
                    .getStandard_resolution()
                    .getUrl());
            ((Activity) context).startActivityForResult(intent, 1);
        }



        public void bind(InstaPost post){
            userName.setText(post.getUser().getUsername());
            instaLikeCount.setText(itemView.getContext().getString(R.string.likes_count,post.getLikes().getCount()));

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
