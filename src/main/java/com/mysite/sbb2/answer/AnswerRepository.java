package com.mysite.sbb2.answer;

import com.mysite.sbb2.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Page<Answer> findAllByQuestion(Question question, Pageable pageable);


}
