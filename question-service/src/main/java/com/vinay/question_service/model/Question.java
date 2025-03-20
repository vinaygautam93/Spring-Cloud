package com.vinay.question_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity // Marks this class as a JPA entity (table in the database)
@Table(name="question") // Maps this entity to the "question" table in the database
public class Question {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values
    private Integer id; // Unique identifier for each question

    private String questionTitle; // The text of the question
    private String option1; // First answer option
    private String option2; // Second answer option
    private String option3; // Third answer option
    private String option4; // Fourth answer option
    private String rightAnswer; // Correct answer for the question
    private String difficultylevel; // Difficulty level of the question
    private String category; // Category of the question

}
