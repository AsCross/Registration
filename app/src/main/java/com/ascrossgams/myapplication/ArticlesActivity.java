package com.ascrossgams.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.ascrossgams.myapplication.ui.fullArticle.FullArticleFragment;

public class ArticlesActivity extends AppCompatActivity {
    FragmentTransaction fTrans;

    FullArticleFragment fullArticleFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        fTrans = getSupportFragmentManager().beginTransaction();
    }
}
