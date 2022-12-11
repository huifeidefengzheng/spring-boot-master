package com.dexing.od1;

import java.util.*;
import java.util.logging.Handler;
import java.util.stream.Collectors;

/**
 * 有M台服务器，每台服务器有以下属性：编号、CPU核数（1~100）、内存、CPU架构（0~8）、是否支持NP加速的标识（0,1）。
 * 然后有一个资源分配要求，要求分配N台满足要求的服务器。
 * 具体如下：CPU核数>=cpuCount、内存>=memSize、CPU架构=cpuArch、是否支持NP加速=supportNP。
 * 其中，cpuCount、memSize、cpuArch、supportNP为这个要求输入的分配参数。 分配时会指定优先级策略，策略如下：
 *  策略1：CPU优先，优先选择CPU核数满足分配要求并且最接近分配要求的cpuCount。如果CPU核数相同，在按内存满足要求并选择最接近memSize的服务器分配。 
 *  策略2：内存优先，优先选择内存满足分配要求并且最接近分配要求的memSize。如果内存相同，在按cpu核数满足要求并选择最接近cpuCount的服务器分配 如果两台服务器属性都相同，则按服务器编号从小到大选择（编号不会重复）
 *  输入描述 
 *  第一行：服务器数量M 
 *  接下来M行为M台服务器属性的数组 
 *  下一行为分配要求：最大分配数量N，分配策略 strategy，cupCount，memSize，cpuArch，supportNP
 *  其中： 1<=M<=1000 1<=N<=1000
 *  strategy：1表示策略1,2表示策略2
 *  1<=cpuCount<=100
 *  10<=memSize<=1000
 *  0<=cpuArch<=8，另外，cpuArch使用9表示所有服务器架构都满足分配要求
 *  0<=supportNP<=1，另外，为2时表示无论是否支持NP加速都满足分配要求
 *  输出描述
 *  先输出实际分配数量，后按照分配的服务器编号从小到大依次输出，以空格分开
 *  样例1
 *  输入
 *  4
 *  0,2,200,0,1
 *  1,3,400,0,1
 *  2,3,400,1,0
 *  3,3,300,0,1
 *  3 1 3 200 0 1
 *  输出 2 1 3 说明 只有1和3满足要求，要求分配2台服务器，所以结果为2 1 3
 *  样例2
 *  输入
 *  6
 *  0,2,200,0,1
 *  1,4,330,2,1
 *  2,3,400,3,1
 *  3,3,310,1,1
 *  4,3,320,8,1
 *  5,3,330,0,1
 *  3 2 3 300 9 2
 *  输出 3 3 4 5
 *  说明 编号1~5都满足分配要求，按策略2分配即内存优先，内存>=300并且最接近300的服务器编号是3 4 1 5 2。
 *  其中1和5内存相同，然后会比较CPU，即CPU>=3且最接近的，所以5优先于1.因此最后分配的三台服务器是3 4 5。
 *  输出时先输出数量3，再按编号排序输出3 4 5
 */
public class D1459ServersSplit {
    public static void main(String[] args) {
        test1();

    }

