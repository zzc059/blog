package com.chenbo.service;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chenbo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chenbo.dao.UserMapper;
import com.chenbo.utils.MD5Utils;
import com.chenbo.utils.MatchUtils;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional(rollbackFor= {Exception.class})
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AdminService adminService;
	public void userRegister(User user) {
		userMapper.addUser(user);
	}
	

	/**
	 * 这三个方法都是通过username来查找用户
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	public User findUserByEmail(String email) {
		return userMapper.findUserByEmail(email);
	}
	public User findUserByPhone(String phone) {
		return userMapper.findUserByPhoneNumber(phone);
	}
	public User findUserByUserId(int id) {
		return userMapper.findUserByUserId(id);
	}
	//修改用户的密码
	public boolean updateUserPassword(int user_id,String newPassword,String oldPassword) {
		User user = userMapper.findUserByUserId(user_id);
		System.out.println("user的值"+user);
		
		System.out.println("加密后的密码："+MD5Utils.getMD5(oldPassword)+" 数据库的密码："+user.getPassword());
		if(MD5Utils.getMD5(oldPassword).equals(user.getPassword())==false||newPassword==null) {
			return false;
		}
		System.out.println("加密后的密码："+MD5Utils.getMD5(oldPassword)+" 数据库的密码："+user.getPassword());
		userMapper.updateUserPassword(newPassword, oldPassword, user_id);
		return true;
	}
	//修改用户的邮箱
	public void updateUserEmail(String email,int user_id) {
		System.out.println("调用了service里面的修改用户的密码");
		userMapper.updateUserEmail(email, user_id);
	}

	//用户发表评论
	public void issueFromUser(Issue issue) {
		userMapper.addIssueToArticle(issue);
	}
	//将文章和标签插入中间表
	public void addArticleAndTag(int articleId,int tagId) {
		userMapper.addArticleAndTag(tagId, articleId);
	}
	//获取所有的标签
	public List<Tag> findAllTag(){
		return adminService.findAllTag();
	}
	//预加载获取所有的文章
	public List<SimpleArticle> findAllSimpleArticleFirst(){
		List<Integer> articleIdList = userMapper.findAllArticleId();
		return findAllArticleByList(articleIdList);
	}
	//根据category_id找到article_id(数据比较少，所以查询的category_id固定为1)
	public List<Integer> findAllArticleIdByCategoryId(int categoryId){
		System.out.println("service里面的categoryId=====>"+userMapper.findAllArticleIdByCategoryId(1));
		return userMapper.findAllArticleIdByCategoryId(categoryId);
	}
	//根据categoryId找到文章
	public List<SimpleArticle> findAllArticleByCategoryId(int categoryId){
		List<Integer> articleIdList = userMapper.findAllArticleIdByCategoryId(categoryId);
		return findAllArticleByList(articleIdList);
	}
	//通过标签的id找到文章
	public List<SimpleArticle> findAllArticleByTagId(int tagId){
	    System.out.println("tagIdServce====>"+tagId);
	    System.out.println("articleIdList===>");
		List<Integer> articleIdList = userMapper.findAllArticleIdFromCategoryAndTagByTagId(tagId);
		return findAllArticleByList(articleIdList);
	}
	//获取最新的10条文章
	public List<SimpleArticle> findPopularArticle(){
		List<Integer> articleId = userMapper.findPopularArticle();
		return findAllArticleByList(articleId);
	}
	//通过传入大分类的id和页面的其实数值返回查询的所有文章
	public List<SimpleArticle> findAllArticleByCategoryAndPageNo(int categoryId,int startPage,int endPage){
		List<Integer> articleIdList = userMapper.findAllArticleIdByCategoryAndPageNo(categoryId, startPage, endPage);
		return findAllArticleByList(articleIdList);
	}

	//通过文章的id来查找到对应的文章
	public List<SimpleArticle> findAllArticleByArticleId(int articleId){
		List<Integer> list = new ArrayList<>();
		list.add(articleId);
		return findAllArticleByList(list);
	}
	//抽取出三个函数的公共部分
	public List<SimpleArticle> findAllArticleByList(List<Integer> articleIdList){
		
		List<SimpleArticle> list = new ArrayList<>();
		if(articleIdList.size()>0) {
			for(int i=0;i<articleIdList.size();i++) {
				System.out.println("articleIdLidt=====>"+articleIdList.get(i));
			}
		}
		if(articleIdList.size()>0) {
			for(int i=0;i<articleIdList.size();i++) {
				System.out.println("articleId======>"+articleIdList.get(i));
				List<SimpleArticle> temp = (List<SimpleArticle>) userMapper.findSimpleArticle(articleIdList.get(i));
				System.out.println("temp=====>"+temp);
				list.addAll(temp);
			}
		}
		return list;
	}

	//通过传入文章的content得到第一张图片的url
	public String getUrlOfFirstImage(SimpleArticle articleParam, Article article) {
        String content = articleParam.getContent();
        System.out.println(content);

        String imgTagHeader = "<img src=";
        int indexOfFirstImgTag = content.indexOf(imgTagHeader);

        if (indexOfFirstImgTag != -1) {
            int startIndex = indexOfFirstImgTag + imgTagHeader.length() + 1;
            int endIndex = startIndex;
            while (content.charAt(endIndex) != '\"'){
                endIndex++;
            }
            String imgPath = content.substring(startIndex, endIndex);
            article.setImg_path(imgPath);
            return imgPath;
        }
        return null;
    }
	//将文章和标签还有中间表一一插入进去
	public int publishArticle(SimpleArticle simpleArticle) {
		Article article = new Article();

		System.out.println("SimpleArticle===>"+simpleArticle);
		article.setCategory_id(simpleArticle.getCategory_id());
		article.setContent(simpleArticle.getContent());
		article.setIssue_time(new Date());
		article.setScan_num(0);
		article.setSummary(simpleArticle.getTitle()+simpleArticle.getContent().substring(0, 10));
		article.setTitle(simpleArticle.getTitle());
		article.setUser_id(simpleArticle.getUser_id());
		String imgPath = getUrlOfFirstImage(simpleArticle, article);
		userMapper.addArticle(article);
//		int articleIId = userMa
		System.out.println("aritcleId====>"+article.getArticle_id());
		
//		int articleId = userMapper.findArticleIdByManyoption(simpleArticle.getCategory_id(), simpleArticle.getTitle(), simpleArticle.getUser_id());
		int articleId = article.getArticle_id();
		List<Integer> tagIdList = simpleArticle.getTagIdList();
		if(tagIdList.size()>0) {
			for(int i=0;i<tagIdList.size();i++) {
				userMapper.addArticleAndTag(tagIdList.get(i), articleId);
			}
		}
		return RestResult.SUCCESS;
	}
	
	//根据category_id和起始数据和结尾数据，就是（页数-1）*10到（页数）*10
	public List<Integer> findArticleIdByCategoryIdAndPageNo(int categoryId,int startNo,int endNo){
		List<Integer> list = userMapper.findAllArticleIdByCategoryAndPageNo(1, 10,15);
		System.out.println("list===>"+list);
		return userMapper.findAllArticleIdByCategoryAndPageNo(categoryId, startNo,endNo);
	}
	//通过标签id查找标签name
	public String findTagNameByTagId(int tagId){
		return userMapper.findTagNameByTagId(tagId);
	}
	//通过文章id查找文章
	public List<SimpleArticle> findArticleByArticleId(int articleId){
		List<SimpleArticle> list = userMapper.findSimpleArticle(articleId);
		return list;
	}

	public List<SimpleArticle> findOneArticle(int articleId){
		List<SimpleArticle> list = userMapper.findSimpleArticle(articleId);
		System.out.println("service====>"+list);
		return list;
	}
}
