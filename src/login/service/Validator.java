package login.service;

import login.annotations.Email;
import login.annotations.MinLegth;
import login.annotations.NotNull;
import login.annotations.Range;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validate(Object obj) {
        boolean isValid = true;
        Class<?> userReflection = obj.getClass();

        for (Field field : userReflection.getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object value = field.get(obj);

                //Null check
                if(field.isAnnotationPresent(NotNull.class)){
                    if(value == null){
                        System.out.println(field.getName() + "can not be null!");
                        isValid = false;
                        continue;
                    }
                }

                //Legth check
                if (field.isAnnotationPresent(MinLegth.class)){
                    int min = field.getAnnotation(MinLegth.class).value();
                    String val = (String) value;
                    if(val == null || val.length() < min){
                        System.out.println(field.getName() + " must be least" + min + " characters!");
                        isValid = false;
                    }
                }

                //Email check
                if(field.isAnnotationPresent(Email.class)){
                    String val = (String)value;
                    if(val == null || !Pattern.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", val )){
                        System.out.println(field.getName() + " is not a valid email! ");
                        isValid = false;
                    }
                }

                //Range check
                if(field.isAnnotationPresent(Range.class)){
                    Range range = field.getAnnotation(Range.class);
                    int min = range.min();
                    int max = range.max();
                    int val = (int) value;

                    if(val < min || val > max){
                        System.out.println(field.getName() + " must be between" + min + " and" + max + "!");
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                isValid = false;
            }
        }
        if(isValid){
            System.out.println("Validation passed successfully!");
        }
        return isValid;
    }
}
