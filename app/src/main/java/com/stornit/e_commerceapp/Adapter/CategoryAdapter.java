package com.stornit.e_commerceapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.stornit.e_commerceapp.R;
import com.stornit.e_commerceapp.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categoryList;
    private int rowLayout;

    public CategoryAdapter(Context context, int rowLayout, List<Category> categoryList) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        final Category category = categoryList.get(position);

        holder.categoryName.setText(category.getCategoryName());
        holder.categoryNameBangla.setText(category.getCategoryNameBangla());
        holder.description.setText(category.getDescription());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryName;
        public TextView categoryNameBangla;
        public TextView description;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryNameBangla = itemView.findViewById(R.id.categoryNameBangla);
            description = itemView.findViewById(R.id.description);
        }
    }
}
