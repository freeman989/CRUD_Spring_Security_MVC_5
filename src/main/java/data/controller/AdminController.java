package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import data.dao.RoleDAO;
import data.model.Role;
import data.model.User;
import data.service.UserService;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final RoleDAO roleDAO;
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminController(UserService userService, RoleDAO roleDAO, PasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.roleDAO = roleDAO;
    }

    @GetMapping("/admin")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("usersList", users);
        return "admin";
    }

    @GetMapping(value = "/admin/add")
    public String addPage(Model model) {
        return "add_users";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("rolesAdd") String[] roles) {
        user.setRoles(rolesList(roles));
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editPage(Model model, @PathVariable("id") long id) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        List<Role> role = new ArrayList<>();
        role.add(roleDAO.createRoleIfNotFound("ADMIN", 1L));
        role.add(roleDAO.createRoleIfNotFound("USER", 2L));
        role.add(roleDAO.createRoleIfNotFound("STRANGER", 3L));
        model.addAttribute("rolesList", role);
        return "change_users";
    }

    @PostMapping(value = "/admin/edit")
    public String editUser(
            @ModelAttribute("id") Long id,
            @ModelAttribute("name") String name,
            @ModelAttribute("surname") String surname,
            @ModelAttribute("age") byte age,
            @ModelAttribute("profession") String profession,
            @ModelAttribute("password") String password,
            @RequestParam("roles") String[] roles
    ) {
        User user = userService.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setProfession(profession);
        if (!password.isEmpty()) {
            user.setPassword(password);
        }
        user.setRoles(rolesList(roles));
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/admin";
    }

    List<Role> rolesList(String[] roles){
        List<Role> roleList = new ArrayList<>();
        for (String st : roles) {
            if (st.equals("ADMIN")) {
                roleList.add(roleDAO.createRoleIfNotFound("ADMIN", 1L));
            }
            if (st.equals("USER")) {
                roleList.add(roleDAO.createRoleIfNotFound("USER", 2L));
            }
            if (st.equals("STRANGER")) {
                roleList.add(roleDAO.createRoleIfNotFound("STRANGER", 3L));
            }
        }
        return roleList;
    }
}
