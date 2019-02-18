package ru.itpark.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itpark.demo.entity.NoticeEntity;
import ru.itpark.demo.repository.NoticeRepository;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(DemoApplication.class, args);

        var repository = context.getBean(NoticeRepository.class);

        repository.saveAll(List.of(
                new NoticeEntity
                        (1, "Post", "other", "Hi! It's my first project, that works. Much more work to do, but i will try.", "example@mail.ru", 7999),
                new NoticeEntity
                        (2, "Help!", "need a help", "Help! In my computer displayed blue screen. What should i do?", "helpme@email.com", 79697777),
                new NoticeEntity
                        (3, "Wanted a cat", "wanted", "Hello everybody! I'm looking for my cat. His name is Kemal. He is of siamese breed", "wanted@email.com", 79697777),
                new NoticeEntity
                        (4, "Message for my Mom", "message", "I passed the exam!! I'm verry happy now!", "message@email.com", 79697777),
                new NoticeEntity
                        (5, "Guitar", "advertisement", "I sell a acoustic guitar. Materials: maple, rosewood fingerboard, complete with belt and case", "advertisement@email.com", 79697777),
                new NoticeEntity
                        (6, "Warning!", "ad", "Today I will go to bed early to get up on time tomorrow", "advertisement@email.com", 79697777),
                new NoticeEntity
                        (7, "I'm so tired", "message", "I have not slept for several days. I just want to rest", "kane@email.com", 79697777)
        ));

    }

}

