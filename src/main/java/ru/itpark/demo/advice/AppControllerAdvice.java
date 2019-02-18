package ru.itpark.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itpark.demo.exception.NoticeNotFoundException;

@ControllerAdvice
public class AppControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoticeNotFoundException.class)
    public String handleNoticeNotFound(Model model){
        model.addAttribute("message", "NoticeEntity not found");
        return "error";
    }
}
