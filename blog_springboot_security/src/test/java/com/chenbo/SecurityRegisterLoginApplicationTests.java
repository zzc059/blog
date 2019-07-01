package com.chenbo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chenbo.controller.UserController;
import com.chenbo.domain.RestResult;
import org.assertj.core.error.ShouldBeSymbolicLink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chenbo.dao.UserMapper;
import com.chenbo.domain.Issue;
import com.chenbo.domain.SimpleArticle;
import com.chenbo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityRegisterLoginApplicationTests {

	@Autowired
	private UserMapper userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private UserController controller;
	@Test
	public void tastFindAllTagNameByArticleId() {
		List<String> tagNameList = userDao.findTagNameByAritcleFromMiddleTable(1);
		if(tagNameList!=null) {
			for(String tagName : tagNameList) {
				System.out.println("tagName======>"+tagName);
			}
		}
	}

	@Test
	public void tastFindAllTagIdByArticleId() {
		System.out.println("确实执行了查询操作");
		List<Integer> tagNameList = userDao.findTagIdByArticleIdFromMiddleTable(1);
		System.out.println("查询成功");
		if(tagNameList!=null) {
			for(Integer tagName : tagNameList) {
				System.out.println("tagName======>"+tagName);
			}
		}
	}
	
	@Test
	public void tastFindAllArticlePojoByArticleId() {
		
			System.out.println("确实是执行了查询");
			List<SimpleArticle> list = userDao.findSimpleArticle(1);
			System.out.println("查询成功");
			if(list.size()>0) {
				for(int i=0;i<list.size();i++) {
					System.out.println("Pojo======>"+list.get(i));
				}
			}
	}
	@Test
	public void testFindAllArticlePojoByArticleIdService() {
		System.out.println("确实执行了查询");
		List<Integer> articleIdList = new ArrayList<>();
		articleIdList.add(1);
		List<SimpleArticle> list = userService.findAllSimpleArticleFirst();
		if(list.size()>0) {
			for(SimpleArticle simpleArticle : list) {
				System.out.println("simpleArticle====>"+simpleArticle);
			}
		}
	}
	
	@Test
	public void testFindAllArticlePojoByCategoryIdService() {
		System.out.println("确实执行了查询");
		List<Integer> articleIdList = new ArrayList<>();
		articleIdList.add(1);
		List<SimpleArticle> list = userService.findAllArticleByCategoryId(1);
		if(list.size()>0) {
			for(SimpleArticle simpleArticle : list) {
				System.out.println("simpleArticleByCategoryId====>"+simpleArticle);
			}
		}
	}
	
	@Test
	public void testFindAllCategoryIdByArticleId() {
		System.out.println("开始了查询");
		List<Integer> list = userDao.findAllArticleIdByCategoryId(1);
		System.out.println("查询成功");
		System.out.println("articleIdList=====>"+list);
		List<Integer> serviceList = userService.findAllArticleIdByCategoryId(1);
		System.out.println("serviceList=====>"+serviceList);
	}
	
	@Test
	public void testFindAllCategoryIdByTagId() {
		System.out.println("开始了查询");
		List<Integer> list = userDao.findAllArticleIdFromCategoryAndTagByTagId(2);
		System.out.println("查询成功");
		System.out.println("articleIdList=====>"+list);
		List<SimpleArticle> serviceList = userService.findAllArticleByTagId(2);
		System.out.println("serviceList=====>"+serviceList);
	}
	
	@Test
	public void testIssueFromUser() {
		Issue issue = new Issue();
		issue.setArticle_id(1);
		issue.setUser_id(1);
		issue.setContent("我去你大爷的");
		userService.issueFromUser(issue);
		System.out.println("插入成功");
	}
	
	@Test
	public void testFindArticleIdFromCategoryAndPageNo() {
		System.out.println("开始查询");
		System.out.println("mapper=====>"+userDao.findAllArticleIdByCategoryAndPageNo(1, 10,15));
		System.out.println("mapper查询成功");
		System.out.println("service====>"+userService.findArticleIdByCategoryIdAndPageNo(1, 10, 18));
		System.out.println("查询成功");
	}
	
	@Test
	public void testFindUsernameByUsername() {
		System.out.println("开始查询了");
		System.out.println("username=====>"+userDao.findUsernameByUserId(1));
		System.out.println("查询成功");
	}
	
	@Test
	public void testfindArticleIssueTimeByArticleId() {
		SimpleDateFormat aDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("开始查询");
		System.out.println("time=====>"+aDateFormat.format(userDao.findIssueTimeFromArticleByArticleId(15))+"\n now()===>"+aDateFormat.format(new Date()));
		System.out.println("查询成功");
	}

	@Test
	public void testArticleByCategoryId(){
		List<Integer> articleId = new ArrayList<>();
		articleId.add(2);
		articleId.add(3);
		System.out.println("test");
		List<SimpleArticle> list = userService.findAllArticleByList(articleId);
		System.out.println("dump===>"+list.get(0).toString());
	}

	@Test
	public void testfindArticleIssueTimeByArticleIdddd() {
		List<SimpleArticle> list = userDao.findSimpleArticle(1);
		System.out.println("dump===>"+list);
	}
}
