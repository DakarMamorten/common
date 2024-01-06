package com.wsh.domain.dto;

import com.wsh.domain.Actor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ActorDTO {

    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    private Set<String> filmNames;
    private int number;
    private int totalPages;
    private int totalElements;


    public ActorDTO() {
    }

    public static ActorDTO fromEntity(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actor.getActorId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        return actorDTO;
    }
    public Actor toEntity() {
        Actor actor = new Actor(this.getFirstName(), this.getLastName());
        actor.setActorId(this.getActorId());
        return actor;
    }
}
