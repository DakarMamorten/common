package com.wsh.domain.dto;

import com.wsh.domain.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ActorDTO {

    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    private Object filmTitle;

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
