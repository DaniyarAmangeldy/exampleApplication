package method.exampleapplication.responseModels;

/**
 * Created by daniyaramangeldy on 19.06.17.
 */
/**
 * Внутри Json Images , мы имеем 3 размера, но нам пригодится только 1,
 * поэтому мы берем только standard_resolution. Внутри класса InstaImage есть ссылка на саму картинку.
 */

public class Images {


    private InstaImage standard_resolution;

    public InstaImage getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(InstaImage standard_resolution) {
        this.standard_resolution = standard_resolution;
    }
}
