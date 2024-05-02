package Pegas.controller;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users",userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findAll(Model model, @PathVariable("id") Long id){
        model.addAttribute("users",userService.findById(id));
        return "user/users";
    }

    @PostMapping
    public String create(@ModelAttribute UserCreateUpdateDto user){
        userService.create(user);
        return "redirect:user/users";
    }
}
