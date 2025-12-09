package uz.pdp.project.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static String encode(String password){
        return  BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean check(String password, String mainPassword){
        return BCrypt.checkpw(password, mainPassword);
    }

}
