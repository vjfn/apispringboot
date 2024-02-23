package com.example.apispringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Repositorio para acceder a los datos de los Hoteles.
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Obtiene un hotel por su ID
     */
    Hotel getHotelById(Long id);

    /**
     * Obtiene un hotel por su nombre
     */
    Hotel getHotelByNombre(String nombre);

    /**
     * Obtiene hoteles por su puntuación
     */
    List<Hotel> getHotelByPuntuacion(Integer puntuacion);

    /**
     * Obtiene un centro comercial por su ubicación
     */
    Hotel getHotelByUbicacion(String ubicacion);

    /**
     * Obtiene hoteles que tienen buffet de desayuno
     */
    List<Hotel> getHotelByDesayunoBuffet(Boolean desayunoBuffet);

    /**
     * Obtiene una lista de nombres de hoteles
     */
    @Query("SELECT r.nombre FROM Hotel r")
    List<String> nombreHotel();

    /**
     * Obtiene la cantidad total de hoteles.
     *
     * @return El número total de hoteles.
     */
    @Query("SELECT count(r) FROM Hotel r")
    Integer cantidadDeHoteles();

    /**
     * Obtiene hoteles con una puntuación igual o mayor a la especificada
     */
    @Query("SELECT r FROM Hotel r WHERE r.puntuacion >= :puntuacion")
    List<Hotel> getHotelConPuntuacionMayorOIgual(Integer puntuacion);
}
