package ru.itpark.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NoticeEntity {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    private String category;
    @Column(nullable=false)
    private String content;
    private String email;
    private long number;

}
