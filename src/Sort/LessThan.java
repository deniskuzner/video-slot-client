/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author User
 */
public class LessThan implements CompareOperator {
    
    @Override
    public <T extends Comparable> boolean compare(T a, T b) {
        return a.compareTo(b) < 0;
    }
    
}
