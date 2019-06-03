
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
public class Salary {

    @SerializedName("from")
    @Expose
    public Integer from;
    @SerializedName("to")
    @Expose
    public Object to;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("gross")
    @Expose
    public Boolean gross;
}
