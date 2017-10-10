package com.dms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Bug implements Serializable {
 
	private Integer bug_id;// 缺陷id
	private String bug_summary;// 缺陷主题
	private Integer pro_id;// 项目id
	private Integer pon_id;// 严重级别id
	private Integer bug_status;// 缺陷状态
	private String bug_os;// 缺陷产生系统
	private String bug_description;// 缺陷描述
	private String bug_priority;// 缺陷优先级
	private String bug_comment; // 缺陷评论
	private Integer reporter_id;// 提交者id
	private Integer handler_id;// 处理中id

	private Date submite_time; // 缺陷提交时间

	public Integer getBug_id() {
		return bug_id;
	}

	public void setBug_id(Integer bug_id) {
		this.bug_id = bug_id;
	}

	public String getBug_summary() {
		return bug_summary;
	}

	public void setBug_summary(String bug_summary) {
		this.bug_summary = bug_summary;
	}

	public Integer getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public Integer getPon_id() {
		return pon_id;
	}

	public void setPon_id(Integer pon_id) {
		this.pon_id = pon_id;
	}

	public Integer getBug_status() {
		return bug_status;
	}

	public void setBug_status(Integer bug_status) {
		this.bug_status = bug_status;
	}

	public String getBug_os() {
		return bug_os;
	}

	public void setBug_os(String bug_os) {
		this.bug_os = bug_os;
	}

	public String getBug_description() {
		return bug_description;
	}

	public void setBug_description(String bug_description) {
		this.bug_description = bug_description;
	}

	public String getBug_priority() {
		return bug_priority;
	}

	public void setBug_priority(String bug_priority) {
		this.bug_priority = bug_priority;
	}

	public String getBug_comment() {
		return bug_comment;
	}

	public void setBug_comment(String bug_comment) {
		this.bug_comment = bug_comment;
	}

	public Integer getReporter_id() {
		return reporter_id;
	}

	public void setReporter_id(Integer reporter_id) {
		this.reporter_id = reporter_id;
	}

	public Integer getHandler_id() {
		return handler_id;
	}

	public void setHandler_id(Integer handler_id) {
		this.handler_id = handler_id;
	}

	public Date getSubmite_time() {
		return submite_time;
	}

	public void setSubmite_time(Date submite_time) {
		this.submite_time = submite_time;
	}

	@Override
	public String toString() {
		return "Bug [bug_id=" + bug_id + ", pon_id=" + pon_id + ", priority="
				+ bug_priority + ", summary=" + bug_summary + ", bug_status="
				+ ", bug_comment=" + bug_comment + ", bug_os=" + bug_os
				+ ", bug_description=" + bug_description + ", submite_time="
				+ submite_time + ", handler_id=" + handler_id
				+ ", reporter_id=" + reporter_id + "]";
	}

}