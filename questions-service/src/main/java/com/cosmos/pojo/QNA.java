package com.cosmos.pojo;

import com.cosmos.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QNA {
    private Question question;
    private Answers answers;
}
