package method.exampleapplication.responseModels;

import java.util.List;

import method.exampleapplication.responseModels.InstaPost;

/**
 * Created by daniyaramangeldy on 20.06.17.
 */

/**
 * Внутри Json мы имеем папки pagination , data , meta. Так
 * как нам необходимо только data, мы создаем список из инста постов. Теперь, зайдите
 * на InstaPost класс
 */

public class InstaResponse {

    private List<InstaPost> data;

    public List<InstaPost> getData() {
        return data;
    }

    public void setData(List<InstaPost> data) {
        this.data = data;
    }
}
