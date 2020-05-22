package com.stornit.e_commerceapp.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stornit.e_commerceapp.Adapter.CategoryAdapter;
import com.stornit.e_commerceapp.R;
import com.stornit.e_commerceapp.models.Category;
import com.stornit.e_commerceapp.others.GridSpacingItemDecoration;
import com.stornit.e_commerceapp.singletonclass.MyApplication;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Retrofit;

import static android.widget.Toast.LENGTH_LONG;

public class HomeFragment extends Fragment {

    private CarouselView carouselView;
    private int[] carouselImage = {
            R.drawable.banner1, R.drawable.banner2, R.drawable.global, R.drawable.vagitable1, R.drawable.vagitable2,
    };
    private static final String TAG = HomeFragment.class.getSimpleName();
    private static final String URL = "api/categories";

    private Retrofit retrofit;
    private RecyclerView categoryRecyclerView;
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        carouselView = view.findViewById(R.id.homeFragmentCarouselView);
        carouselView.setPageCount(carouselImage.length);
        carouselView.setImageListener(imageListener);

        categoryRecyclerView = view.findViewById(R.id.homeFragCategoryRecyclerView);

        RecyclerView.LayoutManager categoryLayoutManger = new GridLayoutManager(this.getActivity(), 4);
        categoryRecyclerView.setLayoutManager(categoryLayoutManger);
        categoryRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(4), true));
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setNestedScrollingEnabled(false);

        return view;
    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(carouselImage[position]);
        }
    };

    private void fetchCategoryItems() {
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response == null) {
                    Toast.makeText(getActivity(), "Couldn't fetch the category Item", LENGTH_LONG).show();
                    return;
                }

                List<Category> categories = new Gson().fromJson(response.toString(), new TypeToken<List<Category>>() {
                }.getType());
                categoryList.clear();
                categoryList.addAll(categories);

                categoryAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        MyApplication.getInstance().addToRequestQueue(request);
    }

    private int dpToPx(int dp) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics()));
    }

}
