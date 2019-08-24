package cn.jboa.service;


import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;

import java.util.List;

public interface ClaimVoucherService {

    List<ClaimVoucher> showInfo(ClaimVoucher cv, int first, int last);

    int getPageCount(String sn);

    ClaimVoucher toUpdate(int id);

    void updateInfo(ClaimVoucher cv,List<ClaimVoucherDetail> cvds,List<Integer> ids);

    void delInfo(ClaimVoucher claimVoucher);
}
