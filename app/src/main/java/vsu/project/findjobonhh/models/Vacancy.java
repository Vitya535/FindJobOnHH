
package vsu.project.findjobonhh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Vacancy {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("area")
    @Expose
    public Area area;
    @SerializedName("employer")
    @Expose
    public Employer employer;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("snippet")
    @Expose
    public Snippet snippet;
}
