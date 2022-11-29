package com.dexing.od;

/**
 * 给定一组不等式，判断是否成立并输出不等式的最大差(输出浮点数的整数部分)，要求：1）不等式系数为double类型，是一个二维数组；2）不等式的变量为int类型，是一维数组；3）不等式的目标值为double类型，是一维数组；4）不等式约束为字符串数组，只能是：“>”,“>=”,“<”,“<=”,“=”，例如,不等式组：
 * a11x1+a12x2+a13x3+a14x4+a15x5<=b1;
 * a21x1+a22x2+a23x3+a24x4+a25x5<=b2;
 * a31x1+a32x2+a33x3+a34x4+a35x5<=b3;
 * 最大差=max{ (a11x1+a12x2+a13x3+a14x4+a15x5-b1), (a21x1+a22x2+a23x3+a24x4+a25x5-b2), (a31x1+a32x2+a33x3+a34x4+a35x5-b3) }，类型为整数(输出浮点数的整数部分)
 * 输入描述:
 * 1）不等式组系数(double类型)：
 * a11,a12,a13,a14,a15
 * a21,a22,a23,a24,a25
 * a31,a32,a33,a34,a35
 * 2）不等式变量(int类型)：
 * x1,x2,x3,x4,x5
 * 3）不等式目标值(double类型)：b1,b2,b3
 * 4)不等式约束(字符串类型):<=,<=,<=
 * 输入：a11,a12,a13,a14,a15;a21,a22,a23,a24,a25;a31,a32,a33,a34,a35;x1,x2,x3,x4,x5;b1,b2,b3;<=,<=,<=
 * 输出描述:
 * true 或者 false, 最大差
 * 示例1
 * 输入
 * 2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 * 输出
 * false 458
 * 示例2
 * 输入
 * 2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=
 * 输出
 * false 758
 */
public class D1859OddsMax {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        String str = "2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=";
        String[] split = str.split(";");
        String[] split1 = split[0].split(",");
        String[] split2 = split[1].split(",");
        String[] split3 = split[2].split(",");
        String[] xx = split[3].split(",");
        Double a1 = getOne(split1,xx);
        Double a2 = getTwo(split2,xx);
        Double a3 = getThree(split3,xx);
        Double[] doubles = {a1,a2,a3};
        String[] bbs = split[4].split(",");
        String[] jedus = split[5].split(",");
        boolean isb = true;
        for (int i = 0; i < bbs.length; i++) {
            int je = switchModue(jedus[i]);
            isb = checkRes(je,doubles,bbs,i);
            if (!isb) {
                break;
            }
        }
        Double resD = 0.0;
        for (int i = 0; i < bbs.length; i++) {
            double v = doubles[i] - Double.parseDouble(bbs[i]);
            resD = Math.max(v,resD);
        }
        System.out.println(isb +" " + resD.intValue());
    }

    private static boolean checkRes(int je, Double[] doubles, String[] bbs, int i) {
        if (je == 1) {
            if (doubles[i] > Double.parseDouble(bbs[i])) {
                return false;
            }
        } else if (je == 2) {
            if (doubles[i] >= Double.parseDouble(bbs[i])) {
                return false;
            }
        } else if (je == 3) {
            if (doubles[i] < Double.parseDouble(bbs[i])) {
                return false;
            }
        } else if (je == 4) {
            if (doubles[i] <= Double.parseDouble(bbs[i])) {
                return false;
            }
        }else if (je == 8) {
            if (doubles[i] != Double.parseDouble(bbs[i])) {
                return false;
            }
        }
        return true;
    }

    private static int switchModue(String jedus) {
        switch (jedus){
            case "<":
                return 1;
            case "<=":
                return 2;
            case ">":
                return 3;
            case ">=":
                return 4;
            default:
                return 5;
        }
    }

    private static Double getThree(String[] split3, String[] xx) {
        Double res = 0.0;
        for (int i = 0; i < xx.length; i++) {
            res += Integer.parseInt(xx[i]) * Double.parseDouble(split3[i]);
        }
        return res;
    }

    private static Double getTwo(String[] split2, String[] xx) {
        Double res = 0.0;
        for (int i = 0; i < xx.length; i++) {
            res += Integer.parseInt(xx[i]) * Double.parseDouble(split2[i]);
        }
        return res;
    }

    private static Double getOne(String[] split1, String[] xx) {
        Double res = 0.0;
        for (int i = 0; i < xx.length; i++) {
            res += Integer.parseInt(xx[i]) * Double.parseDouble(split1[i]);
        }
        return res;
    }
}
