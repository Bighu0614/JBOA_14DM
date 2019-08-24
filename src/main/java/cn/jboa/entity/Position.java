package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;
/**
 *职位
 *
 */
@SuppressWarnings("unchecked")
public class Position implements java.io.Serializable {

    private static final long serialVersionUID = -1777501621600424586L;
    private Integer id;
    private String nameCn;
    private String nameEn;

    /** default constructor */
    public Position() {
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
}