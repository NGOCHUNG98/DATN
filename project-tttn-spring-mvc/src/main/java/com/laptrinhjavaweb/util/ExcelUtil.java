package com.laptrinhjavaweb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private List<String> fieldNames = new ArrayList<String>();
	private Workbook workbook = null;
	private String workBookName = "";

	public ExcelUtil(String workBookName) {
		super();
		this.workBookName = workBookName;
		initialize();
	}

	private void initialize() {
		setWorkbook(new HSSFWorkbook());
	}

	public void closeWorksheet() {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(getWorkBookName());
			getWorkbook().write(fileOutputStream);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private boolean setupFieldsForClass(Class clazz) throws Exception {
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return true;
	}

	@SuppressWarnings("unused")
	private Sheet getSheetWithName(String name) {
		Sheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (name.compareTo(workbook.getSheetName(i)) == 0) {
				sheet = workbook.getSheetAt(i);
				break;
			}
		}
		return sheet;
	}

	private void initializeForRead() throws InvalidFormatException, IOException {
		InputStream inp = new FileInputStream(getWorkBookName());
		workbook = WorkbookFactory.create(inp);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> readData(String classname) throws Exception {
		try {
			initializeForRead();
			Sheet sheet = getSheetWithName(workbook.getSheetName(0));
			Class clazz = Class.forName(classname);
			setupFieldsForClass(clazz);
			List<T> result = new ArrayList<T>();
			Row row;
			for (int rowCount = 1; rowCount < 4; rowCount++) {
				T one = (T) clazz.newInstance();
				row = sheet.getRow(rowCount);
				if (row != null) {
					int colCount = 0;
					result.add(one);
					fieldNames.remove("base64");
					fieldNames.remove("categoryEntity");
					for (Cell cell : row) {
						String fieldName = fieldNames.get(colCount++);
						Method method = constructMethod(clazz, fieldName);
						CellType cellType = cell.getCellTypeEnum();
						if (cellType == CellType.STRING) {
							String value = cell.getStringCellValue();
							Object[] values = new Object[1];
							values[0] = value;
							method.invoke(one, values);
						} else if (cellType == CellType.NUMERIC) {
							Double num = cell.getNumericCellValue();
							Class returnType = getGetterReturnClass(clazz, fieldName);
							if (returnType == int.class || returnType == Integer.class) {
								method.invoke(one, num.intValue());
							} else if (returnType == double.class || returnType == Double.class) {
								method.invoke(one, num);
							} else if (returnType == float.class || returnType == Float.class) {
								method.invoke(one, num.floatValue());
							} else if (returnType == long.class || returnType == Long.class) {
								method.invoke(one, num.longValue());
							}
						} else if (cellType == CellType.BOOLEAN) {
							boolean num = cell.getBooleanCellValue();
							Object[] values = new Object[1];
							values[0] = num;
							method.invoke(one, values);
						}
					}
				}
			}
			return result;
		} catch (Exception e) {
			return null;
		}

	}

	private Class getGetterReturnClass(Class clazz, String fieldName) {
		String methodName = "get" + capitalize(fieldName);
		String methodIsName = "is" + capitalize(fieldName);
		Class returnType = null;
		for (Method method : clazz.getMethods()) {
			if (method.getName().equals(methodName) || method.getName().equals(methodIsName)) {
				returnType = method.getReturnType();
				break;
			}
		}
		return returnType;
	}

	@SuppressWarnings("unchecked")
	private Method constructMethod(Class clazz, String fieldName) throws SecurityException, NoSuchMethodException {
		Class fieldClass = getGetterReturnClass(clazz, fieldName);
		return clazz.getMethod("set" + capitalize(fieldName), fieldClass);
	}

	public <T> void writeData(List<T> data) throws Exception {
		try {
			Sheet sheet = getWorkbook().createSheet(data.get(0).getClass().getName());
			setupFieldsForClass(data.get(0).getClass());
			int rowCount = 0;
			int columnCount = 0;
			Row row = sheet.createRow(rowCount++);
			for (String fieldName : fieldNames) {
				Cell cel = row.createCell(columnCount++);
				cel.setCellValue(fieldName);
			}
			Class<? extends Object> classz = data.get(0).getClass();
			for (T t : data) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					Cell cel = row.createCell(columnCount);
					Method method = classz.getMethod("get" + capitalize(fieldName));
					Object value = method.invoke(t, (Object[]) null);
					if (value != null) {
						if (value instanceof String) {
							cel.setCellValue((String) value);
						} else if (value instanceof Long) {
							cel.setCellValue((Long) value);
						} else if (value instanceof Integer) {
							cel.setCellValue((Integer) value);
						} else if (value instanceof Double) {
							cel.setCellValue((Double) value);
						} else if (value instanceof Boolean) {
							cel.setCellValue((Boolean) value);
						}
					}
					columnCount++;
				}
			}

			// Autofit
			for (int i = 0; i < fieldNames.size(); i++)
				sheet.autoSizeColumn(i);

			FileOutputStream out = new FileOutputStream(new File(workBookName));
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String capitalize(String string) {
		String capital = string.substring(0, 1).toUpperCase();
		return capital + string.substring(1);
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public String getWorkBookName() {
		return workBookName;
	}

	public void setWorkBookName(String workBookName) {
		this.workBookName = workBookName;
	}

}
