package ru.itpark.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.demo.entity.NoticeEntity;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
    List<NoticeEntity> findAllByNameContainsIgnoreCaseOrderByNumberDesc(String name);
    List<NoticeEntity> findAllByCategory(String category);
}
