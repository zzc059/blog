package com.chenbo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenbo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.chenbo.service.UserService;
import com.chenbo.utils.FileUploadUtil;
import com.chenbo.utils.MD5Utils;
import com.chenbo.utils.MatchUtils;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public RestResult userRegister(@RequestBody User user) {
		RestResult result = new RestResult();
		result.setCode(RestResult.FAIL);
		// 用户注册首先设置权限等级
		user.setGrant_level(1);
		user.setCreate_time(new Date());
		// 判空和正则匹配留给前端判断
		// 去数据库里面查找是否包含相同的用户名（这一步考虑优化是否在用户注册时失去焦距就用ajax异步查询）
		if (userService.findUserByUsername(user.getUsername()) != null) {
			result.setCode(RestResult.USERNAME_EXIST);
			result.setMessage("改用户名已经注册过，请换一个用户名");
			return result;
		} else if (userService.findUserByEmail(user.getEmail()) != null) {
			result.setCode(RestResult.EMAIL_EXIST);

			result.setMessage("邮箱已经存在，请换一个邮箱");
			return result;
		} else if (userService.findUserByPhone(user.getPhone()) != null) {
			result.setCode(RestResult.PHONE_EXIST);
			result.setMessage("电话已经存在，请换一个电话");
			return result;
		}
		// 将注册的用户保存到数据库中
		userService.userRegister(user);
		result.setCode(RestResult.SUCCESS);
		result.setData(user);
		result.setMessage("注册成功");
		return result;
	}

	// 根据标签的id返回相关的SimpleArticle
	@RequestMapping("/findAllArticleByTagId")
	public RestResult findAllArticleByTagId(@RequestBody Tag tag, HttpServletRequest request) {
		System.out.println("request===>"+request);
		System.out.println("tagId=====>"+tag.getTag_id()+"  request===>"+request.getParameter("tagId"));
		List<SimpleArticle> list = userService.findAllArticleByTagId(tag.getTag_id());
		RestResult restResult = new RestResult(RestResult.SUCCESS, "通过标签id查询文章成功", list, list.size());
		String name = userService.findTagNameByTagId(tag.getTag_id());
		System.out.println("输出通过id查找到的name===》"+name);
		restResult.setId(tag.getTag_id());
		restResult.setHelper(name);
		return restResult;
	}
	@RequestMapping("/findAritcleByTageIdAndPage")
	public RestResult findAritcleByTageIdAndPage(@RequestBody Tag tag){
		List<SimpleArticle> list = userService.findAllArticleByTagId(tag.getTag_id());
		RestResult result = new RestResult(RestResult.SUCCESS,"成功",list,list.size());
		result.setId(tag.getTag_id());
		result.setHelper(userService.findTagNameByTagId(tag.getTag_id()));
		result.setPage(tag.getPage());
		return result;
	}
	// 用户登录
	@RequestMapping("/login")
	public RestResult userLogin(HttpServletRequest request,@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		RestResult result = new RestResult(RestResult.SUCCESS, "用户登录成功", null);
		System.out.println("username===>"+username+"  password=====>"+password);
		request.getParameter("username");
		request.getParameter(("password"));
		System.out.println("222username===>"+username+"  2222password=====>"+password);
		if (MatchUtils.isEmail(username) == true) {
			User emailMan = userService.findUserByEmail(username);
			System.out.println("email===>" + emailMan);
			if (emailMan != null && MD5Utils.getMD5(password).equals(emailMan.getPassword()) == true) {

				System.out.println("MD5password====>" + MD5Utils.getMD5(password));
				System.out.println("userpassword===>" + emailMan.getPassword());

				result.setData(emailMan);
				request.getSession().setAttribute("user", emailMan);
				return result;
			}
		} else if (MatchUtils.isPhoneNumber(username) == true) {
			User phoneMan = userService.findUserByPhone(username);
			System.out.println("phone====>" + phoneMan);
			if (phoneMan != null && MD5Utils.getMD5(password).equals(phoneMan.getPassword()) == true) {

				System.out.println("MD5password====>" + MD5Utils.getMD5(password));
				System.out.println("userpassword===>" + phoneMan.getPassword());

				result.setData(phoneMan);
				request.getSession().setAttribute("user", phoneMan);
				return result;
			}
		} else if (userService.findUserByUsername(username) != null) {
			User uMan = userService.findUserByUsername(username);
			System.out.println("username====>" + uMan);
			if (MD5Utils.getMD5(password).equals(uMan.getPassword()) == true) {

				System.out.println("MD5password====>" + MD5Utils.getMD5(password));
				System.out.println("userpassword===>" + uMan.getPassword());

				result.setData(uMan);
				request.getSession().setAttribute("user", uMan);
				return result;
			}
		}
		User uu = new User();
		uu.setUsername(username);
		uu.setPassword(password);
		System.out.println("登录失败");
		result.setCode(-1);
		result.setMessage("登录失败");
		result.setData(uu);

		return result;
	}

	@RequestMapping(value = "/getNowUser", method = RequestMethod.GET)
	public User getNowUser(HttpServletRequest request) {
//		System.out.println("获取当前用户成功");
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}

	// 修改用户密码
	@RequestMapping("/updateUserPassword")
	public RestResult updateUserPassword(int user_id, String oldPassword, String newPassword) {
		RestResult result = new RestResult();
		if (!userService.updateUserPassword(user_id, newPassword, oldPassword)) {
			result.setCode(RestResult.PASSWORD_UPLOAD_FAIL);
			result.setMessage("老密码不对或新密码为空");
			return result;
		}
		result.setCode(RestResult.SUCCESS);
		result.setData(userService.findUserByUserId(user_id));
		result.setMessage("修改密码成功");
		return result;
	}

	// 修改用户邮箱
	@RequestMapping("/updateUserEmail")
	public RestResult updateUserEmail(int user_id, String email) {
		System.out.println("用户开始修改邮箱");
		userService.updateUserEmail(email, user_id);
		System.out.println("用户修改邮箱成功");
		RestResult result = new RestResult();
		result.setCode(RestResult.SUCCESS);
		result.setMessage("用户修改邮箱成功");
		result.setData(userService.findUserByUserId(user_id));
		
		return result;
	}

	// 富文本上传(已经将返回的东西变成了富文本的类)
	@RequestMapping("/uploadMutilPartFile")
	public SimpleResult uploadMutilPartFile(@RequestParam("myFile") MultipartFile multipartFile,
			HttpServletRequest request) throws IOException {
		return FileUploadUtil.upload(multipartFile, request);
	}

	// 用户发表评论,将评论封装成一个封装类(待定，不确定是否会直接映射成实体类)
	@RequestMapping("/issueFromUser")
	public RestResult issueFromUser(Issue issue) {
		RestResult result = new RestResult(RestResult.SUCCESS, "成功发表评论", issue);
		userService.issueFromUser(issue);
		return result;
	}

	//找到最新的10条文章
	@RequestMapping("/findPopularArticle")
	public RestResult findPopularArticle() {
		System.out.println("开始查找最新的10条文章");
		return new RestResult(RestResult.SUCCESS,"获取最新10条文章成功",userService.findPopularArticle(),null);
	}
	// 获取所有的标签
	@GetMapping("/tag/findAllTag")
	public RestResult findAllTag() {
		List<Tag> list = userService.findAllTag();
		RestResult result = new RestResult(RestResult.SUCCESS, "获取成功", list, list.size());
		return result;
	}

	// 获取所有文章
	@RequestMapping("/findAllAritcle")
	public RestResult findAllArticle(@RequestBody Tag tag) {
		List<SimpleArticle> list = userService.findAllSimpleArticleFirst();
		RestResult result = new RestResult(RestResult.SUCCESS, "成功获取所有文章", list, list.size());
		result.setPage(tag.getPage());
		return result;
	}

	// 通过大标题来获取所有的文章
	@RequestMapping("/findAllArtilceByCategoryId")
	public RestResult findAllArticleByCategoryId(@RequestBody Category category) {
		System.out.println("ca===>"+category.getCategory_id()+"   page==>"+category.getPage());
		List<SimpleArticle> list = userService.findAllArticleByCategoryId(category.getCategory_id());
		RestResult result = new RestResult(RestResult.SUCCESS, "按照大分类查询文章成功", list, list.size());
		result.setId(category.getCategory_id());
		result.setPage(category.getPage());
		return result;
	}

	// 用户上传文章，返回的flag为第一张图片的url
	@RequestMapping("/publishArticle")
	public int publishArticle(@RequestBody SimpleArticle simpleArticle) {
		System.out.println("开始上传文章");
		/*RestResult result = new RestResult(RestResult.SUCCESS, "成功发表文章", null,
				userService.publishArticle(simpleArticle));*/
		System.out.println("service里面的文章内容=====>>"+simpleArticle);
		userService.publishArticle(simpleArticle);
		System.out.println("上传文章成功");
		return RestResult.SUCCESS;
	}

	// 根据category的id和起始页和终止页来查询文章
	@RequestMapping("/findAllArticleByPageNo")
	public RestResult findAllArticleByPageNo(int categoryId, int startPage, int endPage) {
		List<SimpleArticle> list = userService.findAllArticleByCategoryAndPageNo(categoryId, startPage, endPage);
		RestResult result = new RestResult(RestResult.SUCCESS, "", list, list.size());
		return result;
	}

	//通过文章id查找文章
	@RequestMapping("/findArticleByArticle")
	public RestResult findArticleByArticleId(@RequestBody Article article){
		/*List<Integer> aa = new ArrayList<>();
		aa.add(article.getArticle_id());
		System.out.println("resutl");
		List<SimpleArticle> list = userService.findAllArticleByList(aa);
		System.out.println("list"+list);
		RestResult result = new RestResult(RestResult.SUCCESS,"success",list,list.size());
		return result;*/
		System.out.println("fasdfafa");
		return null;
	}

}
