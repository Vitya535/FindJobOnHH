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
public class Resume {

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("middleName")
    @Expose
    private String middleName;

    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    @SerializedName("gender")
    @Expose
    private Gender gender;

    @SerializedName("photo")
    @Expose
    private Photo photo;

    @SerializedName("portfolio")
    @Expose
    private List<Portfolio> portfolios;

    @SerializedName("contact")
    @Expose
    private List<Contact> contacts;
}
