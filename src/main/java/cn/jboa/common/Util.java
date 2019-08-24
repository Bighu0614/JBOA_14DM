package cn.jboa.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Util {

	public static SimpleDateFormat DATE_TIME_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	public static SimpleDateFormat DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat MONTH = new SimpleDateFormat("MM");
	/**
	 * 得到当前系统的时间
	 * 
	 * @return 返回字符串 格式 yyyy-MM-dd HH:mm:ss SSS
	 */
	public static String getTableTS() {
		return getDateTimeMs(new Date(System.currentTimeMillis()), Util.DATE_TIME_MS);
	}

	/**
	 * 返回带毫秒的日期时间字符串
	 * 
	 * @param date
	 * @param sdf
	 *            SimpleDateFormat 有静态常量 显示格式
	 * @return
	 */
	public static String getDateTimeMs(Date date, SimpleDateFormat sdf) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 将字符串转化为Date
	 * 
	 * @param date
	 *            返回Date格式 yyyy-MM-dd
	 * @return
	 */
	public static Date doConvertToDate(String date) {
		Date result = null;
		try {
			result = DATE.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 返回带日期时间字符串 格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {

		return DATE_TIME.format(date);
	}

	/**
	 * 返回当前年份yyyy
	 * @return
	 */
	public static String getCurrentYear() {
		Date date = new Date();
		return YEAR.format(date);
	}	/**
	 * 返回当前月份MM
	 * @return
	 */
	public static String getCurrentMonth() {
		Date date = new Date();
		return MONTH.format(date);
	}
	
	/**
	 * 返回带日期字符串 格式yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		if (date == null) {
			return "";
		}
		return DATE.format(date);
	}

	/**
	 * 返回带日期和时间的字符串
	 * 
	 * @param date
	 * @param sdf
	 *            SimpleDateFormat 有静态常量 显示格式
	 * @return
	 */
	public static String getOpTime(Date date, SimpleDateFormat sdf) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}

	/**
	 * 将字符串转换为日期类型
	 * 
	 * @param date
	 *            日期字符串yyyy-MM-dd
	 * @return
	 */
	public static Date parseDate(String date) {
		Date d = null;
		try {
			d = DATE.parse(date);
		} catch (ParseException e) {
		}
		return d;
	}

	/**
	 * 将字符串转换为日期时间类型
	 * 
	 * @param date
	 *            日期日期字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseDateTime(String date) {
		if (date == null || "".equals(date))
			return null;
		Date destDate = null;
		try {
			destDate = DATE_TIME.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return destDate;
	}

	/**
	 * 根据条件获取指定年份和月份
	 * 
	 * @author 尚鸿运
	 * @version 2010-10-18
	 * @param monthNumber
	 *            要增加或减少的月份数
	 * @return
	 */
	public static String getDefaultDate(int monthNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月

		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份

		return year + "-" + df.format(month);
	}

	/**
	 * 根据条件获取指定日期
	 * 
	 * @author 尚鸿运
	 * @version 2010-10-18
	 * @param monthNumber
	 *            要增加或减少的月份数
	 * @param dayNumber
	 *            要增加或减少的天数
	 * @return
	 */
	public static String getDefaultDate(int monthNumber, int dayNumber) {
		DecimalFormat df = new DecimalFormat("00");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthNumber); // 得到当前月份+monthNumberge个月
		calendar.add(Calendar.DATE, dayNumber); // 得到当前日期+monthNumber天
		int year = calendar.get(Calendar.YEAR);// 获取当前年份
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份
		int day = calendar.get(Calendar.DATE);// 获取当前日期
		
		return year + "-" + df.format(month) + "-" + df.format(day);
	}

	public static void main(String[] args) {
		System.out.println(formatFloat(12345623432.123456));
	}



	/**
	 * 将NULL字符串转为""
	 * 
	 * @param str
	 * @return
	 */
	public static String nvl(Object str) {
		return str == null ? "" : str.toString();
	}

	/**
	 * java方式获取32位UUID
	 * 
	 * @author 尚鸿运
	 * @version 2010-9-16
	 * @return
	 */
	public static String getUuid() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString().replaceAll("-", "");
	}

	/**
	 * 值是否为空
	 * 
	 * @author 尚鸿运
	 * @version 2010-9-19
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {

		return null != value && !value.trim().equals("") && !value.equals("undefined") && !value.trim().equals("null");
	}

	/**
	 * 格式化浮点数
	 * @param f
	 * @return
	 */
	public static String formatFloat(double f) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		String sj = df.format(f);
		return sj;
	}
	
	/**
	 * 比较两个字符串时间的大小
	 * @param t1     时间1
	 * @param t2     时间2
	 * @param parrten 时间格式 :yyyy-MM-dd
	 * @return 返回long =0相等，>0 t1>t2，<0 t1<t2
	 */
	public static long compareStringTime(String t1, String t2, String parrten) {
		SimpleDateFormat formatter = new SimpleDateFormat(parrten);
		ParsePosition pos = new ParsePosition(0);
		ParsePosition pos1 = new ParsePosition(0);
		Date dt1 = formatter.parse(t1, pos);
		Date dt2 = formatter.parse(t2, pos1);
		long l = dt1.getTime() - dt2.getTime();
		return l;
	}
	
	/**
	 * 生成MD5编码
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String createMD5(String str) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] srcByte = str.getBytes();
		md5.update(srcByte);
		byte[] resultByte = md5.digest();
		String result = new String(resultByte);

		result = "";
		for (int i = 0; i < resultByte.length; i++) {
			result += Integer.toHexString(
					(0x000000ff & resultByte[i]) | 0xffffff00).substring(6);
		}

		return result;
	}

	/**
	 * 把组数拼接成IN语句(字符型)
	* @author GZZ
	 * @param arr
	 * @return
	 */
	public static String ArrayToIn(String[] arr) {// 字符IN字符窜
		StringBuffer sb = new StringBuffer("IN (");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				sb.append("'" + arr[i] + "',");
			} else {
				sb.append("'" + arr[i]+"'");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	/**
	 * 把组数拼接成IN语句(数值型)
	 * @author GZZ
	 * @param arr
	 * @return
	 */
	public static String ArrayToInNum(String[] arr) {// 字符IN字符窜
		StringBuffer sb = new StringBuffer("IN (");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				sb.append(arr[i] + ",");
			} else {
				sb.append(arr[i]);
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * 级联创建目录
	 * @param path
	 */
	public static void mkdir(String path) {
		File dir = new File(path);
		
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
	}
	
	/**
	 * 获取全部文件名 文件名+扩展名
	 * @param filePath
	 */
	public static String getFullFileName(String filePath) {
		filePath.replace("\\", "/");
		String[] pathArray = filePath.split("\\/");
		
		return pathArray[pathArray.length - 1];
	}
	
	/**
	 * 获取文件名
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
		String fileName = getFullFileName(filePath);
		
		String[] fileArray = fileName.split("\\.");
		return fileArray[0];
	}
	
	/**
	 * 获取导出文件路径
	 * @param paramMap
	 * @param exportTemplatePath
	 * @return
	 */
	public static String getExportFileName(Map<String, Object> paramMap, ServletContext context, String exportTemplatePath) {
		String resultFileName = null;
		Configuration freemarkerCfg = new Configuration();  
		
		//加载模版  
		freemarkerCfg.setServletContextForTemplateLoading(context, "/");  
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8"); 
		
		try {  
		    //指定模版路径  
		    Template template = freemarkerCfg.getTemplate(exportTemplatePath, "UTF-8");  
		    template.setEncoding("UTF-8");
		    
		    //生成静态文件目录
		    String year = getCurrentYear();
		    String month = getCurrentMonth();
		    
		    String filePath = context.getRealPath("/report/export" ) + "/" + year + "/" + month + "/";;
		    String fileName =  getFileName(exportTemplatePath) + ".xls";
		    mkdir(filePath);
		    
		    resultFileName = filePath + fileName;
		    File exportFile = new File(resultFileName);  
		    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(exportFile), "UTF-8"));  
            
		    template.process(paramMap, out); 
            
            out.flush();  
            out.close();  
		} catch (Exception e) {  
		    e.printStackTrace();  
		}

		return resultFileName;
	}
	
	
	
	public static String getWeek(int week){
		String w = "";
		switch (week) {
		case 0:
			w="星期日";
			break;
		case 1:
			w="星期一";
			break;
		case 2:
			w="星期二";
			break;
		case 3:
			w="星期三";
			break;
		case 4:
			w="星期四";
			break;
		case 5:
			w="星期五";
			break;
		case 6:
			w="星期六";
			break;			
		default:
			break;
		}
		return w;
	}
	
	/**
	 * 计算税收
	 * @param salary
	 */
	public static double salaryTax(double salary){
		double tax = 0;
		double moneyTax = salary - 2000; //大于2000才交税
		if(moneyTax > 0){
			if(moneyTax < 500){
				tax = moneyTax * 0.05;
			}else if(moneyTax < 2000){
				tax = moneyTax * 0.1 - 25;
			}else if(moneyTax < 2000){
				tax = moneyTax * 0.1 - 25;
			}else if(moneyTax < 5000){
				tax = moneyTax * 0.15 - 125;
			}else if(moneyTax < 20000){
				tax = moneyTax * 0.2 - 375;
			}else if(moneyTax < 40000){
				tax = moneyTax * 0.25 - 1375;
			}else if(moneyTax < 60000){
				tax = moneyTax * 0.30 - 3375;
			}else if(moneyTax < 80000){
				tax = moneyTax * 0.35 - 6375;
			}else if(moneyTax < 100000){
				tax = moneyTax * 0.40 - 10375;
			}else{
				tax = moneyTax * 0.45 - 15375;
			}
		}
		return tax;
	}
	
}
