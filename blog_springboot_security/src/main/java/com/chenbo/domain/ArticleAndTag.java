package com.chenbo.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class ArticleAndTag implements Serializable {

	/**
	 * 文章和标签的中间表
	 */
	private static final long serialVersionUID = 1L;

	private int article_id;
	private int tag_id;
	private int article_tag_id;
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public int getArticle_tag_id() {
		return article_tag_id;
	}
	public void setArticle_tag_id(int article_tag_id) {
		this.article_tag_id = article_tag_id;
	}
	@Override
	public String toString() {
		return "ArticleAndTag [article_id=" + article_id + ", tag_id=" + tag_id + ", article_tag_id=" + article_tag_id
				+ "]";
	}
	
	
}
