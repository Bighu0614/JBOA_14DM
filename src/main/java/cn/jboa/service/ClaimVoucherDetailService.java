package cn.jboa.service;


import cn.jboa.entity.ClaimVoucherDetail;

import java.util.List;

public interface ClaimVoucherDetailService {
    void save(List<ClaimVoucherDetail> cvd);

    void del(String no,List<Integer> item);

}
