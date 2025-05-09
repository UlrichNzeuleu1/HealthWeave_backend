package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private LocalDate date;
    private String heure;
    private String statut;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RendezVous> rendezVousList;

}
