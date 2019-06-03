
package vsu.project.findjobonhh.models;

import java.util.List;
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
public class Contacts {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public Object email;
    @SerializedName("phones")
    @Expose
    public List<Phone> phones = null;
}
