package com.company.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * 比较排序
 */
public class ComparisonSort<T> {
    private void swap(List<T> data, Integer a, Integer b) {
        T c = data.get(a);
        data.set(a, data.get(b));
        data.set(b, c);
    }
    //冒泡排序
    public void bubbleSort(List<T> data, BiFunction<T, T, Boolean> comp) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 1; j < data.size() - i; j++) {
                if (!comp.apply(data.get(j - 1), data.get(j)))
                    this.swap(data, j - 1, j);
            }
        }
    }
    //选择排序
    public void selectionSort(List<T> data, BiFunction<T, T, Boolean> comp) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (!comp.apply(data.get(i), data.get(j)))
                    this.swap(data, i, j);
            }
        }
    }

    //快速排序
    public void quckSort(List<T> data, BiFunction<T, T, Boolean> comp, Integer left, Integer right) {
        if(left >= right)
            return;
        Integer i = left, j = right;
        T base = data.get(left);

        while (i < j) {
            while (j > i && !comp.apply(data.get(j), base))
                j--;
            while (i < j && !comp.apply(base, data.get(i)))
                i ++;

            if (i < j)
                this.swap(data, i, j);
        }
        this.swap(data, left, i);
        quckSort(data, comp, left, i - 1);
        quckSort(data, comp, i + 1, right);
    }
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        ComparisonSort comparisonSort = new ComparisonSort();
        BiFunction<Integer, Integer, Boolean> comp = (a, b) -> a > b;
        Stream.iterate(0, (x) -> x + 1).limit(10).forEach(data::add);

        System.out.println(data);
        comparisonSort.bubbleSort(data, comp);
        System.out.println(data);

        data.clear();
        Stream.iterate(0, (x) -> x + 1).limit(10).forEach(data::add);
        System.out.println(data);
        comparisonSort.bubbleSort(data, comp);
        System.out.println(data);

        data.clear();
        Stream.iterate(0, (x) -> x + 1).limit(10).forEach(data::add);
        System.out.println(data);
        comparisonSort.quckSort(data, comp, 0, data.size() - 1);
        System.out.println(data);
    }
}
