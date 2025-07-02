package com.yqq.acadinstitucion.Util;

import com.yqq.acadinstitucion.Entity.Institucion;
import com.yqq.acadinstitucion.Repository.InstitucionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InstitucionSeeder implements CommandLineRunner {

    private final InstitucionRepository institucionRepository;

    public InstitucionSeeder(InstitucionRepository institucionRepository) {
        this.institucionRepository = institucionRepository;
    }

    @Override
    public void run(String... args) {
        if (institucionRepository.count() == 0) {
            // Crear instituciones de ejemplo
            Institucion inst1 = new Institucion(null, "Institución Pedro Paulet", "Calle 123", 1L, 1L);
            Institucion inst2 = new Institucion(null, "Institución María Auxiliadora", "Av. Siempre Viva 456", 2L, 2L);

            institucionRepository.save(inst1);
            institucionRepository.save(inst2);

            System.out.println("Datos de Institución insertados correctamente en H2.");
        } else {
            System.out.println("Los datos de Institución ya existen en H2.");
        }
    }
}
