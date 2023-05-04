package com.glqdlt.support;

@FunctionalInterface
public interface JoinBinder<LEFT, RIGHT, RESULT> {

    RESULT bind(LEFT left, RIGHT right);

}
