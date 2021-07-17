package com.cosmos.pojo;

import com.cosmos.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answers {
    private List<Answer> answers;
}
