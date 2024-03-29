package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroArticle {

    @SerializedName("source")
    private RetroSource source;
    @SerializedName("author")
    private String      author;
    @SerializedName("title")
    private String      title;
    @SerializedName("description")
    private String      description;
    @SerializedName("url")
    private String      url;
    @SerializedName("urlToImage")
    private String      urlToImage;
    @SerializedName("publishedAt")
    private String      publishedAt;
    @SerializedName("content")
    private String      content;

    public RetroArticle(RetroSource source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public RetroSource getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }
}
