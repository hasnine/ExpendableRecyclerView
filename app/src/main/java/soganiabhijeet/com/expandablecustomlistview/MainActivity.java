package soganiabhijeet.com.expandablecustomlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import soganiabhijeet.com.expandablecustomlistview.model.BaseListModel;
import soganiabhijeet.com.expandablecustomlistview.model.CategoriesModel;
import soganiabhijeet.com.expandablecustomlistview.model.TitleModel;
import soganiabhijeet.com.expandablecustomlistview.networkcallmodel.SubSubcategoryModel;
import soganiabhijeet.com.expandablecustomlistview.networkcallmodel.SubcategoriesViewModel;
import soganiabhijeet.com.expandablecustomlistview.networkcallmodel.SubcategoryModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private ArrayList<BaseListModel> listModels;
    private CategorySelectionApiInterface categorySelectionApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        listModels = new ArrayList<>();
        adapter = new ListAdapter(this, listModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();

        networkCall();




    }

    private void networkCall() {

        Retrofit retrofit = RetrofitSingleton.getInstance(getApplicationContext());
        categorySelectionApiInterface = retrofit.create(CategorySelectionApiInterface.class);
        final Call<SubcategoriesViewModel> myCall = categorySelectionApiInterface
                .getSubcategoriesAndSubSubcategories(6);

        myCall.enqueue(new Callback<SubcategoriesViewModel>() {
            @Override
            public void onResponse(Call<SubcategoriesViewModel> call, Response<SubcategoriesViewModel> response) {


                if (response.isSuccessful()){

                    List<CategoriesModel> subSubcategoryNames = new ArrayList<>();
                    List<SubcategoryModel> subCategories = response.body().getSubcategories();


                    if (subCategories != null) {
                        // mProgressBar.setVisibility(View.GONE);
                        int i = 0;
                        for (SubcategoryModel subcategory : subCategories) {

                            TitleModel recyclerViewHeadModel = new TitleModel();
                            recyclerViewHeadModel.name = subcategory.getSubCategoryName();
                           /* String imageLink = "http://cdn.ajkerdeal.com/images/AppImages/SubCategoriesIcon/" + singleCategoryId + "/" + i++ + ".png";
                            recyclerViewHeadModel.image = imageLink;
                            Log.e("imageLink", imageLink);*/


                      /*      recyclerViewHeadModel.subCategoryId = subcategory.getSubCategoryId();
                            recyclerViewHeadModel.categoryIdfortab = subcategory.getCategoryId();
*/

                            List<SubSubcategoryModel> SubSubcategories = response.body().getSubSubcategories();


                            Log.d("Just Play", String.valueOf(SubSubcategories));
                            recyclerViewHeadModel.children = new ArrayList<>();


                            for (SubSubcategoryModel subSubcategory : SubSubcategories) {
                                if (subSubcategory.getSubCategoryId() == subcategory.getSubCategoryId()) {

                                    subSubcategoryNames.add(new CategoriesModel(subSubcategory.getSubSubCategoryName(),
                                          "22"));
                                }


                            }

                            recyclerViewHeadModel.children.addAll(subSubcategoryNames);
                            subSubcategoryNames.clear();

                            recyclerViewHeadModel.isCurrentlyOpen = false;
                            recyclerViewHeadModel.viewType = ListAdapter.HEADER;
                            listModels.add(recyclerViewHeadModel);

                        }


                    }

//                    mAdapter.notifyDataSetChanged();
                    //dismissLoader();





                }

            }

            @Override
            public void onFailure(Call<SubcategoriesViewModel> call, Throwable t) {

               /* networkNotFound.setVisibility(View.VISIBLE);

                mProgressBar.setVisibility(View.GONE);*/
                /*if (getView() != null) {


                    snackbar = Snackbar
                            .make(getView(), "Connect to your network", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                             *//*   Snackbar snackbar1 = Snackbar.make(getView(), "Message is restored!", Snackbar.LENGTH_INDEFINITE);
                                snackbar1.show();*//*
                                    getAllNetworkData();

                                }
                            });


                    snackbar.setActionTextColor(Color.RED);

                    // Changing action button text color
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);

                    snackbar.show();


                }*/


            }
        });


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
