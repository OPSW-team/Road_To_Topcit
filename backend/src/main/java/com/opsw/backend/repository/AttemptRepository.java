package com.opsw.backend.repository;

import com.opsw.backend.domain.user.Attempt;
import com.opsw.backend.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {

    // 사용자 풀이 이력 최신순 페이지 조회
    Page<Attempt> findByUserIdOrderByCreatedAtDesc(Long userId, Pageable pageable);

    // 특정 문제의 풀이 이력 페이지 조회
    Page<Attempt> findByQuestion(Question question, Pageable pageable);

    // 정답 수/총 풀이 수/XP 합계 등 통계용
    long countByUserIdAndIsCorrectTrue(Long userId);
    long countByUserId(Long userId);

    // gainedXp 합계
    @org.springframework.data.jpa.repository.Query("SELECT COALESCE(SUM(a.gainedXp), 0) FROM Attempt a WHERE a.userId = :userId")
    int totalXpByUser(Long userId);
}
