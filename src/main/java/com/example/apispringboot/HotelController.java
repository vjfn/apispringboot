package com.example.apispringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones relacionadas con Hoteles.
 */

@RestController
@RequestMapping("/api/hotel")
public class HotelController {


    /**
     * Repositorio para acceder a los datos de los Hoteles.
     */

    @Autowired
    private HotelRepository repository;

    /**
     * Servicio de seguridad para validar tokens de autenticación.
     */

    @Autowired
    private SecurityService security;

    /**
     * Obtiene todos los Hoteles
     */

    @GetMapping("/")
    public List<Hotel> getAll(){return repository.findAll();}

    /**
     * Obtiene un hotel por ID
     */

    @GetMapping("/id/{id}")
    public Hotel getHotelPorId(@PathVariable Long id){return repository.getHotelById(id);}

    /**
     * Obtiene un hotel por nombre
     */

    @GetMapping("/nombre/{nombre}")
    public Hotel getHotelPorNombre(@PathVariable String nombre){
        return repository.getHotelByNombre(nombre);
    }

    /**
     * Obtiene Hoteles por su puntuación
     */

    @GetMapping("/puntuacion/{puntuacion}")
    public List<Hotel> HotelPorPuntuacion(@PathVariable Integer puntuacion){
        return repository.getHotelByPuntuacion(puntuacion);
    }

    /**
     * Obtiene un hotel por ubicacion
     */

    @GetMapping("/ubicacion/{ubicacion}")
    public Hotel getHotelPorUbicacion(@PathVariable String ubicacion) {
        return repository.getHotelByUbicacion(ubicacion);
    }

    /**
     * Obtiene Hoteles que tienen desayunoBuffet
     */

    @GetMapping("/hoteles/{hoteles}")
    public List<Hotel> HotelPorDesayunoBuffet(@PathVariable Boolean hoteles) {
        return repository.getHotelByDesayunoBuffet(hoteles);
    }

    /**
     * Lista de hoteles
     */

    @GetMapping("/listaNombres")
    public List<String> getListaNombres() {
        return repository.nombreHotel();
    }



    @GetMapping("/puntuacionMinima/{puntuacionMinima}")
    public List<Hotel> getDesayunoBuffetPuntuacionMinima(@PathVariable Integer puntuacionMinima) {
        return repository.getHotelConPuntuacionMayorOIgual(puntuacionMinima);
    }

    /**
     * CRUD
     */
    /**
     * CREATE
     */

    @PostMapping("/post")
    public ResponseEntity<Hotel> nuevo(@RequestBody Hotel Hotel, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(repository.save(Hotel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * READ
     */

    @GetMapping("/cantidad")
    public Integer getNumeroDesayunoBuffet() {
        return repository.cantidadDeHoteles();
    }

    /**
     * Obtiene Hoteles con una puntuación igual o mayor a la especificada
     */

    /**
     * UPDATE
     */

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> put(@PathVariable Long id, @RequestBody Hotel Hotel, @RequestParam String token) {
        if (!security.validateToken(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            var desayunoBuffet = new Hotel();
            var desayunoBuffetSeleccionado = repository.findById(id);

            if (desayunoBuffetSeleccionado.isEmpty()) {
                desayunoBuffet = Hotel;
            } else {
                desayunoBuffet = desayunoBuffetSeleccionado.get();
                desayunoBuffet.setNombre(Hotel.getNombre());
                desayunoBuffet.setPuntuacion(Hotel.getPuntuacion());
                desayunoBuffet.setUbicacion(Hotel.getUbicacion());
                desayunoBuffet.setDesayunoBuffet(Hotel.getDesayunoBuffet());
            }
            return new ResponseEntity<>(repository.save(desayunoBuffet), HttpStatus.OK);
        }
    }

    /**
     * DELETE
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Hotel> delete(@PathVariable Long id, @RequestParam String token) {
        ResponseEntity<Hotel> response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (security.validateToken(token)) {
            Hotel salida = new Hotel();
            if (repository.existsById(id)) {
                salida = repository.findById(id).get();
                repository.deleteById(id);
                response = new ResponseEntity<>(salida, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(salida, HttpStatus.NOT_FOUND);
            }
        }

        return response;
    }
}
