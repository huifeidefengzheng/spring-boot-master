package com.dexing.od;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 27.【we a are team[机房]】
 * 题目描述：
 *
 * 总共有n个人在机房，每个人有一个标号（1<=标号<=n），他们分成了多个团队，需要你根据收到的m条消息判定指定的两个人是否在一个团队中，具体的：
 * 1、消息构成为a b c，整数a、b分别代表两个人的标号，整数c代表指令
 * 2、c == 0代表a和b在一个团队内
 * 3、c == 1代表需要判定a和b的关系，如果a和b是一个团队，输出一行'we are a team',如果不是，输出一行'we are not a team'
 * 4、c为其他值，或当前行a或b超出1~n的范围，输出‘da pian zi'
 * 输入描述：
 * 1、第一行包含两个整数n，m(1<=n,m<100000),分别表示有n个人和m条消息
 * 2、随后的m行，每行一条消息，消息格式为：a b c(1<=a,b<=n,0<=c<=1)
 * 输出描述:
 * 1、c ==1,根据a和b是否在一个团队中输出一行字符串，在一个团队中输出‘we are a team',不在一个团队中输出'we are not a team’
 * 2、c为其他值，或当前行a或b的标号小于1或者大于n时，输出字符串‘da pian zi'
 * 3、如果第一行n和m的值超出约定的范围时，输出字符串'Null'
 * 输入：
 * 5 7
 * 1 2 0
 * 4 5 0
 * 2 3 0
 * 1 2 1
 * 2 3 1
 * 4 5 1
 * 1 5 1
 * 输出：
 * We are a team
 * We are a team
 * We are a team
 * We are not a team
 * 输入：
 * 5 6
 * 1 2 0
 * 1 2 1
 * 1 5 0
 * 2 3 1
 * 2 5 1
 * 1 3 2
 * 输出：
 * we are a team
 * we are not a team
 * we are a team
 * da pian zi
 */
public class D0923WeAreTeam {
    public static void main(String[] args) {
        String[] split = "1 3 4".split("\\s+");

    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int peoNum = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();

        }
    }

    public static void test2() {
        //存储一个队信息
        ArrayList<Set<Integer>> team=new ArrayList();
        int  n=5;
        int m=6;
        String s="1 2 0\r\n" +
                "1 2 1\r\n" +
                "1 5 0\r\n" +
                "2 3 1\r\n" +
                "2 5 1\r\n" +
                "1 3 2\r\n" +
                "1 4 1\r\n" +
                "3 4 0"
                ;
        String[] array=s.split("\\r\\n");
        for(int i=0;i<array.length;i++) {
            String[] split = array[i].split(" ");
            int a=Integer.valueOf(split[0]);
            int b=Integer.valueOf(split[1]);
            int c=Integer.valueOf(split[2]);
            if(a<1 || a>n) {
                System.out.println("da pian zi");
                continue;
            }
            if(b<1 || b>n) {
                System.out.println("da pian zi");
                continue;
            }
            if(c>1) {
                System.out.println("da pian zi");
                continue;
            }
            //判断是否在一个队中
            if(c==0) {
                //System.out.println("we are a team");
                //如果List中包含了其中一个，就把剩余的都放进去
                //如果都不包含，则创建新的队，放入到list中
                boolean flag=false;
                for(int j=0;j<team.size();j++){
                    if(team.get(j).contains(a) || team.get(j).contains(b)) {
                        team.get(j).add(a);
                        team.get(j).add(b);
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    HashSet<Integer> tmp=new HashSet();
                    tmp.add(a);
                    tmp.add(b);
                    team.add(tmp);
                }
            }else {
                //是否在一队
                boolean flag=false;
                for(int j=0;j<team.size();j++){
                    if(team.get(j).contains(a) && team.get(j).contains(b)) {
                        System.out.println("we are a team");
                        flag=true;
                        break;
                    }
                }
                if(!flag) {
                    System.out.println("we are not a team");
                }
            }
        }
    }
}
