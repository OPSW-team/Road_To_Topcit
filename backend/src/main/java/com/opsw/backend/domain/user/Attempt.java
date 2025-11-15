package com.opsw.backend.domain.user;

import com.opsw.backend.domain.Question;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

/** 사용자의 문제 풀이 기록 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "attempt",
        indexes = {
                @Index(name = "idx_attempt_user", columnList = "user_id"),
                @Index(name = "idx_attempt_question", columnList = "question_id")
        })
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 풀이 ID

    @Column(name = "user_id", nullable = false)
    private Long userId; // 사용자 ID

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Question question; // 문제 (FK 제약 없음)

    @Column(nullable = false, length = 255)
    private String submittedAnswer; // 제출 답안

    @Column(nullable = false)
    private boolean isCorrect; // 정답 여부

    @Column(nullable = false)
    private Integer gainedXp; // 획득 XP

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 풀이 시각
}
