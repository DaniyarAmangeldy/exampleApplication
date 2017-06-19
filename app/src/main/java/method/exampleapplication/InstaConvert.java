package method.exampleapplication;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by daniyaramangeldy on 19.06.17.
 */

public class InstaConvert implements JsonDeserializer<InstaPost> {
    @Override
    public InstaPost deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        InstaPost post = new InstaPost();
        JsonObject object = json.getAsJsonObject();
        post.setId(object.get("id").getAsString());
        post.setImage(object.get("images").getAsJsonObject().get("standard_resolution")
        .getAsJsonObject().get("url").getAsString());
        User user = new User();
        user.setId(object.get("user").getAsJsonObject().get("id").getAsLong());
        user.setProfile_picture(object.get("user").getAsJsonObject().get("profile_picture").getAsString());
        user.setUsername(object.get("user").getAsJsonObject().get("username").getAsString());
        post.setUser(user);
        return post;
    }
}
