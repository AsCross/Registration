package com.ascrossgams.myapplication.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticle;
import com.ascrossgams.myapplication.ui.fullArticle.FullArticleFragment;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    private List<RetroArticle> articleList;
    private Context context;
    private FragmentManager fragmentManager;
    private OnLoadMoreListener loadMoreListener;
    private int currentPage = 1;

    public NewsAdapter(List<RetroArticle> articleList, Context context, FragmentManager fragmentManager, OnLoadMoreListener onLoadMoreListener) {
        this.articleList = articleList;
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.loadMoreListener = onLoadMoreListener;
    }

    public void updateItemsList(List<RetroArticle> articleList) {
        if (this.articleList != null) {
            this.articleList.addAll(articleList);
        }
    }

    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);
        return new NewsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsAdapterViewHolder holder, final int position) {
        final RetroArticle currentArticle = articleList.get(position);
        holder.titleText.setText(currentArticle.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullArticleFragment fullArticleFragment = new FullArticleFragment(articleList, position);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fullArticleFragment);
                transaction.commit();

                Toast.makeText(holder.itemView.getContext(), "Go to article",
                        Toast.LENGTH_LONG).show();
            }
        });

        if (getItemCount() - position == 1) {
            currentPage++;
            loadMoreListener.loadMore(currentPage);
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;


        public NewsAdapterViewHolder(@NonNull final View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
        }
    }

    interface OnLoadMoreListener {

        void loadMore(int page);
    }
}