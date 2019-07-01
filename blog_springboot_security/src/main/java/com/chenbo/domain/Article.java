package com.chenbo.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int article_id;
	private int category_id;
	private String title;
	private String content;
	private int user_id;
	
//	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date issue_time;
	private int scan_num;
	private String img_path;
	private String summary;
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getIssue_time() {
		return issue_time;
	}
	public void setIssue_time(Date issue_time) {
		this.issue_time = issue_time;
	}
	public int getScan_num() {
		return scan_num;
	}
	public void setScan_num(int scan_num) {
		this.scan_num = scan_num;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", category_id=" + category_id + ", title=" + title + ", content="
				+ content + ", user_id=" + user_id + ", issue_time=" + issue_time + ", scan_num=" + scan_num
				+ ", img_path=" + img_path + ", summary=" + summary + "]";
	}
	
	
}
