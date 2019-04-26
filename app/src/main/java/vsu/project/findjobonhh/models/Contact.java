package vsu.project.findjobonhh.models;

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
public class Contact {

    private ContactType contactType;

    private ContactValue contactValue;

    private Boolean preferred;

    private String comment;

    private Boolean verified;
}
