package com.example.Medical.App.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class PersonnelAdministratif extends Utilisateur {

    private String role;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "hopital_id")
    private Hopital hopital;

}
