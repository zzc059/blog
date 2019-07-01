package com.chenbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenbo.domain.RestResult;
import com.chenbo.domain.Tag;
import com.chenbo.domain.User;
import com.chenbo.service.AdminService;
import com.chenbo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@RequestMapping("/tag/addTag")
	public RestResult addTag(String tagName) {
		adminService.addTag(tagName);
		RestResult result = new RestResult(RestResult.SUCCESS,"添加标签成功",null);
		return result;
	}
	@RequestMapping("/tag/deleteTag")
	public RestResult delTag(int tagId) {
		adminService.deleteTag(tagId);
		RestResult result = new RestResult(RestResult.SUCCESS,"成功删除该标签",null);
		
		return result;
	}
	@GetMapping("/tag/findAllTag")
	public List<Tag> findAllTag() {
		return adminService.findAllTag();
	}
	@GetMapping("/tag/findAllTagByVague")
	public List<Tag> findAllTagByVague(String value){
		return adminService.findAllTagByVague(value);
	}
	
	@GetMapping("/user/findAllUser")
	public List<User> findAllUser(){
		return adminService.findAllUser();
	}
	
	@GetMapping("/user/findAllUserByVague")
	public List<User> findAllUserByVague(String value){
		return adminService.findAllUserByVague(value);
	}
	
	@RequestMapping("/user/deleteUserById")
	public RestResult deleteUserById(int userId) {
		RestResult result = new RestResult(RestResult.SUCCESS,"删除该用户成功",userService.findUserByUserId(userId));
		adminService.deleteUser(userId);
		return result;
	}
	
	@RequestMapping("/user/updateUserPassword")
	public RestResult updateUserPassword(String password,int userId) {
		RestResult result = new RestResult(RestResult.SUCCESS,"修改用户密码成功",userService.findUserByUserId(userId));
		adminService.updateUserPasswordFromAdmin(password, userId);
		return result;
	}
	@RequestMapping("/deleteArticleByArticle")
	public RestResult deleteArticleByArticle(int articleId) {
		adminService.deleteArticleByArticleId(articleId);
		System.out.println("delete====>"+articleId);
		RestResult result = new RestResult(RestResult.SUCCESS,"删除文章成功","");
		return result;
	}
}
