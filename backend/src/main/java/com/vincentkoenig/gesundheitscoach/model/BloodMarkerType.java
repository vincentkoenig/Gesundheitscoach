package com.vincentkoenig.gesundheitscoach.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Repräsentiert einen Typ von Blutwert, der getrackt werden kann,
 * z.B. Vitamin D, LDL-Cholesterin, HbA1c.
 * Dies ist eine Referenztabelle - es gibt genau einen Eintrag pro Blutwert-Typ,
 * unabhängig davon, wie viele Nutzer die App hat.
 * Diese Entity wird über JPA/Hibernate auf eine Datenbanktabelle abgebildet.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BloodMarkerType {

    // Primärschlüssel - identifiziert eindeutig jede Zeile in der Datenbanktabelle.
    // IDENTITY bedeutet: die Datenbank vergibt den Wert automatisch, hochzählend (1, 2, 3, ...).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name des Blutwerts, z.B. "Vitamin D" oder "LDL-Cholesterin".
    // unique = true: kein Name darf doppelt vorkommen.
    // nullable = false: jeder Eintrag muss zwingend einen Namen haben.
    @Column(unique = true, nullable = false)
    private String name;

    // Maßeinheit des Werts, z.B. "ng/ml" oder "mg/dl".
    // nullable = false: jeder Eintrag muss zwingend eine Einheit haben.
    @Column(nullable = false)
    private String unit;

}