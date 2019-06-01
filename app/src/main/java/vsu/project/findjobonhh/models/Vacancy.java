package vsu.project.findjobonhh.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    private String id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("key_skills")
    @Expose
    private List<String> keySkills;

    @SerializedName("schedule")
    @Expose
    private Schedule schedule;

    @SerializedName("address")
    @Expose
    private Address address;

    @SerializedName("alternate_url")
    @Expose
    private String alternateUrl;

    @SerializedName("apply_alternate_url")
    @Expose
    private String applyAlternateUrl;

    @SerializedName("employment")
    @Expose
    private Employment employment;

    @SerializedName("salary")
    @Expose
    private Salary salary;
}
