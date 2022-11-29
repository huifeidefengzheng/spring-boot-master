package com.dexing.od;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，用户会进行一系列内存申请，需要按需分配内存池中的资源，返回申请结果成功失败列表。分配规则如下：
 * 1、分配的内存要大于等于内存申请量，存在满足需求的内存就必须分配，优先分配粒度小的，但内存不能拆分使用。
 * 2、需要按申请顺序分配，先申请的先分配。
 * 3、有可用内存分配则申请结果为true，没有可用内存分配则返回false。
 * 注：不考虑内存释放。
 * 输入描述:
 * 输入为两行字符串：
 * 第一行为内存池资源列表，包含内存粒度数据信息，粒度数据间用逗号分割，一个粒度信息内部用冒号分割，冒号前为内存粒度大小，冒号后为数量。资源列表不大于1024，每个粒度的数量不大于4096
 * 第二行为申请列表，申请的内存大小间用逗号分隔。申请列表不大于100000
 * 如：
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 输出描述:
 * 输出为内存池分配结果。
 * 如：
 * true,true,true,false,false
 * 示例1
 * 输入
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 输出
 * true,true,true,false,false
 * 说明
 * 内存池资源包含：64K共2个、128K共1个、32K共4个、1K共128个的内存资源；
 * 针对50,36,64,128,127的内存申请序列，分配的内存依次是：64,64,128,NULL,NULL,第三次申请内存时已经将128分配出去，
 * 因此输出结果是：true,true,true,false,false
 */
public class D1858CacheShare {
    public static void main(String[] args) {
        String str = "50,36,64,";
        System.out.println(str.substring(0,str.length() -1));
        test();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        String[] apply = sc.nextLine().split(",");
        List<Integer> exist = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] typeCount = input[i].split(":");
            int type = Integer.parseInt(typeCount[0]);
            exist.add(type);
            map.put(type,Integer.parseInt(typeCount[1]));
        }
        Collections.sort(exist);
        for (int i = 0; i < apply.length; i++) {
            boolean flag = false;
            int need = Integer.parseInt(apply[i]);
            for (int j = 0; j < exist.size(); j++) {
                if (need<= exist.get(j)){
                    //拿出来一个
                    int pool = map.get(exist.get(j));
                    flag = true;
                    if (--pool == 0){
                        map.remove(exist.get(j));
                        exist.remove(j);
                    }else {
                        map.put(exist.get(j),pool);
                    }
                    break;
                }
            }
            System.out.print(flag + " ");
        }
        System.out.println();
    }

    public static void test() {
        String source = "64:2,128:1,32:4,1:128";
        String qurie = "50,36,64,128,127";
        ArrayList<Cache> caches = new ArrayList<>();
        String[] split = source.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(":");
            Cache cache = new Cache(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
            caches.add(cache);
        }
        List<Cache> list = caches.stream().sorted().collect(Collectors.toList());
        System.out.println(1);
        String[] split1 = qurie.split(",");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < split1.length; i++) {
            int i1 = Integer.parseInt(split1[i]);
            boolean isSource = false;
            for (int j = 0; j < list.size(); j++) {
                Cache cache = list.get(j);
                isSource = checkSource(i1,j,list);
                if (isSource) {
                    buffer.append("true,");
                    break;
                }
            }
            if (!isSource) {
                buffer.append("false,");
            }
        }
        System.out.println(buffer.substring(0,buffer.length()-1));

    }

    private static boolean checkSource(int i1, int j, List<Cache> list) {
        Cache ca = list.get(j);
        if (ca.cache >= i1 && ca.getNum() > 0 ) {
            ca.setNum(ca.getNum() -1);
            list.add(j,ca);
            return true;
        } else {
            return false;
        }
    }

    static class Cache implements Comparable<Cache>{
        private Integer cache;
        private Integer num;


        public Cache() {
        }

        public Integer getCache() {
            return cache;
        }

        public void setCache(Integer cache) {
            this.cache = cache;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Cache(Integer cache, Integer num) {
            this.cache = cache;
            this.num = num;
        }

        @Override
        public int compareTo(Cache o) {

            return this.cache - o.cache;
        }
    }
}
