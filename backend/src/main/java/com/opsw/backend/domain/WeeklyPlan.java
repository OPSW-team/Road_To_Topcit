package com.opsw.backend.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/** 주간 학습 계획 테이블 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "weekly_plan",
        indexes = @Index(name = "idx_weekly_plan_user_week", columnList = "user_id,week_start"))
public class WeeklyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 주간 계획 ID

    @Column(name = "user_id", nullable = false)
    private Long userId; // 사용자 ID

    @Column(name = "week_start", nullable = false)
    private LocalDate weekStart; // 주 시작일

    @Column(name = "plan", columnDefinition = "json", nullable = false)
    private String plan; // 요일별 계획 JSON
}