    public static void test2() {
        //处理输入
        Scanner in=new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());
        int[][] server_matrix = new int[M][5];
        for (int i = 0; i < M; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < 5; j++) {
                server_matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = in.nextInt();
        int strategy = in.nextInt();
        int cpuCount = in.nextInt();
        int memSize = in.nextInt();
        int cpuArch = in.nextInt();
        int supportNP = in.nextInt();

        //筛选符合条件的服务器
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if (server_matrix[i][1] >= cpuCount && server_matrix[i][2] >= memSize
                    && (server_matrix[i][3] == cpuArch || cpuArch == 9)
                    && (server_matrix[i][4] == supportNP || supportNP == 2)) {
                map.put(server_matrix[i][0], Arrays.copyOfRange(server_matrix[i], 1, server_matrix[i].length));
            }
        }
        List<Map.Entry<Integer, int[]>> list = new ArrayList<Map.Entry<Integer, int[]>>(map.entrySet());
        // 如果策略1，先CPU核数，再内存，再编号
        if (strategy == 1) {
            list.sort((server1, server2) -> (server1.getValue()[0] == server2.getValue()[0] ? (server1.getValue()[1] == server2.getValue()[1] ?
                    server1.getKey() - server2.getKey() : server1.getValue()[1] - server2.getValue()[1]) :  server1.getValue()[0] - server2.getValue()[0]));
        }
        // 如果策略2，先内存，再CPU核数，再编号
        if (strategy == 2) {
            list.sort((server1, server2) -> (server1.getValue()[1] == server2.getValue()[1] ? (server1.getValue()[0] == server2.getValue()[0] ?
                    server1.getKey() - server2.getKey() : server1.getValue()[0] - server2.getValue()[0]) :  server1.getValue()[1] - server2.getValue()[1]));
        }
        int resCount = Math.min(map.size(), N);
        int[] res = new int[resCount];

        for (int i = 0; i < resCount; i++) {
            Map.Entry<Integer, int[]> entry = list.get(i);
            res[i] = entry.getKey();
        }
        Arrays.sort(res);
        System.out.print(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.print(" " + res[i]);
        }
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = Arrays.asList(scanner.nextLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
            lists.add(list);
        }
        List<Integer> collect = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        Integer num = collect.get(0);
        Integer strategy = collect.get(1);
        int count = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            if (checkTrue(integers,collect)) {
                map.put(integers.get(0), new int[]{integers.get(1),integers.get(2),integers.get(3),integers.get(4)});
            }
        }
        ArrayList<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
        // 如果策略1，先CPU核数，再内存，再编号
        if (strategy ==1) {
            list.sort((v1,v2) -> {
                return v1.getValue()[0] == v2.getValue()[0] ? (v1.getValue()[1] == v2.getValue()[1] ? v1.getKey()- v2.getKey():v1.getValue()[1]-v2.getValue()[1]) : v1.getValue()[0] -v2.getValue()[0];
            });
        }
        // 如果策略2，先内存，再CPU核数，再编号
        if (strategy == 2) {
            list.sort((v1,v2) -> (v1.getValue()[1]== v2.getValue()[1] ? (v1.getValue()[0] == v2.getValue()[0] ? v1.getKey() - v2.getKey():v1.getValue()[0]-v2.getValue()[0]):v1.getValue()[1] - v2.getValue()[1]));
        }
        int resCount = Math.min(map.size(),num);
        int[] res = new int[resCount];
        for (int i = 0; i < resCount; i++) {
            Map.Entry<Integer, int[]> integerEntry = list.get(i);
            res[i]= integerEntry.getKey();
        }
        Arrays.sort(res);
        System.out.print(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.print(" " + res[i]);
        }
    }

    private static boolean checkTrue(List<Integer> integers, List<Integer> collect) {
        int cpuArch = collect.get(4);
        int supportNP = collect.get(5);
        boolean flag = false;
        if (cpuArch == 9 && supportNP == 2) {
            if (integers.get(1) >= collect.get(2) && integers.get(2) >= collect.get(3)){
                flag = true;
            }
        } else if (cpuArch == 9 && supportNP != 2){
            if (integers.get(1) >= collect.get(2) && integers.get(2) >= collect.get(3) && integers.get(4) == supportNP ){
                flag = true;
            }
        } else if (cpuArch != 9 && supportNP == 2) {
            if (integers.get(1) >= collect.get(2) && integers.get(2) >= collect.get(3) && integers.get(3) == cpuArch ){
                flag = true;
            }
        } else {
            if (integers.get(1) >= collect.get(2) && integers.get(2) >= collect.get(3) && integers.get(3) == cpuArch && integers.get(4) == supportNP){
                flag = true;
            }
        }
        return flag;
    }


}
