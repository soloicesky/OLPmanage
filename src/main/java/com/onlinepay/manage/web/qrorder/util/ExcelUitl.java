package com.onlinepay.manage.web.qrorder.util;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import com.onlinepay.manage.web.util.AmountUtils;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUitl {


	/**
	 * function 用于实现将后台数据导入到Excel中
	 * 
	 * @param <T>
	 *            模板中的类型
	 * @param list
	 *            装在数据的list
	 * @param fieldMap
	 *            Excel中的数据容器，！！值得注意的是fileMap中的key要和表格中的表头的英文名数据一一对应才行
	 *            如果需要的是引用对象的某个属性，则英文属性使用的是类似于EL表达式的格式
	 *            如我们存储的是student，但是在student中要存储班级名称，班级是个对象，这个时候我们就可以这样实现
	 *            fileMap.put("Calzz.name","学生所在班级");
	 * @param sheetName
	 *            Excel中工作表的名称
	 * @param sheetSize
	 *            工作也得数量
	 * @param out
	 *            字节流输出流
	 */
	public static <T> void listToExcel(List<T> list, LinkedHashMap<String, String> fieldMap, String sheetName, int sheetSize,
			LinkedHashMap<String, String> totalMap, Map<String, String> repMap,OutputStream out) throws CustomAjaxException {
		// 数据为空或者是数据不存在
				if (list.size() == 0 || list == null) {
					throw new CustomAjaxException("数据源中没有任何数据！请核实");
				}
				// 一次性处理的表格sheet的范围
				if (sheetSize > 65535 || sheetSize < 1) {
					// 不符合规范
					throw new CustomAjaxException("数据量不合规范！");
				}
				// 创建工作部， 并通过out发送
				WritableWorkbook wwb = null;
				try {
					wwb = Workbook.createWorkbook(out);// 这里的workBook包是jxl里面的
					// 创建相应的工作表，并向其中填充数据
					WritableSheet sheet = wwb.createSheet(sheetName, 0);// 以下表来命名
					fillSheet(sheet, list, fieldMap,repMap, 0, list.size() - 1);
					//新增统计 2017/06/07
					if(!totalMap.isEmpty()&& totalMap.size()!=0){
						int j = list.size();
						for (Entry<String, String> entry : totalMap.entrySet()) {
							//填充尾部
							Label label = new Label(0, j+3, entry.getKey());
							sheet.addCell(label);
							Label label1 = new Label(1, j+3, entry.getValue());
							sheet.addCell(label1);
							j ++;
						}
					}
					wwb.write();
					wwb.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
		
	}
	
	
	/**
	 * 重载的函数
	 */
	public static <T> void listToExcel(List<T> list,
			LinkedHashMap<String, String> fieldMap, String sheetName,
			LinkedHashMap<String, String> totalMap, Map<String, String> repMap,OutputStream out) throws CustomAjaxException {
		listToExcel(list, fieldMap, sheetName, 65535,totalMap,repMap, out);
	}

	/**
	 * @MethodName : listToExcel
	 * @Description : 导出Excel（导出到浏览器，可以自定义工作表的大小）
	 * @param list
	 *            数据源
	 * @param fieldMap
	 *            类的英文属性和Excel中的中文列名的对应关系
	 *            每个工作表中记录的最大个数
	 * @param response
	 *            使用response可以导出到浏览器
	 * @param totalMap
	 * 			汇总map
	 * @param repMap
	 * 			替换map
	 */
	public static <T> void listToExcel(List<T> list, LinkedHashMap<String, String> fieldMap, String sheetName,
			LinkedHashMap<String, String> totalMap, Map<String, String> repMap, HttpServletResponse response) {
		// 设置response头信息
				response.reset();
				response.setContentType("application/vnd.ms-excel"); // 改成输出excel文件
				response.setHeader("Content-disposition", "attachment; filename="
						+ sheetName + ".xls");
				// 创建工作簿并发送到浏览器
				try {
					OutputStream out = response.getOutputStream();
					listToExcel(list, fieldMap, sheetName, 65535,totalMap,repMap, out);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	

	/* 辅助方法 */
	/**
	 * @MethodName : getFieldValueByName
	 * @Description : 根据字段名获取字段值
	 * @param fieldName
	 *            字段名
	 * @param o
	 *            对象
	 * @return 字段值
	 */
	private static Object getFieldValueByName(String fieldName, Object o)
			throws Exception {

		Object value = null;
		Field field = getFieldByName(fieldName, o.getClass());

		if (field != null) {
			field.setAccessible(true);
			value = field.get(o);
		} else {
			throw new CustomAjaxException(o.getClass().getSimpleName() + "类不存在字段名 "
					+ fieldName);
		}

		return value;
	}

	/**
	 * @MethodName : getFieldByName
	 * @Description : 根据字段名获取字段
	 * @param fieldName
	 *            字段名
	 * @param clazz
	 *            包含该字段的类
	 * @return 字段
	 */
	private static Field getFieldByName(String fieldName, Class<?> clazz) {
		// 拿到本类的所有字段
		Field[] selfFields = clazz.getDeclaredFields();

		// 如果本类中存在该字段，则返回
		for (Field field : selfFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}

		// 否则，查看父类中是否存在此字段，如果有则返回
		Class<?> superClazz = clazz.getSuperclass();
		if (superClazz != null && superClazz != Object.class) {
			return getFieldByName(fieldName, superClazz);
		}

		// 如果本类和父类都没有，则返回空
		return null;
	}

	/**
	 * @MethodName : getFieldValueByNameSequence
	 * @Description : 根据带路径或不带路径的属性名获取属性值
	 *              即接受简单属性名，如userName等，又接受带路径的属性名，如student.department.name等
	 * 
	 * @param fieldNameSequence
	 *            带路径的属性名或简单属性名
	 * @param o
	 *            对象
	 * @return 属性值
	 * @throws Exception
	 */
	private static Object getFieldValueByNameSequence(String fieldNameSequence,
			Object o) throws Exception {

		Object value = null;

		// 将fieldNameSequence进行拆分
		String[] attributes = fieldNameSequence.split("\\.");
		if (attributes.length == 1) {
			value = getFieldValueByName(fieldNameSequence, o);
		} else {
			// 根据属性名获取属性对象
			Object fieldObj = getFieldValueByName(attributes[0], o);
			String subFieldNameSequence = fieldNameSequence
					.substring(fieldNameSequence.indexOf(".") + 1);
			value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
		}
		return value;

	}

	/**
	 * @MethodName : setColumnAutoSize
	 * @Description : 设置工作表自动列宽和首行加粗
	 * @param ws
	 */
	private static void setColumnAutoSize(WritableSheet ws, int extraWith) {
		// 获取本列的最宽单元格的宽度
		for (int i = 0; i < ws.getColumns(); i++) {
			int colWith = 0;
			for (int j = 0; j < ws.getRows(); j++) {
				String content = ws.getCell(i, j).getContents().toString();
				int cellWith = content.length();
				if (colWith < cellWith) {
					colWith = cellWith;
				}
			}
			// 设置单元格的宽度为最宽宽度+额外宽度
			ws.setColumnView(i, colWith + extraWith);
		}

	}

	/**
	 * @MethodName : fillSheet
	 * @Description : 向工作表中填充数据
	 * @param sheet
	 *            工作表
	 * @param list
	 *            数据源
	 * @param fieldMap
	 *            中英文字段对应关系的Map
	 * @param repMap
	 * 				需要进行替换的map
	 * 
	 * @param firstIndex
	 *            开始索引
	 * @param lastIndex
	 *            结束索引
	 */
	private static <T> void fillSheet(WritableSheet sheet, List<T> list,
			LinkedHashMap<String, String> fieldMap,Map<String, String> repMap, int firstIndex,
			int lastIndex) throws Exception {

		// 定义存放英文字段名和中文字段名的数组
		String[] enFields = new String[fieldMap.size()];
		String[] cnFields = new String[fieldMap.size()];

		// 填充数组
		int count = 0;
		for (Entry<String, String> entry : fieldMap.entrySet()) {
			enFields[count] = entry.getKey();
			cnFields[count] = entry.getValue();
			count++;
		}
		// 填充表头
		for (int i = 0; i < cnFields.length; i++) {
			Label label = new Label(i, 0, cnFields[i]);
			sheet.addCell(label);
		}

		// 填充内容
		int rowNo = 1;
		for (int index = firstIndex; index <= lastIndex; index++) {
			// 获取单个对象
			T item = list.get(index);
			for (int i = 0; i < enFields.length; i++) {
				Object objValue = getFieldValueByNameSequence(enFields[i], item);
				//获取值类型
				if(objValue instanceof Date){
					objValue = DateUtil.formatDatetime((Date) objValue);
				}
				if(objValue instanceof Long){
					objValue = AmountUtils.changeF2Y((Long)objValue);
				}
				String fieldValue = objValue == null ? "" : objValue.toString();
				//2017/06/07新增：
				String value = null;
				if (repMap != null){
					value = repMap.get(enFields[i]+"_"+fieldValue);
				}
				Label label = new Label(i, rowNo, value==null?fieldValue:value);
				sheet.addCell(label);
			}
			rowNo++;
		}

		// 设置自动列宽
		setColumnAutoSize(sheet, 5);
	}
}
