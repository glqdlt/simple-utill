package com.glqdlt.support;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectJoinUtilTest {


    public static class A {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class B {
        private Integer id;
        private String name;
        private Integer option;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOption() {
            return option;
        }

        public void setOption(Integer option) {
            this.option = option;
        }
    }

    @Test
    public void simpleTest() {

        List<A> left = IntStream.range(1, 50000).boxed().map(x -> {
            A a = new A();
            a.setId(x);
            a.setName("a_" + x);
            return a;
        }).collect(Collectors.toList());

        List<B> right = IntStream.range(10000, 60000).boxed().map(x -> {
            B b = new B();
            b.setId(x);
            b.setOption(x);
            b.setName("b_" + x);
            return b;
        }).collect(Collectors.toList());

        ObjectJoinUtil objectJoinUtil = new ObjectJoinUtil();
        List<HashMap<String, Object>> res = objectJoinUtil.join(left, right,
                (a, b) -> a.getId().equals(b.getId()),
                (a, b) -> {
                    HashMap<String, Object> res1 = new LinkedHashMap<>();
                    res1.put("a_name", a.getName());
                    res1.put("b_name", b.getName());
                    res1.put("id", a.getId());
                    res1.put("b_option", b.getOption());
                    return res1;
                });
        Assert.assertEquals(40000, res.size());

    }
}