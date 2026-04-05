package com.adso.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.api.models.Tema;
import com.adso.api.services.TemaServices;

@RestController
@RequestMapping("/api/temas")
public class TemaController {
    /*
     * Always declare the service as a private field, this will help to be able to link it to the rest of the project
     *
     * Always remember the order is
     * Repository --> Service --> Controller
     * 
     * And on this case to use the service as a defined function you must use
     * 
     * private TemaServices temaService;
     * 
     * This way the controller can use the functions defined on the service and the service can use the functions defined on the repository
     */


    private TemaServices temaServices;

    /**
     * This is a constructor to have the temas services available for selection and ussage on the desired endpoint
     * @param temaService
     */
    public TemaController(TemaServices temaServices) {
        this.temaServices = temaServices;
    }

    /**
     * Now we set an enpoint with  @GetMapping so that we can implement the logic created on the services .
     */
    @GetMapping("/getAllTemas")
    public List<Tema> findAll(){
        return temaServices.findAllTemas();
    };

    @GetMapping("/findtema/{id}")
    public Tema findOneTema(@PathVariable Integer id ){     //In the case we needed to use something form the path we would need to use (@PathVariable)
        return temaServices.findTemaById(id);
    }

    @PostMapping
    public ResponseEntity<String> crearAprendiz(
            @RequestParam String tema
    ) {
        temaServices.createTema(tema);
        // Nota: crear un Tema no inserta automáticamente una fila en `preferencias`.
        // La relación pivote debe guardarse explícitamente con una entidad Preferencia.
        return ResponseEntity.ok("Tema creado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable Integer id) {
        int rows = temaServices.deleteTema(id);
        
        if (rows == 0) {
            return ResponseEntity.status(404).body("Tema not found, please provide a valid Id") ;
        }
        return ResponseEntity.ok("Tema eliminado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTema(
            @PathVariable Integer id, 
            @RequestParam String tema
    ) {
        Tema temaActualizado = temaServices.updateTema(id, tema);
        
        if (temaActualizado == null) {
            return ResponseEntity.status(404).body("Tema not found, please provide a valid Id");
        }
        return ResponseEntity.ok("Tema actualizado correctamente"); 
    }
}



