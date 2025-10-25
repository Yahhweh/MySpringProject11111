package com.example.myspringproject.StudentServicePackage;

import java.util.ArrayList;
import java.util.List;

public class validationOfData {

    static boolean checkValidationOfName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = Character.toUpperCase(name.charAt(i));
            if (c < 'A' || c > 'Z') return false;
        }
        return true;
    }
}
