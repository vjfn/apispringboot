package com.example.apispringboot;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase de hotel.
 */

@Data
@Entity
@Table(name = "hoteles")
public class Hotel {

    /**
     * ID único del hotel.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Ubicación del hotel.
     */
    private String ubicacion;

    /**
     * Puntuación del hotel.
     */
    private Integer puntuacion;

    /**
     * Indica si el hotel tiene incluido el desayuno o no.
     */
    private Boolean desayunoBuffet;

}
