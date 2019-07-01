package com.chenbo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.chenbo.domain.RestResult;
import com.chenbo.domain.SimpleResult;

/**
 * 文件上传的工具类
 * 因为不太清楚文件上传的返回url，所以只好就直接用以前的老代码。
 * @author 11366
 *
 */
public class FileUploadUtil {
	/** 绝对路径 **/
	private static String absolutePath = "";

	/** 静态目录 **/
	private static String staticDir = "static";

	/** 文件存放的目录 **/
	private static String fileDir = "/upload/image/";

	/**
	 * 上传单个文件 最后文件存放路径为：static/upload/image/test.jpg
	 * 文件访问路径为：http://127.0.0.1:8080/upload/image/test.jpg
	 * 该方法返回值为：/upload/image/test.jpg // * @param inputStream 文件流 // * @param
	 * filename 文件名，如：test.jpg
	 * 
	 * @return 成功：上传后的文件访问路径，失败返回：null
	 */
	public static SimpleResult upload(MultipartFile file, HttpServletRequest request) {

		SimpleResult result = new SimpleResult();
		try (InputStream inputStream = file.getInputStream()) {
			String filename = generateFileName(file);

			// 第一次会创建文件夹
			createDirIfNotExists();

			String resultPath = fileDir + filename;

			// 存文件
			File uploadFile = new File(absolutePath, staticDir + resultPath);

			FileUtils.copyInputStreamToFile(inputStream, uploadFile);
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ resultPath;

			String resultUrl[] = { url };
			result.setErrno(0);
			result.setData(resultUrl);
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 根据时间生成文件名
	private static String generateFileName(MultipartFile file) {

		// 获得文件名
		String filename = file.getOriginalFilename();
		// 截取文件后缀
		String fileSuffix = filename.substring(filename.lastIndexOf(".")).toLowerCase();
		// 时间格式化对象
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 生成新的文件名
		return simpleDateFormat.format(new Date()) + fileSuffix;
	}

	/**
	 * 创建文件夹路径
	 */
	private static void createDirIfNotExists() {
		if (!absolutePath.isEmpty()) {
			return;
		}

		// 获取跟目录
		File file = null;
		try {
			file = new File(ResourceUtils.getURL("classpath:").getPath());
		} catch (FileNotFoundException e) {
			throw new RuntimeException("获取根目录失败，无法创建上传目录！");
		}
		if (!file.exists()) {
			file = new File("");
		}

		absolutePath = file.getAbsolutePath();

		File upload = new File(absolutePath, staticDir + fileDir);
		if (!upload.exists()) {
			upload.mkdirs();
		}
	}

}
