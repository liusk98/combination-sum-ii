package com.lsk.combinationsumli.service.impl;

import com.lsk.combinationsumli.model.ResultResponse;
import com.lsk.combinationsumli.service.CombinationSumIi;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 组合总和实现
 *
 * @author JoJo
 * @date 2020/02/16 18:32
 */
@Service
public class CombinationSumIiImpl implements CombinationSumIi {

    @Override
    public ResultResponse combinationsumii(double[] candidates, Double target) {
        ResultResponse result = new ResultResponse(ResultResponse.FAIL, "", null);
        try {
            List<Map<String, Object>> resultList = new ArrayList<>();
            List<List<Double>> calculation = this.combinationSum2(candidates, target);
            for (int i = 0; i < calculation.size(); i++) {
                Map<String, Object> resultMap = new HashMap<>();
                resultMap.put("result", "第" + (i + 1) + "个结果集");
                StringBuffer doubles = new StringBuffer();
                for (Double aDouble : calculation.get(i)) {
                    doubles.append(aDouble + "   ");
                }
                resultMap.put("res", doubles.toString());
                resultList.add(resultMap);
            }
            result.setCode(ResultResponse.SUCCESS);
            result.setResult(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ResultResponse.FAIL);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    private List<List<Double>> ans = new ArrayList<>();
    private double[] visited;

    public List<List<Double>> combinationSum2(double[] candidates, double target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        visited = new double[candidates.length];
        List<Double> list = new ArrayList<>();
        findList(list, 0, 0, candidates, target);
        return ans;
    }


    public void findList(List<Double> list, double sum, int index, double[] candidates, double target) {
        if (Double.valueOf(sum).equals(target)) {
            ans.add(new ArrayList<>(list));
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                    return;
                }
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                findList(list, sum + candidates[i], i + 1, candidates, target);
                list.remove(list.size() - 1);
            }
        } else {
            return;
        }
    }
}
