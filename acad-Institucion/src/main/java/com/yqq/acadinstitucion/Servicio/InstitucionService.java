package com.yqq.acadinstitucion.Servicio;

import com.yqq.acadinstitucion.Dto.InstitucionResponse;
import com.yqq.acadinstitucion.Entity.Institucion;

import java.util.List;

public interface InstitucionService {
    Institucion save(Institucion institucion);
    List<InstitucionResponse> findByNombre(String nombre);
}
