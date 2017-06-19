package method.exampleapplication;

/**
 * Created by daniyaramangeldy on 19.06.17.
 */

public class User {
    private long id;
    private String username;
    private String profile_picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }
}
