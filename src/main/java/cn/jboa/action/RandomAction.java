package cn.jboa.action;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/**
 * 该类主要用于生成验证码
 * 
 */
public class RandomAction extends ActionSupport {
    public String execute() throws Exception{
        Random rd = new Random();
        BufferedImage bi = new BufferedImage(90,32,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bi.getGraphics();
        Color c = new Color(255,215,0);
        g.setColor(c);  //设置颜色
        g.fillRect(0,0,90,50);   //绘制边框
        for (int i =100;i>0;i--){
            g.setColor(new Color(		255,0,255));
            g.drawArc(rd.nextInt(200),rd.nextInt(50),rd.nextInt(200),rd.nextInt(50),rd.nextInt(360),rd.nextInt(360));
        }
        Font font = new Font("宋体",Font.BOLD,33);
        g.setFont(font);
        char[] ch = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<4;i++){
            int num = rd.nextInt(ch.length);
            g.setColor(new Color(rd.nextInt(88),rd.nextInt(128),rd.nextInt(255)));  //设置字符颜色
            g.drawString(ch[num]+"",(i*20)+3,30);
            sb.append(ch[num]);
        }
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("picCode", sb.toString());
        try {
            HttpServletResponse response = ServletActionContext.getResponse();
            ImageIO.write(bi, "JPG", response.getOutputStream());//进行输出
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NONE;
    }
}
