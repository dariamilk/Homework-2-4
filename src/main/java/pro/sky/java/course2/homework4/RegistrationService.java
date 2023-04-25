package pro.sky.java.course2.homework4;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private static boolean checkIfCorrect (String stringToCheck) {
        return stringToCheck.matches("(^[a-zA-Z0-9_]+$)") && stringToCheck.length() < 20;
    }
    public static void register (String login, String password, String passwordRepeat)
            throws WrongLoginException, WrongPasswordException {
        if (!checkIfCorrect(login)) {
            throw new WrongLoginException();
        }
        if (!checkIfCorrect(password) || !checkIfCorrect(passwordRepeat) ||
                (password.length() != passwordRepeat.length())) {
            throw new WrongPasswordException();
        }
    }
}
