package com.example.MyFirstWebApp.services;

import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationUserService {

    private static final Pattern patternLogin = Pattern.compile("^[a-zA-Z][a-zA-Z-_.\\d]{4,18}[a-zA-Z\\d]$");
    private static final Pattern patternEmail = Pattern.compile("^[a-zA-Z\\d_-]+(\\.[a-zA-Z\\d_-]+)*@[a-zA-Z\\d_-]+(\\.[a-zA-Z\\d_-]+)*(\\.[a-zA-Z]{2,})$");
    private static final Pattern patternPassword = Pattern.compile("^[a-zA-Z\\d_]{7,20}$");
    private static final Pattern patternName = Pattern.compile("^[a-zA-Zа-яА-Я]{2,20}$");
    private static final Pattern patternSurname = Pattern.compile("^[a-zA-Zа-яА-Я]{2,20}$");
    private static final Pattern patternTel = Pattern.compile("^\\+?375(25|29|44)\\d{7}$");

    public RegistrationUserService()
    {

    }

    public boolean isCorrectLogin(String login)
    {
        Matcher matcher = patternLogin.matcher(login);
        return matcher.find();
    }

    public boolean isCorrectEmail(String userEmail)
    {
        Matcher matcher = patternEmail.matcher(userEmail);
        return matcher.find();
    }

    public boolean isCorrectPassword(String userPassword)
    {
        Matcher matcher = patternPassword.matcher(userPassword);
        return matcher.find();
    }

    public boolean isCorrectName(String userName)
    {
        if (userName.equals("")) {
            return true;
        }
        Matcher matcher = patternName.matcher(userName);
        return matcher.find();
    }

    public boolean isCorrectSurname(String userSurname)
    {
        if (userSurname.equals("")) {
            return true;
        }
        Matcher matcher = patternSurname.matcher(userSurname);
        return matcher.find();
    }

    public boolean isCorrectTel(String userTel)
    {
        if (userTel.equals("")) {
            return true;
        }
        Matcher matcher = patternTel.matcher(userTel);
        return matcher.find();
    }

    public boolean isCorrectUserData(String login, String userEmail, String userPassword)
    {
        return isCorrectLogin(login) && isCorrectEmail(userEmail) && isCorrectPassword(userPassword);
    }

    public boolean isCorrectUserData(String login, String userEmail, String userPassword, String userName, String userSurname, String userTel)
    {
        return isCorrectUserData(login, userEmail, userPassword) && isCorrectName(userName) && isCorrectSurname(userSurname) && isCorrectTel(userTel);
    }
}