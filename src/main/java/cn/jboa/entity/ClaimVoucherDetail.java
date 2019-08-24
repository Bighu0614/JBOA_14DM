package cn.jboa.entity;

import javax.persistence.Table;

/**
 * 
 *
 */
public class ClaimVoucherDetail implements java.io.Serializable {

    private static final long serialVersionUID = 8187404228626478972L;
    private int id;
    private ClaimVoucher bizClaimVoucher;
    private String item;
    private Double account;
    private String desc;

    /** default constructor */
    public ClaimVoucherDetail() {
    }

    /** full constructor */
    public ClaimVoucherDetail(ClaimVoucher bizClaimVoucher,
            String item, Double account, String desc) {
        this.bizClaimVoucher = bizClaimVoucher;
        this.item = item;
        this.account = account;
        this.desc = desc;
    }

    public ClaimVoucherDetail(String item, Double account, String desc) {
        this.item = item;
        this.account = account;
        this.desc = desc;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClaimVoucher getBizClaimVoucher() {
        return this.bizClaimVoucher;
    }

    public void setBizClaimVoucher(ClaimVoucher bizClaimVoucher) {
        this.bizClaimVoucher = bizClaimVoucher;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAccount() {
        return this.account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}