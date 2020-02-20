package com.lsk.combinationsumli.service;


import com.lsk.combinationsumli.model.ResultResponse;

/**
 * 组合总和
 * @author JoJo
 * @date 2020/02/16 18:29
 */
public interface CombinationSumIi {

    /**
     * 组合总和计算
     * @param candidates 需要计算的数
     * @param target 计算的目标
     * @return 结果列
     */
    ResultResponse combinationsumii(double[] candidates, Double target);
}
