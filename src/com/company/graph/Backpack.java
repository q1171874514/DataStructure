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
    public Double ZeroOneBackpack(Integer volume, Integer num, Integer[] weight, Double[] value) {
        Double[] sum = new Double[volume + 1];
        for (int i = 0; i < volume + 1; i++)
            sum[i] = 0d;
        for (int i = 0; i < num; i ++)
            for (int j = volume; j >=weight[i]; j--)
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[j]);

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
    public Double completeBackpack(Integer volume, Integer num, Integer[] weight, Double[] value) {
        Double[] sum = new Double[volume + 1];
        for (int i = 0; i < volume + 1; i++)
            sum[i] = 0d;
        for (int i = 0; i < num; i ++)
            for (int j = weight[i]; j <= volume; j--)
                sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[j]);

        return sum[volume];
    }

    /**
     * 多重背包
     * @param volume      背包容量
     * @param num         物品数量
     * @param singleNum   单个物品数量
     * @param weight      物品重量
     * @param value       物品价值
     * @return
     */
    public Double multipleBackpack(Integer volume, Integer num, Integer[] singleNum, Integer[] weight, Double[] value) {
        Double[] sum = new Double[volume + 1];
        for (int i = 0; i < volume + 1; i++)
            sum[i] = 0d;

        for (int i = 0; i < num; i ++)
            for (int k = 1; k <= singleNum[i]; k++)
                for (int j = weight[i]; j <= volume; j--)
                    sum[j] = Math.max(sum[j], sum[j - weight[i]] + value[j]);

        return sum[volume];
    }


}
