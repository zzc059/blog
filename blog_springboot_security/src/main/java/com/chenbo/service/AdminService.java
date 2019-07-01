package com.chenbo.service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11366
 * 这个类主要是管理员的一些操作
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chenbo.dao.AdminMapper;
import com.chenbo.domain.Tag;
import com.chenbo.domain.User;

@Service
@Transactional(rollbackFor= {Exception.class})
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	//管理员增加标签
	public void addTag(String tagName) {
		adminMapper.addTag(tagName);
	}
	
	//管理员删除标签
	public void deleteTag(int tagId) {
		adminMapper.deleteTag(tagId);
	}
	
	//管理员显示所有的标签
	public List<Tag> findAllTag() {
		return adminMapper.findAllTag();
	}
	
	//管理员模糊查询相关标签
	public List<Tag> findAllTagByVague(String value){
		return adminMapper.findAllTagByVague(value);
	}
	
	public List<User> findAllUserByVague(String value){
		return adminMapper.findUserByVague(value);
	}
	public List<User> findAllUser(){
		List<User> list = adminMapper.findAllUser();
		List<User> result = new ArrayList<>();
		if(list.size()>0) {
			for(User user : list) {
				if(user.getGrant_level()!=0) {
					result.add(user);
				}
			}
		}
		return result;
	}
	public void deleteUser(int userId) {
		adminMapper.deleteUser(userId);
	}
	public void updateUserPasswordFromAdmin(String password,int userId) {
		adminMapper.updateUserPassword(password, userId);
	}
	//管理员通过文章的id删除文章
	public void deleteArticleByArticleId(int articleId) {
		adminMapper.deleteArticle(articleId);
	}
}
