package com.ascrossgams.myapplication.ui.fullArticle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticle;
import com.ascrossgams.myapplication.ui.news.NewsFragment;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class FullArticleFragment extends Fragment {

    private ImageView    articlePic;
    private TextView     articleTitle;
    private TextView     articleFullText;
    private int          position;
    private List<RetroArticle> articleList;
    private Button       backBtn;
    private Button       nextBtn;
    private Button       prewBtn;

    public FullArticleFragment(List<RetroArticle> articleList, int position) {
        this.position = position;
        this.articleList = articleList;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_article, container, false);

        articlePic = root.findViewById(R.id.article_pic);
        articleTitle = root.findViewById(R.id.article_title);
        articleFullText = root.findViewById(R.id.article_full_text);
        backBtn = root.findViewById(R.id.back_btn);
        nextBtn = root.findViewById(R.id.next_btn);
        prewBtn = root.findViewById(R.id.prew_Btn);

        setContent();
        OnClickBack();
        OnClickNext();
        OnClickPrew();

        return root;
    }

    public void OnClickBack(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment newsFragment = new NewsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, newsFragment);
                transaction.commit();
            }
        });
    }

    public void OnClickNext(){
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y = articleList.size();
                if (position < articleList.size()-1) {
                    position = position + 1;
                    setContent();
                }

                else {
                    Toast.makeText(getContext(), "Curent article is the last in the list", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void OnClickPrew(){
        prewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > 0) {
                    position = position - 1;
                    setContent();
                }

                else {
                    Toast.makeText(getContext(), "Current article is the first in the list", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void setContent(){
        Picasso.with(getContext()).load(articleList.get(position).getUrlToImage()).into(articlePic);
        articleTitle.setText(articleList.get(position).getTitle());
        articleFullText.setText(articleList.get(position).getContent());
    }


}