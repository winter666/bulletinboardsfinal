package ru.itpark.demo.service;

import org.springframework.stereotype.Service;
import ru.itpark.demo.entity.NoticeEntity;
import ru.itpark.demo.exception.NoticeNotFoundException;
import ru.itpark.demo.repository.NoticeRepository;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository repository;

    public NoticeService(NoticeRepository repository) {
        this.repository = repository;
    }

    public List<NoticeEntity> getAll(){
        return repository.findAll();
    }

    public NoticeEntity getById(int id){
        return repository.findById(id)
                .orElseThrow(NoticeNotFoundException::new);
    }

    public NoticeEntity getByIdOrEmpty(int id){
        return repository.findById(id).orElse(new NoticeEntity());
    }


    public void add(NoticeEntity entity){
        repository.save(entity);
    }

    public void removeById(int id){
        repository.deleteById(id);
    }
    public List<NoticeEntity> findByName(String name){
        return repository.findAllByNameContainsIgnoreCaseOrderByNumberDesc(name);
    }

    public List<NoticeEntity> findByCategories(String category){
        return repository.findAllByCategory(category);
    }







}
