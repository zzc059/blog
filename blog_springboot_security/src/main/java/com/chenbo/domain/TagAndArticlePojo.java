package com.chenbo.domain;
/**
 * @author 11366
 * 这个类是标签对应映射到所对应的文章的类
 */
import java.io.Serializable;
import java.util.List;

public class TagAndArticlePojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tag_id;
	private String tag_name;
	private List<Article> articleList;
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	@Override
	public String toString() {
		return "TagAndArticlePojo [tag_id=" + tag_id + ", tag_name=" + tag_name + ", articleList=" + articleList + "]";
	}
	
	
}
