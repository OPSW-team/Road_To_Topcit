package com.opsw.backend.domain;

import jakarta.persistence.*;
import lombok.*;

/** 과목 테이블 */
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 과목 고유 ID

    @Column(length = 50, nullable = false, unique = true)
    private String name; // 과목명
}
