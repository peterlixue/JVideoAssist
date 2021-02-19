package com.ai.jvideoassist;

import androidx.annotation.NonNull;

/**
 * 本地视频信息实体类
 */
public class LocalMovieBean {

    private String name;
    private String path;
    private long duration;
    private long size;

    @NonNull
    @Override
    public String toString() {
        return "LocalMovieBean {" +
                "name='" + name + "\'" +
                ", path='" + path + "\'" +
                ", duration=" + duration +
                ", size=" + size +
                '}';
    }

    public LocalMovieBean() {

    }
    public LocalMovieBean(String name, String path, long duration, long size) {
        this.name = name;
        this.path = path;
        this.duration = duration;
        this.size = size;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
