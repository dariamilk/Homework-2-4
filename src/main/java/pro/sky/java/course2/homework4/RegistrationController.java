package pro.sky.java.course2.homework4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @GetMapping("/registration")
    public String register(@RequestParam("login") String login, @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String passwordRepeat) {
        try {
            RegistrationService.register(login, password, passwordRepeat);
            return "Все в порядке!";
        } catch (WrongLoginException e) {
            return "Неверный логин!";
        } catch (WrongPasswordException e) {
            return "Неверный пароль!";
        }
    }
}
