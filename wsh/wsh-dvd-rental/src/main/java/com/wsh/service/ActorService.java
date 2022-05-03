package com.wsh.service;

import com.wsh.domain.Actor;
import com.wsh.domain.Category;
import com.wsh.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ActorService {

    private final ActorRepository actorRepository;

    public void add(final String firstName,String lastName) {
        Actor actor = new Actor(firstName,lastName);
        actorRepository.save(actor);
    }

    public Actor findById(final Long id) {
        return actorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void update(final Long actorId, final String actorFirstName,final String actorLastName) {
        actorRepository.findById(actorId).ifPresent(a -> a.setFirstName((actorFirstName)));
    }

    public Page<Actor> findAll(final Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    public void delete(final Long actorId) {
        actorRepository.deleteById(actorId);
    }
}
