package cn.jboa.entity;

import java.util.Date;

/**
 * BizClaimVouyearStatistics entity. @author MyEclipse Persistence Tools
 */

public class ClaimVouyearStatistics implements java.io.Serializable {

	// Fields

	private Long id;
	private Double totalCount;
	private int year;
	private Date modifyTime;
	private Department dept;

	// Constructors

	/** default constructor */
	public ClaimVouyearStatistics() {
	}

	/** full constructor */
	public ClaimVouyearStatistics(Long id, Double totalCount, Short year,
			Date modifyTime) {
		this.id = id;
		this.totalCount = totalCount;
		this.year = year;
		this.modifyTime = modifyTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}