package com.lsk.combinationsumli.controller;

import com.lsk.combinationsumli.model.ResultResponse;
import com.lsk.combinationsumli.service.CombinationSumIi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 主页
 *
 * @author JoJo
 * @date 2020/02/16 17:15
 */
@RestController
public class IndexController {

    @Autowired
    private CombinationSumIi combinationSumIi;

    /**
     * 主页
     *
     * @return 主页
     */
    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("combination-sum-ii");
    }

    /**
     * 计算两组之和结果
     *
     * @param nums   数组
     * @param target 目标值
     * @return 列表
     */
    @PostMapping("combination")
    public ResultResponse combinationSumLi(@RequestParam(value = "nums[]", required = false) double[] nums, double target) {
        return this.combinationSumIi.combinationsumii(nums, target);
    }

}
