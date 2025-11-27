package uz.pdp.project.utils;

import uz.pdp.project.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface DB {
    List<User> users = Collections.synchronizedList(new ArrayList<>());
}
