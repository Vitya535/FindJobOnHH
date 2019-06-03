
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
public class Phone {

    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("number")
    @Expose
    public String number;
    @SerializedName("country")
    @Expose
    public String country;

}
