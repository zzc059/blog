package com.chenbo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 最终要上传的数据库映射类
 * 
 * @author 11366
 *
 */
@JsonIgnoreProperties
public class ArticleAndTagPojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer category_id;

	private String title;

	private String content;

	private Integer user_id;

	private String summary;
	
	
//	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date issue_time;

	/**
	 * 标签列表
	 */
	private List<Integer> tagIdList;

	private List<String> tagNameTagList;

	
	
	public Date getIssue_time() {
		return issue_time;
	}

	public void setIssue_time(Date issue_time) {
		this.issue_time = issue_time;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<Integer> getTagIdList() {
		return tagIdList;
	}

	public void setTagIdList(List<Integer> tagIdList) {
		this.tagIdList = tagIdList;
	}

	public List<String> getTagNameTagList() {
		return tagNameTagList;
	}

	public void setTagNameTagList(List<String> tagNameTagList) {
		this.tagNameTagList = tagNameTagList;
	}

	@Override
	public String toString() {
		return "ArticleAndTagPojo [category_id=" + category_id + ", title=" + title + ", content=" + content
				+ ", user_id=" + user_id + ", summary=" + summary + ", tagIdList=" + tagIdList + ", tagNameTagList="
				+ tagNameTagList + "]";
	}

}
