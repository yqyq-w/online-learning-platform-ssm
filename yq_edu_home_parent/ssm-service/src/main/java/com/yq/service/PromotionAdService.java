package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.domain.PromotionAd;
import com.yq.domain.PromotionAdVO;

public interface PromotionAdService {

    /*
       分页查询广告信息
    */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
         广告动态上下线
     */
    public void  updatePromotionAdStatus(int id,int status);


}
