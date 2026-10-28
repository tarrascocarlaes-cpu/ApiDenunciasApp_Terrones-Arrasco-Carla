package com.terronesarrasco.denunciaservice.repository;

import com.terronesarrasco.denunciaservice.entity.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

    List<Denuncia> findByDni(String dni);

    @Query(value = "SELECT * FROM denuncia ORDER BY id LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Denuncia> findAllPaginated(@Param("offset") int offset, @Param("limit") int limit);
}
