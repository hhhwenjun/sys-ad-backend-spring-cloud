package com.imooc.ad.service;

import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {

    /** Create the ad plan */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;
    /** Obtain the ad plan */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;
    /** Update the ad plan */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;
    /** Delete the ad plan */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
