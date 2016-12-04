package soganiabhijeet.com.expandablecustomlistview;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import soganiabhijeet.com.expandablecustomlistview.networkcallmodel.SubcategoriesViewModel;


public interface CategorySelectionApiInterface {


    @GET("Your API's endpoint")
    Call<SubcategoriesViewModel> getSubcategoriesAndSubSubcategories();

}
