package com.glqdlt.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @author glqdlt
 */
public class JoinKeyAnnotationPredicate<LEFT, RIGHT> implements BiPredicate<LEFT, RIGHT> {
    @Override
    public boolean test(LEFT left, RIGHT right) {

        List<Field> findJoinKeyFields = new LinkedList<>();
        for (Field field : left.getClass().getDeclaredFields()) {
            Annotation annotation;
            annotation = field.getAnnotation(JoinKey.class);
            if (annotation != null) {
                findJoinKeyFields.add(field);
            }
        }

        return false;
    }
}
