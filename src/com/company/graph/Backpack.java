package com.company.graph;

/**
 * 背包算法
 */
public class Backpack {
    /**
     * 01背包
     * @param volume      背包容量
     * @param num         物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Integer ZeroOneBackpack(Integer volume, Integer num, Integer[] weight, Integer[] value) {
        Integer[] sum = new Integer[volume + 1];
        for (int i = 0; i < volume + 1; i++)
            sum[i] = 0;
        for (int i = 0; i < num; i ++) {
            for (int j = volume; j >=weight[i]; j--) {
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[j]);
            }
        }
        return sum[volume];
    }

    /**
     * 完全背包
     * @param volume      背包容量
     * @param num         物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Integer completeBackpack(Integer volume, Integer num, Integer[] weight, Integer[] value) {
        Integer[] sum = new Integer[volume + 1];
        for (int i = 0; i < volume + 1; i++)
            sum[i] = 0;
        for (int i = 0; i < num; i ++) {
            for (int j = weight[i]; j <= volume; j--) {
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[j]);
            }
        }
        return sum[volume];
    }
}
