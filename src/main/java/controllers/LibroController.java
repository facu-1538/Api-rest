package controllers;

import entities.Libro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/libro")

public class LibroController {

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).
                    body("Busqué todos los datos");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body("Busqué este libro por Id:" + id);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Libro entity){

        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Titulo :" + entity.getTitulo());
        System.out.println("Fecha :" + entity.getFecha());
        System.out.println("Genero :" + entity.getGenero());
        System.out.println("Cantidad de paginas :" + entity.getPagina());
        System.out.println("Autor :" + entity.getAutor());

        try{
            return ResponseEntity.status(HttpStatus.OK).body("Grabé los datos anteriores");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro entity){
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("ID :" + entity.getId());
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Titulo :" + entity.getTitulo());
        System.out.println("Fecha :" + entity.getFecha());
        System.out.println("Genero :" + entity.getGenero());
        System.out.println("Cantidad de paginas :" + entity.getPagina());
        System.out.println("Autor :" + entity.getAutor());
        try{
            return ResponseEntity.status(HttpStatus.OK).body("Actualicé los datos anteriores");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminé el registro" + id);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
