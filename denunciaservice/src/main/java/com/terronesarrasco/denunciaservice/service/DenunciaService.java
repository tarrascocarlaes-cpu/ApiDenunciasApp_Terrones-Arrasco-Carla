package com.terronesarrasco.denunciaservice.service;

import com.terronesarrasco.denunciaservice.entity.Denuncia;

import java.util.List;

public interface DenunciaService {

    Denuncia registrar(Denuncia denuncia);

    List<Denuncia> obtenerTodas(int offset, int limit);

    Denuncia obtenerPorId(Integer id);

    List<Denuncia> obtenerPorCiudadano(String dni);

    Denuncia atender(Integer id);
}
