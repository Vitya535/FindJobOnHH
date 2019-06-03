package vsu.project.findjobonhh.database.entity;

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
public class Developer {

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;
}
