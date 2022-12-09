package com.dexing.od1;


import java.util.*;

/**
 *  考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，请你写个程序来把之前石碑上文字可能的组合全部写出来，按升序进行排列。 
 *  输入描述:
 *  第一行输入n，n表示石碑碎片的个数。
 *  第二行依次输入石碑碎片上的文字内容s，共有n组。
 *  输出描述:
 *  输出石碑文字的组合(按照升序排列)，行末无多余空格。
 *  示例1  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3 
 *  a b c 
 *  输出 
 *  abc 
 *  acb 
 *  bac 
 *  bca 
 *  cab 
 *  cba 
 *  示例2  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3 
 *  a b a 
 *  输出 
 *  aab 
 *  aba 
 *  baa
 *
 *  思路：
 *  1：排列组合问题，简单的 DFS 应用。全排列，是含有重复元素的全排列的问题，按任意顺序返回所有不重复的全排列。 
 *  2：剪枝算法，在遍历的过程中，一边遍历一遍检测，在一定会产生重复结果集的地方剪枝。 
 *  如果要比较两个列表是否一样，一个容易想到的办法是对列表分别排序，然后逐个比对。
 *  既然要排序，我们就可以在搜索之前就对候选数组排序，一旦发现某个分支搜索下去可能搜索到重复的元素就停止搜索，这样结果集中不会包含重复列表。
 *
 */
public class D1047KaoGu {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //注意这里需要多输入一行，否则输入不正确
        in.nextLine();
        String[] char_array = in.nextLine().split(" ");
        List<List<String>> result = new ArrayList<>();

        //先排序
        Arrays.sort(char_array);
        //path中存储已经使用过的数字
        Deque<String> path = new ArrayDeque<>();
        //记录每个数字是否被使用过
        boolean[] used = new boolean[n];
        dfs(char_array, 0, path, used, result);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(String.join("", result.get(i)));
        }
    }

    private static void dfs(String[] char_array, int depth, Deque<String> path, boolean[] used, List<List<String>> result) {
        if (depth == char_array.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < char_array.length; i++) {
            // 如果使用过，则跳出，剪枝的地方
            if (used[i]) {
                continue;
            }
            if (i > 0 && char_array[i].equals(char_array[i - 1]) && !used[i - 1]) {
                continue;
            }
            path.addLast(char_array[i]);
            used[i] = true;
            dfs(char_array, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void test() {
        int n = 3;
        List<String> list = Arrays.asList("a b a".split(" "));
        List<List<String>> result = new ArrayList<>();
        Collections.sort(list);

    }

}
