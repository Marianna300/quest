package ru.javarash.project3.entity;

import lombok.*;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class User extends Entity {
    Long id;
    String login;
    String password;
}
