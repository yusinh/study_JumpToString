package com.mysite.sbb2.answer;

import com.mysite.sbb2.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    Page<Answer> findAllByQuestion(Question question, Pageable pageable);

    @Query("SELECT e "
            + "FROM Answer e "
            + "WHERE e.question = :question "
            + "ORDER BY SIZE(e.voters) DESC, e.createDate")
    Page<Answer>findAllByQuestionOrderByVoter(@Param("question") Question question, Pageable pageable);

}
