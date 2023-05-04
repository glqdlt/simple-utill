package com.glqdlt.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author glqdlt
 */
public class DeepCopyUtil {

    /**
     * 
     * @param target 복사 대상이 되는 객체. 이 객체의 클래스는 implements Serializable 를 구현 해야함.
     * @return 속성이 복사된 새로운 객체
     */
    @SuppressWarnings("unchecked")
    public <T> T deepCopy(T target) {
        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
             ObjectDeepCopyStream.Output output = new ObjectDeepCopyStream.Output(arrayOutputStream)) {

            output.writeObject(target);

            try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
                 ObjectDeepCopyStream.Input input = new ObjectDeepCopyStream.Input(arrayInputStream)) {
                Object object = input.readObject();
                return (T) object;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
