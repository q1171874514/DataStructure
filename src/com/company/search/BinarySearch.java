package com.company.search;

import com.company.sort.ComparisonSort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 二分搜索
 */
public class BinarySearch<T> {

    /**
     * 数组搜索（必须已排序）
     * @param data    搜索的数组
     * @param comp    判断大小的依据（a>b为降序了，a<b为升序）
     * @param target  查询目标
     * @param left    左边范围
     * @param right   右边范围
     * @return        查询到的下标
     */
    public Integer listSearch(List<T> data, BiFunction<T, T, Boolean> comp, T target, Integer left, Integer right) {
        Integer index = (left + right) / 2;
        while (left < right && !data.get(index).equals(target)) {
            if(comp.apply(data.get(index), target))
                left = index + 1;
            else
                right = index - 1;
            index = (left + right) / 2;
        }
        if(data.get(index).equals(target))
            return index;
        else
            return null;
    }

    /**
     * 数量计算
     * @param left       最小值
     * @param right      最大值
     * @param comp       判断大小的条件（true是小了，否则大了）
     * @param cyclicCondition   循环条件,满足循环
     * @param modify     中途值的修改
     * @return
     */
    public Double numCount(Double left, Double right, Predicate<Double> comp,
                           BiFunction<Double, Double, Boolean> cyclicCondition, BinaryOperator<Double> modify) {
        Double num = modify.apply(left, right);
        while (cyclicCondition.apply(left, right)) {
            if(comp.test(num))
                left = num;
            else
                right = num;
            num = modify.apply(left, right);
        }
        return num;
    }

    public static void main(String[] args) {
        BinarySearch<Integer> binarySearch = new BinarySearch<>();

        //查找数组指定值的下标，没有返回null
        List<Integer> data = new ArrayList<>();
        BiFunction<Integer, Integer, Boolean> comp = (a, b) -> a > b;
        Stream.iterate(2, (x) -> x + x / 2).limit(10).forEach(data::add);
        System.out.println(data);
        Integer taget = 5;
        Integer index = binarySearch.listSearch(data, (a, b) -> a < b, taget, 0, 9);
        System.out.println(taget + " : " +index);

        //从1到20寻找一个数字，1到20范围内小于这个数字的数字相乘和大于这个数字的数字相乘，他们的差最先
        BinaryOperator<Double> modify = (left, right) -> Double.valueOf(Math.round((left + right) / 2));
        Predicate<Double> comp1 = (num) -> {
            long left = 1, right = 1;
            for (int i = 2; i < num; i++)
                left *= i;
            for (int i = 20; i > num; i--)
                right *= i;

            return left < right;
        };
        BiFunction<Double, Double, Boolean> cyclicCondition = (left, right) -> {
            if(right <= left || right - left <= 1)
                return false;
            Double num = modify.apply(left, right);
            long left1 = 1, right1 = 1;
            for (int i = 2; i < num; i++)
                left1 *= i;
            for (int i = 20; i > num; i--)
                right1 *= i;
            return left1 != right1;
        };
        Double num = binarySearch.numCount(1d, 20d, comp1, cyclicCondition, modify);
        System.out.println(num);
        Long l = 1l, r = 1l;
        for(int i = 2; i < num; i ++)
            l *= i;
        for (int i = 20; i > num; i--)
            r *= i;
        System.out.println(r + " : " + l + " : " + (l - r));
    }
}
