package com.chenbo.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 该类主要是提供生成随机数以及画板的一些公共方法
 * 
 * @author 11366
 *
 */
public class GraphicUtils {
	// 获取验证码随机数
	private char[] generateCheckCode() {
		String chars = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 57);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}

	// 绘制图片
	private void drawRands(Graphics graphics, char[] rands) {
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
		graphics.drawString("" + rands[0], 1, 17);
		graphics.drawString("" + rands[1], 16, 15);
		graphics.drawString("" + rands[2], 31, 18);
		graphics.drawString("" + rands[3], 46, 16);
	}

	// 绘制背景
	private void drawBackground(Graphics graphics, int WIDTH, int HEIGHT) {
		// 画背景
		graphics.setColor(new Color(0xDCDCDC));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		// 随机生成120个干扰点
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 225);
			int blue = (int) (Math.random() * 225);
			graphics.setColor(new Color(red, green, blue));
			graphics.drawOval(x, y, 1, 0);
		}
	}
}
