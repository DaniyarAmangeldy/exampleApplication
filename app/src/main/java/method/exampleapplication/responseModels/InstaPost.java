package method.exampleapplication.responseModels;

/**
 * Created by daniyaramangeldy on 19.06.17.
 */


/**
 * Наша data состоит из 20 постов, InstaPost, описывает 1 пост
 * внутри поста есть id, User, Images(Почему images, потому что внутри есть 3 размера thumbnail и т д)
 * Зайдите либо в user , либо в Images
 */
public class InstaPost {
    private String id;
    private User user;
    private Images images;
    private long created_time;
    private Location location;
    private Likes likes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public long getCreated_time() {
        return created_time;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }
}
