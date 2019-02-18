package ru.itpark.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.demo.entity.NoticeEntity;
import ru.itpark.demo.service.NoticeService;

@Controller
@RequestMapping("/")
public class NoticeController {
    private final NoticeService service;

    public NoticeController(NoticeService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("items", service.getAll());
        return "all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model){
        model.addAttribute("item", service.getById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("item", service.getByIdOrEmpty(id));
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id,
                       @ModelAttribute NoticeEntity entity){
        service.add(entity);

        return "redirect:/";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable int id,
                         Model model){
        model.addAttribute("item", service.getById(id));
        return "remove";
    }

    @PostMapping("/{id}/remove")
    public String remove(@PathVariable int id){
        service.removeById(id);
        return "redirect:/";
    }
    @GetMapping(value="/search", params="name")
    public String search(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("items", service.findByName(name));
        return "all";
    }
    @GetMapping(value="/search", params="category")
    public String searchByCategory(@RequestParam String category, Model model){
        model.addAttribute("category", category);
        model.addAttribute("items", service.findByCategories(category));
        return "all";
    }

}
