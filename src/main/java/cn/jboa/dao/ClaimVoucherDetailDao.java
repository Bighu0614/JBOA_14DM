package cn.jboa.dao;

import cn.jboa.entity.ClaimVoucherDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimVoucherDetailDao {
    void save(List<ClaimVoucherDetail> cvd);

    void del(String no,List<Integer> item);
}
