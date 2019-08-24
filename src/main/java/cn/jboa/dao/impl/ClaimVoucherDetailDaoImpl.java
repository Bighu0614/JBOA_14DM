package cn.jboa.dao.impl;

import cn.jboa.dao.ClaimVoucherDetailDao;
import cn.jboa.entity.ClaimVoucherDetail;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class ClaimVoucherDetailDaoImpl extends HibernateDaoSupport implements ClaimVoucherDetailDao {
    /**
     * 批量保存报销详情单数据
     * @param cvd  数据对象
     */
    @Override
    public void save(List<ClaimVoucherDetail> cvd) {
        for (ClaimVoucherDetail cvd1 : cvd){
            this.getHibernateTemplate().save(cvd1);
        }

    }

    /**
     * 删除不包含在集合中的id的记录
     * @param item
     */
    @Override
    public void del(String no,List<Integer> item) {
        StringBuffer sb = new StringBuffer();
        sb.append("delete from ClaimVoucherDetail where MAIN_ID = "+no+" ");
        for (Integer id : item){
            if (id!=null){
                sb.append("and instr(id,"+id+")<=0 ");
            }
        }
        this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(sb.toString());
                return query.executeUpdate();
            }
        });
    }

}
