package com.duannd.java11.features;

import java.util.List;

/**
 * Created By ngdduan@gmail.com at 12/1/18 1:38 PM
 */
public class ExCollections {

    public static void main(String args[]) throws Exception {

        var list = List.of(1, 2, 3); // return List<Integer> immutable
        System.out.println(list);

        /* Throw exception if modify data */
        // list.add(1);

        var copyList = List.copyOf(list); // return a List<Integer> immutable.
        System.out.println("list == copyList ? " + (list == copyList));

        /* Immutable object can't modify */
        // copyList.set(1, 3);

        /*  */
    }

}
