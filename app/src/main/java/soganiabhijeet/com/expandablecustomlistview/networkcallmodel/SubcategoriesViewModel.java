package soganiabhijeet.com.expandablecustomlistview.networkcallmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SubcategoriesViewModel {
    @SerializedName("Subcategories")
    private List<SubcategoryModel> subcategories;
    @SerializedName("SubSubcategories")
    private List<SubSubcategoryModel> subSubcategories;

    public SubcategoriesViewModel(List<SubcategoryModel> subcategories,
                                  List<SubSubcategoryModel> subSubcategories) {
        this.subcategories = subcategories;
        this.subSubcategories = subSubcategories;
    }

    public List<SubcategoryModel> getSubcategories() {
        return subcategories;
    }

    public List<SubSubcategoryModel> getSubSubcategories() {
        return subSubcategories;
    }

    @Override
    public String toString() {
        return "SubcategoriesViewModel{" +
                "subcategories=" + subcategories +
                ", subSubcategories=" + subSubcategories +
                '}';
    }
}
