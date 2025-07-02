package com.yqq.acadinstitucion.Controller;

import com.yqq.acadinstitucion.Dto.InstitucionResponse;
import com.yqq.acadinstitucion.Entity.Institucion;
import com.yqq.acadinstitucion.Servicio.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucion")
@CrossOrigin("*")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @PostMapping
    public Institucion crear(@RequestBody Institucion institucion) {
        return institucionService.save(institucion);
    }

    @GetMapping("/buscar")
    public List<InstitucionResponse> buscarPorNombre(@RequestParam String nombre) {
        return institucionService.findByNombre(nombre);
    }
}
