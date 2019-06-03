
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
public class ConcreteVacancy {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("area")
    @Expose
    public Area area;
    @SerializedName("salary")
    @Expose
    public Salary salary;
    @SerializedName("experience")
    @Expose
    public Experience experience;
    @SerializedName("schedule")
    @Expose
    public Schedule schedule;
    @SerializedName("contacts")
    @Expose
    public Contacts contacts;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("created_at")
    @Expose
    public String createdAt;

}
