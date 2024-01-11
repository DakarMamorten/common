package com.wsh.repository;

import com.wsh.domain.Actor;
import com.wsh.domain.dto.ActorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author "Vladyslav Paun"
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {
    String QUERY = """
            SELECT new com.wsh.domain.dto.ActorDTO(
                a.actorId,
                a.firstName,
                a.lastName,
                a.lastUpdate,
                (SELECT STRING_AGG(f.title,', ') FROM a.films f) as fa)
            FROM com.wsh.domain.Actor a
            """;

    @Query(QUERY)
    Page<ActorDTO> findAllActorsWithFilms(Pageable pageable);

}
