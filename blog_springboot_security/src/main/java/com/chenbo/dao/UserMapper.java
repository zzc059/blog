package com.chenbo.dao;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.chenbo.domain.Article;
import com.chenbo.domain.Issue;
import com.chenbo.domain.SimpleArticle;
import com.chenbo.domain.User;

@Mapper
@Repository
public interface UserMapper {

	@Insert("insert into user(username,password,phone,email,create_time,grant_level) values(#{username},md5(#{password}),#{phone},#{email},#{create_time,jdbcType=DATE},#{grant_level})")
	void addUser(User user);
	
	@Select("SELECT * FROM USER WHERE phone=#{phone}")
	User findUserByPhoneNumber(String phone);
	
	@Select("select * from user where username=#{username}")
	User findUserByUsername(String username);
	
	@Select("SELECT * FROM USER WHERE email=#{email}")
	User findUserByEmail(String email);
	
	@Select("select * from user where user_id=#{user_id}")
	User findUserByUserId(int id);
	
	@Update("update user set password=md5(#{newPassword}) where user_id=#{user_id}")
	void updateUserPassword(String newPassword,String oldPassword,int user_id);
	
	@Update("update user set email=#{email} where user_id=#{user_id}")
	void updateUserEmail(String email,int user_id);
	
	//得到最新的10条数据
	@Select("SELECT article_id FROM article ORDER BY issue_time DESC LIMIT 0,10")
	List<Integer> findPopularArticle();
	
	//通过user_id来查找username
	@Select("select username from user where user_id=#{user_id}")
	String findUsernameByUserId(int user_id);
	//通过user_id和title还有category_id来查找article_id
	@Select("SELECT article_id FROM article WHERE category_id=#{categoryId} AND title=#{title} AND user_id=#{userId}")
	int findArticleIdByManyoption(int categoryId,String title,int userId);
	//插入文章到数据库
	@Insert("INSERT INTO article(category_id,title,content,user_id,issue_time,"
			+ "scan_num,img_path,summary)VALUES(#{category_id},#{title},#{content},#{user_id},"
			+ "#{issue_time,jdbcType=DATE},#{scan_num},#{img_path},#{summary})")
	@Options(useGeneratedKeys = true,keyProperty = "article_id")
	void addArticle(Article article);
	//插入到中间表
	@Insert("INSERT INTO article_tag(tag_id,article_id)VALUES(#{tag_id},#{article_id})")
	void addArticleAndTag(int tag_id,int article_id);
	//插入到标签表
	@Insert("INSERT INTO tag(tag_name)VALUES(#{tagName})")
	void addTag(String tagName);
	//通过标签名来查找标签的id
	@Select("select tag_id from tag where tag_name=#{tagName}")
	int findTagIdByTagName(String tagName);
	//插入到讨论的数据库表
	@Insert("INSERT INTO issue(user_id,article_id,content)VALUES(#{user_id},#{article_id},#{content})")
	void addIssueToArticle(Issue issue);
	
	//对标签的操作
	@Select("SELECT tag_id FROM article_tag WHERE article_id=#{article_id}")
	List<Integer> findTagIdByArticleIdFromMiddleTable(int article_id);
	//暂时常识一下，不知道最后能否成功(经过测试确实是成功了)
	@Select("SELECT tag_name FROM tag WHERE tag_id IN (SELECT tag_id FROM article_tag WHERE article_id=#{article_id})")
	List<String> findTagNameByAritcleFromMiddleTable(int article_id);
	@Select("SELECT article_id FROM article")
	List<Integer> findAllArticleId();
	//根据文章id查找到对应的文章
	//根据category_id找到所有的article_id
	@Select("SELECT article_id FROM article WHERE category_id=#{categoryId}")
	List<Integer> findAllArticleIdByCategoryId(int categoryId);

	//根据tag_id从中间表找出所有的article的id
	@Select("SELECT article_id FROM article_tag WHERE tag_id=#{tagId}")
	List<Integer> findAllArticleIdFromCategoryAndTagByTagId(int tagId);
	//通过tagId找到tagName

	@Select("select tag_name from tag where tag_id=#{tagId}")
	String findTagNameByTagId(int tagId);

	/*//通过文章id查找到文章
	@Select("select ")
	SimpleArticle findArticleByArticleId(int articleId);*/
	//通过category_id和page来查询到所有的article_id并按照时间的先后顺序来排序
	@Select("SELECT article_id FROM article WHERE category_id=#{categoryId} ORDER BY issue_time LIMIT #{startNo},#{endNo};")
	List<Integer> findAllArticleIdByCategoryAndPageNo(int categoryId,int startNo,int endNo);
	//通过文章的id查找时间
	@Select("select issue_time from article where article_id=#{article_id}")
	Date findIssueTimeFromArticleByArticleId(int article_id);
	
	//映射到Simple的实体类
	@Select("SELECT title,article_id,user_id,summary,category_id,content,img_path FROM article WHERE article_id=#{articleId}")
	@Results({
		@Result(property="article_id",column="article_id"),
		@Result(property="user_id",column="user_id"),
		@Result(property="summary",column="summary"),
		@Result(property="img_path",column="img_path"),
		@Result(property="category_id",column="category_id"),
		@Result(property="content",column="content"),
		@Result(property="title",column="title"),
		@Result(property="tagIdList",column="article_id",many=@Many(select="com.chenbo.dao.UserMapper.findTagIdByArticleIdFromMiddleTable")),
		@Result(property="tagNameList",column="article_id",many=@Many(select="com.chenbo.dao.UserMapper.findTagNameByAritcleFromMiddleTable")),
		@Result(property="username",column="user_id",one=@One(select="com.chenbo.dao.UserMapper.findUsernameByUserId"))
	})
	List<SimpleArticle> findSimpleArticle(int articleId);
}
