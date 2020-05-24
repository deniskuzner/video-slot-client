/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author User
 */
public class Sort<T> {
    
    public void sort(List<T> list, CompareOperator compareOperator, Method fieldReadMethod) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        T pom;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (compareOperator.compare((Comparable) fieldReadMethod.invoke(list.get(i)), (Comparable) fieldReadMethod.invoke(list.get(j)))) {
                    pom = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, pom);
                }
            }
        }
    }
}
