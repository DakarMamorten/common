package com.wsh.repository;

import com.wsh.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Vladyslav Paun"
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
