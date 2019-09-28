package com.ascrossgams.myapplication.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticle;
import com.dinuscxj.refresh.RecyclerRefreshLayout;

import java.util.List;

public class NewsFragment extends Fragment {
    private NewsViewModel newsViewModel;
    private RecyclerView  recyclerView;
    private RecyclerRefreshLayout recyclerRefreshLayout;
    PreferencesDataSource mPrefs;


    public String getAllSources() {
        return mPrefs.getStringValue("KEY_SOURCES", "abcnews.go.com,abc.net.au,aftenposten.no,aljazeera.com,ansa.it");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_news, container, false);
        mPrefs = new PreferencesDataSource(getContext());
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerRefreshLayout = root.findViewById(R.id.refresh_layout);
        refreshNewsFragment();

        newsViewModel.getArticlesLiveData().observe(this, new Observer<List<RetroArticle>>() {
            @Override
            public void onChanged(@Nullable List<RetroArticle> articles) {

                if (recyclerView.getAdapter() == null) {

                    NewsAdapter.OnLoadMoreListener loadMoreListener = new NewsAdapter.OnLoadMoreListener() {
                        @Override
                        public void loadMore(int page) {
                            newsViewModel.loadArticles(page, getAllSources());
                        }
                    };

                    recyclerView.setAdapter(new NewsAdapter(articles, getContext(), getFragmentManager(), loadMoreListener));
                } else {
                    ((NewsAdapter) recyclerView.getAdapter()).updateItemsList(articles);
                    recyclerView.getAdapter().notifyDataSetChanged();

                }
            }
        });

        newsViewModel.getErrorsLiveData().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        newsViewModel.loadArticles(1, getAllSources());

        return root;
    }

    public void refreshNewsFragment() {

            recyclerRefreshLayout.setOnRefreshListener(new RecyclerRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    recyclerRefreshLayout.setAnimateToRefreshDuration(2000);
                    recyclerRefreshLayout.setRefreshing(false);

                    newsViewModel.loadArticles(1, getAllSources());

                    Toast.makeText(getContext(), "News list was updated", Toast.LENGTH_LONG).show();
                }
            });
    }


}