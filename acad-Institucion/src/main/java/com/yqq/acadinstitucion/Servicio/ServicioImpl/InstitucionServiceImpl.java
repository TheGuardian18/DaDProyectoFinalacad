package com.yqq.acadinstitucion.Servicio.ServicioImpl;

import com.yqq.acadinstitucion.Dto.InstitucionResponse;
import com.yqq.acadinstitucion.Dto.SedeDto;
import com.yqq.acadinstitucion.Dto.UgelDto;
import com.yqq.acadinstitucion.Entity.Institucion;
import com.yqq.acadinstitucion.Feign.SedeFeign;
import com.yqq.acadinstitucion.Feign.UgelFeign;
import com.yqq.acadinstitucion.Repository.InstitucionRepository;
import com.yqq.acadinstitucion.Servicio.InstitucionService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private InstitucionRepository institucionRepository;

    @Autowired
    private SedeFeign sedeFeign;

    @Autowired
    private UgelFeign ugelFeign;

    @Override
    public Institucion save(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    @Override
    @CircuitBreaker(name = "buscarInstitucionPorNombreCB", fallbackMethod = "fallbackBuscarPorNombre")
    public List<InstitucionResponse> findByNombre(String nombre) {
        List<Institucion> instituciones = institucionRepository.findByNombreContainingIgnoreCase(nombre);
        List<InstitucionResponse> responses = new ArrayList<>();

        for (Institucion institucion : instituciones) {
            InstitucionResponse response = new InstitucionResponse();
            response.setId(institucion.getId());
            response.setNombre(institucion.getNombre());
            response.setDireccion(institucion.getDireccion());

            // Llamadas Feign para obtener nombres
            SedeDto sede = null;
            UgelDto ugel = null;
            try {
                sede = sedeFeign.getSedeById(institucion.getSedeId());
            } catch (Exception e) {
                // Manejo de error (puedes registrar el error)
            }
            try {
                ugel = ugelFeign.getUgelById(institucion.getUgelId());
            } catch (Exception e) {
                // Manejo de error
            }

            response.setNombreSede(sede != null ? sede.getNombreSede() : "Sede no disponible");
            response.setNombreUgel(ugel != null ? ugel.getNombreDeLaUgel() : "UGEL no disponible");

            responses.add(response);
        }

        return responses;
    }

    public List<InstitucionResponse> fallbackBuscarPorNombre(String nombre, Throwable throwable) {
        InstitucionResponse fallback = new InstitucionResponse();
        fallback.setNombre("Servicio no disponible");
        fallback.setDireccion("-");
        fallback.setNombreSede("Sede no disponible");
        fallback.setNombreUgel("UGEL no disponible");

        List<InstitucionResponse> fallbackList = new ArrayList<>();
        fallbackList.add(fallback);
        return fallbackList;
    }
}
