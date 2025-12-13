package uz.pdp.project.utils;

public class FileUtil {
    public static String getExtension(String originalName){
        return originalName.substring(originalName.lastIndexOf(".")+1);
    }
}
