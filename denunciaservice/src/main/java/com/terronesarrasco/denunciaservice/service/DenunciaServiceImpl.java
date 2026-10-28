package com.terronesarrasco.denunciaservice.service;

import com.terronesarrasco.denunciaservice.entity.Denuncia;
import com.terronesarrasco.denunciaservice.repository.DenunciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DenunciaServiceImpl implements DenunciaService {

    private final DenunciaRepository repository;

    public DenunciaServiceImpl(DenunciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Denuncia registrar(Denuncia denuncia) {
        if (denuncia.getFecha() == null) {
            denuncia.setFecha(LocalDateTime.now());
        }
        if (denuncia.getEstado() == null) {
            denuncia.setEstado(1);
        }
        return repository.save(denuncia);
    }

    @Override
    public List<Denuncia> obtenerTodas(int offset, int limit) {
        return repository.findAllPaginated(offset, limit);
    }

    @Override
    public Denuncia obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Denuncia no encontrada con id: " + id));
    }

    @Override
    public List<Denuncia> obtenerPorCiudadano(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    public Denuncia atender(Integer id) {
        Denuncia denuncia = obtenerPorId(id);
        denuncia.setEstado(0);
        return repository.save(denuncia);
    }
}
