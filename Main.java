import java.io.*;
import java.util.*;

public class Solution {
    public static void  main(String agr[]) {
        Scanner scn   = new Scanner(System.in);
        int n = scn.nextInt();
        int stones[] = new int[n];
        for(int i=0; i<n; i++){
            stones[i] = scn.nextInt();
        }
        Set<Integer> isContains = new HashSet<>();
        for(int i=0; i<n; i++){
            isContains.add(stones[i]);
        }
        boolean ans = isPossible(stones, -1, stones[n-1], 0 , isContains, 0);
        System.out.println(ans);
    }
    static boolean isPossible(int stones[], int prev,  int des, int k, Set<Integer> isContains, int curr ){
        if(curr == prev || curr > des || !isContains.contains(curr)){
            return false;
        }
        if(curr == des){
            return true;
        }
         // k-1
         // k
         // k+1 
        
        return isPossible(stones,curr, des, k-1,  isContains, curr+k-1) 
            || isPossible(stones,curr, des, k,  isContains, curr+k ) 
            || isPossible(stones,curr, des, k+1,  isContains, curr+k+1) ; 
    }
}
