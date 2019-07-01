package com.chenbo.dao;



import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.chenbo.domain.Category;
import com.chenbo.domain.Tag;
import com.chenbo.domain.User;

@Mapper
@Repository
public interface AdminMapper {

	//管理员对标签的操作
	@Insert("INSERT INTO tag(tag_name)VALUES(#{tag_name})")
	void addTag(String tag_name);
	@Delete("DELETE FROM tag WHERE tag_id=#{tag_id}")
	void deleteTag(int tag_id);
	@Select("select * from tag")
	List<Tag> findAllTag();
	@Select("select * from tag where tag_name like '%${value}%'")
	List<Tag> findAllTagByVague(String value);
	
	//管理员对用户的操作,主要是删除用户，给用户修改密码（这部分本来想用邮箱验证来写，奈何不会，所以只能菜菜的让管理员来修改）、
	//还有就是模糊查询和查询所有
	@Delete("delete from user where user_id=#{user_id}")
	void deleteUser(int user_id);
	@Update("update user set password=md5(#{password}) where user_id=#{user_id}")
	void updateUserPassword(String password,int user_id);
	@Select("select * from user where username like '%${value}%'")
	List<User> findUserByVague(String value);
	@Select("select * from user")
	List<User> findAllUser();
	
	//管理员对大分类的操作，主要是增删改,改的话。感觉删除了再添加更加的方便简洁,还有就是查询所有的大分类然后放进导航栏
	@Insert("INSERT INTO category(category_name)VALUES(#{category_name})")
	void addCategory(String category_name);
	@Update("UPDATE category SET category_name=#{category_name} WHERE category_id=#{category_id}")
	void updateCategory(String category_name,int category_id);
	@Delete("DELETE FROM category WHERE category_id=#{category_id}")
	void deleteCategory(int category_id);
	@Select("select * from category")
	List<Category> findAllCategory();
	//管理员删除文章
	@Delete("DELETE FROM article WHERE article_id=#{articleId}")
	void deleteArticle(int articleId);
}
