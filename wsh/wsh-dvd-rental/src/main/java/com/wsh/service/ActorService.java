package com.wsh.service;

import com.wsh.domain.Actor;
import com.wsh.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public void add(final String firstName,
                    String lastName) {
        Actor actor = new Actor(firstName,
                                lastName);
        actorRepository.save(actor);
    }

    public Actor findById(final Long actorId) {
        return actorRepository.findById(actorId)
                              .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void update(final Long actorId,
                       final String actorFirstName,
                       final String actorLastName) {
        actorRepository.findById(actorId)
                       .ifPresent(a -> {
                           a.setFirstName((actorFirstName));
                           a.setLastName((actorLastName));
                       });
    }

    public Page<Actor> findAll(final Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public void delete(final Long actorId) {
        actorRepository.deleteById(actorId);
    }

    public List<Actor> findAllById(Set<Long> actorsIds) {
        return actorRepository.findAllById(actorsIds);
    }

}
