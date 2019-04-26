package vsu.project.findjobonhh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Salary {

    @SerializedName("from")
    @Expose
    private Integer from;

    @SerializedName("to")
    @Expose
    private Integer to;

    @SerializedName("gross")
    @Expose
    private Boolean gross;

    @SerializedName("currency")
    @Expose
    private String currency;
}
