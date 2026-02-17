package com.example.Medical.App.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode()
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonnelAdministratif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private String nom;
    private String prenom;
    private String role;
    private String telephone;


//    @ManyToOne
//    @JoinColumn(name = "adresse_id")
//    private Adresse adresse;
//
//    @ManyToOne
//    @JoinColumn(name = "hopital_id")
//    private Hopital hopital;

}
