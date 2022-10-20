package ru.javarash.project3.entity;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer extends Entity {
    String id;
    String sectionAnswer;
}
