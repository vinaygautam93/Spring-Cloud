package com.vinay.quiz_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getter, setter, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-argument constructor
public class QuestionWrapper {

    private Integer id; // Unique ID of the question
    private String questionTitle; // The actual question text
    private String option1; // First answer option
    private String option2; // Second answer option
    private String option3; // Third answer option
    private String option4; // Fourth answer option

    // Constructor to initialize all fields
    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
