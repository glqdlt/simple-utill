package com.glqdlt.support;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

public class DeepCopyUtilTest {

    public static class Human implements Serializable {
        private String name;
        private Integer old;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOld() {
            return old;
        }

        public void setOld(Integer old) {
            this.old = old;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    @Test
    public void name() {

        Human human
                = new Human();
        human.setGender("man");
        human.setName("batman");
        human.setOld(30);
        DeepCopyUtil deepCopyUtil = new DeepCopyUtil();
        Human copyhuman = deepCopyUtil.deepCopy(human);
        Assert.assertNotSame(human, copyhuman);
        Assert.assertEquals(human.getGender(), copyhuman.getGender());
        Assert.assertEquals(human.getName(), copyhuman.getName());
    }
}