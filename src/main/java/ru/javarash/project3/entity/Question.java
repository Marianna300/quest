package ru.javarash.project3.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question extends Entity {
    String section;
    String sectionStory;
    String sectionQuestion;
    String viewAddress;
    Collection<Answer> answers = new ArrayList<>();
    String[] answerPath;
    int submitAnswerIndex;

}