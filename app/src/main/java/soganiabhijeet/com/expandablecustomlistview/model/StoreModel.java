package soganiabhijeet.com.expandablecustomlistview.model;

import android.graphics.drawable.Drawable;


public class StoreModel extends BaseListModel {


    public Drawable image;
    public String storeDescription;
    public String name;


    public StoreModel(Drawable image, String storeDescription, String name) {
        this.image = image;
        this.storeDescription = storeDescription;
        this.name = name;
    }
}
