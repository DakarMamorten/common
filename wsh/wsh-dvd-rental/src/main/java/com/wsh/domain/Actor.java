package com.wsh.domain;

import com.wsh.domain.dto.ActorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Vladyslav Paun"
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "films")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate = LocalDateTime.now();

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    private Set<Film> films = new HashSet<>();

    public Actor(final String firstName,
                 final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Actor of(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        return actor;
    }
}
