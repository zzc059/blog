package com.chenbo.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class SimpleArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int article_id;
	
	private String title;
	
	private Integer user_id;

	private String summary;
	
	 
//	private Date issue_time;
	
	private Integer category_id;
	
	private String content;
	
	//新加的字段
	private String username;
	private String img_path;
	
	
	private List<String> tagNameList;

	private List<Integer> tagIdList;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
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

	/*public String getIssue_time() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(issue_time);
	}

	public void setIssue_time(Date issue_time) {
		this.issue_time = issue_time;
	}*/

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public List<Integer> getTagIdList() {
		return tagIdList;
	}

	public void setTagIdList(List<Integer> tagIdList) {
		this.tagIdList = tagIdList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTagNameList() {
		return tagNameList;
	}

	public void setTagNameList(List<String> tagNameList) {
		this.tagNameList = tagNameList;
	}

	@Override
	public String toString() {
		return "SimpleArticle [article_id=" + article_id + ", title=" + title + ", user_id=" + user_id + ", summary="
				+ summary + ", issue_time=" + "" + ", category_id=" + category_id + ", content=" + content
				+ ", username=" + username + ", img_path=" + img_path + ", tagNameList=" + tagNameList + ", tagIdList="
				+ tagIdList + "]";
	}

	

	

	

}
