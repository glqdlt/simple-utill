package com.glqdlt.support;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * @author glqdlt
 */
public class ObjectJoinUtil {

    public <LEFT, RIGHT, RESULT> List<RESULT> join(List<LEFT> left, List<RIGHT> right,
                                                   BiPredicate<LEFT, RIGHT> matcher,
                                                   JoinBinder<LEFT, RIGHT, RESULT> binder) {
        List<RIGHT> rightCopy = new ArrayList<>(right);
        List<RESULT> result = new ArrayList<>();
        for (LEFT l : left) {
            for (RIGHT r : rightCopy) {
                if (matcher.test(l, r)) {
                    RESULT res = binder.bind(l, r);
                    result.add(res);
                    rightCopy.remove(r);
                    break;
                }
            }
        }
        return result;
    }


}
