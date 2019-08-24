package cn.jboa.entity;

import java.util.Date;

/**
 * ClaimVoucherStatistics entity. @author MyEclipse Persistence Tools
 */

public class ClaimVoucherStatistics implements java.io.Serializable {

	// Fields

	private Long id;
	private Double totalCount;
	private int year;
	private int month;
	private Department department;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public ClaimVoucherStatistics() {
	}

	/** full constructor */
	public ClaimVoucherStatistics(Long id, Double totalCount, Integer year,
			Integer month, Department department, Date modifyTime) {
		this.id = id;
		this.totalCount = totalCount;
		this.year = year;
		this.month = month;
		this.department = department;
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

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}