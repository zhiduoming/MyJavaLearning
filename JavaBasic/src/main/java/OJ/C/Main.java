package OJ.C;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer,Integer> totalMap =new HashMap<>();
        Map<Integer,Integer> articleCountMap =new HashMap<>();
        for (int i = 0; i < n; i++) {
            //文章中共有 k 个单词
            int k = sc.nextInt();
            Set<Integer> set =new HashSet<>();
            for (int j = 0; j < k; j++) {
                //每个单词
                int word = sc.nextInt();
                totalMap.put(word,totalMap.getOrDefault(word,0)+1);
                set.add(word);
            }
            for (Integer word : set) {
                articleCountMap.put(word,articleCountMap.getOrDefault(word,0) +1 );
            }
        }
        for (int i = 1; i <= m; i++) {
            System.out.println(articleCountMap.get(i)+" "+ totalMap.get(i));
        }
    }
}
