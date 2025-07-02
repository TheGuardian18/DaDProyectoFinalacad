package com.yqq.acadinstitucion.Servicio;

import com.yqq.acadinstitucion.Dto.InstitucionResponse;
import com.yqq.acadinstitucion.Entity.Institucion;

import java.util.List;

public interface InstitucionService {

    // Crear
    Institucion save(Institucion institucion);

    // Leer todos
    List<Institucion> listar();

    // Leer uno por ID
    Institucion buscar(Long id);

    // Actualizar
    Institucion actualizar(Institucion institucion);

    // Eliminar
    void eliminar(Long id);

    // Buscar por nombre (adicional)
    List<InstitucionResponse> findByNombre(String nombre);
}
