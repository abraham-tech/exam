package com.example.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ExamApplication {
    @Autowired
    private final ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
//        Item save = itemRepository.save(new Item("test", 1, "test"));

    }

}
