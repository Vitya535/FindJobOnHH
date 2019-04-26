package vsu.project.findjobonhh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Portfolio {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("small")
    @Expose
    private String small;

    @SerializedName("medium")
    @Expose
    private String medium;

    @SerializedName("description")
    @Expose
    private String description;
}
