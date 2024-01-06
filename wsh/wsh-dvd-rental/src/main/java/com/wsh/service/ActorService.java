package com.wsh.service;

import com.wsh.domain.Actor;
import com.wsh.domain.Film;
import com.wsh.domain.dto.ActorDTO;
import com.wsh.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<ActorDTO> findAll(final Pageable pageable) {
        List<ActorDTO> list = new ArrayList<>();
        Page<Actor> actors = actorRepository.findAll(pageable);
        actors.forEach(actor -> {
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setNumber(actorDTO.getNumber());
            actorDTO.setTotalPages(actorDTO.getTotalPages());
            actorDTO.setTotalElements(actorDTO.getTotalElements());
            actorDTO.setActorId(actorDTO.getActorId());
            actorDTO.setLastName(actorDTO.getLastName());
            actorDTO.setFirstName(actor.getFirstName());
            actorDTO.setLastUpdate(actor.getLastUpdate());
            Set<String> stringSet = actor.getFilms()
                    .stream()
                    .map(Film::getTitle)
                    .collect(Collectors.toSet());
            actorDTO.setFilmNames(stringSet);
            list.add(actorDTO);
        });

        return list;
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
