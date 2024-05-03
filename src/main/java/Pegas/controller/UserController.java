package Pegas.controller;

import Pegas.dto.UserCreateUpdateDto;
import Pegas.dto.UserFilterDto;
import Pegas.entity.Role;
import Pegas.service.CompanyService;
import Pegas.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAll(Model model, UserFilterDto filter){
        model.addAttribute("users",userService.findAll(filter));
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findByTd(Model model, @PathVariable("id") Long id){
        return userService.findById(id).map(
                user->{
                    model.addAttribute("user",user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/create")
    public String createForm(Model model, @ModelAttribute("user") UserCreateUpdateDto user){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/create";
    }
    @PostMapping
    public String create(@ModelAttribute UserCreateUpdateDto user){
        userService.create(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute UserCreateUpdateDto user,@PathVariable("id") Long id){
        userService.update(id,user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
