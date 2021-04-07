package com.example.marymathacollege.videos;

public class VideoData {
    private String name,post,key;

    public VideoData() {
    }
    public VideoData(String name, String post, String key) {
        this.name = name;
        this.post = post;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }




}

