package com.dexing.od1;

import java.util.*;

/**
 * <blockquote> 
 *  运维工程师采集到某产品线网运行一天产生的日志n条 
 *  现需根据日志时间先后顺序对日志进行排序 
 *  日志时间格式为H:M:S.N 
 *  H表示小时(0~23) 
 *  M表示分钟(0~59) 
 *  S表示秒(0~59) 
 *  N表示毫秒(0~999) 
 *  时间可能并没有补全 
 *  也就是说 
 *  01:01:01.001也可能表示为1:1:1.1 
 *  输入描述 
 *  第一行输入一个整数n表示日志条数，1<=n<=100000 接下来n行输入n个时间输出描述 
 *  按时间升序排序之后的时间 如果有两个时间表示的时间相同 则保持输入顺序
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  2 
 *  01:41:8.9 
 *  1:1:09.211 
 *  输出 
 *  1:1:09.211 
 *  01:41:8.9
 *
 *  示例2 输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3 
 *  23:41:08.023 
 *  1:1:09.211 
 *  08:01:22.0 
 *  输出 
 *  1:1:09.211 
 *  08:01:22.0 
 *  23:41:08.023
 *
 *  示例3 输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  2 
 *  22:41:08.023 
 *  22:41:08.23 
 *  输出 
 *  22:41:08.023 
 *  22:41:08.23 
 *  注：时间相同保持输入顺序
 */
public class D1254SordTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i -1; j++) {
                String string = strings[j];
                String string1 = strings[j+1];
                if (checkstr(string,string1)) {
                    strings[j+1] = string;
                    strings[j] = string1;
                }
            }
        }
        Arrays.asList(strings).stream().forEach(vo -> System.out.println(vo));
    }

    private static boolean checkstr(String string, String string1) {
        String[] split = string.split(":");
        String[] split1 = string1.split(":");
        for (int i = 0; i < 2; i++) {
            int i1 = Integer.parseInt(split[i]);
            int i2 = Integer.parseInt(split1[i]);
            if (i1 > i2) {
                return true;
            }
        }
        if (Double.parseDouble(split[2]) > Double.parseDouble(split1[2])) {
            return true;
        }
        return false;
    }

    public static void test2() {
        //处理输入
        Scanner in=new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> times = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            times.add(in.nextLine());
        }
        in.close();

        times.sort(Comparator.comparingLong(vo -> get_time(vo)));

        times.forEach(System.out::println);
    }
    // 字符串转long时间戳
    public static long get_time(String str) {
        String[] t1 = str.split(":");
        String[] t2 = t1[2].split("\\.");
        int h = Integer.parseInt(t1[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(t1[1]) * 60 * 1000;
        int s = Integer.parseInt(t2[0]) * 1000;
        int n = Integer.parseInt(t2[1]);
        return h + m + s + n;
    }
}
