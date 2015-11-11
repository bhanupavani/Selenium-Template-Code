package com.selnm;

import java.io.File;
import java.lang.reflect.Method;

import jxl.Sheet;
import jxl.Workbook;

public class Driver {
	public static void main(String[] args) throws Exception {
		// open excel file
		File f = new File("C:\\Users\\Pretty\\Desktop\\personal\\TC.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sh1 = wb.getSheet(0);
		int nor = sh1.getRows();
		Sheet sh2 = wb.getSheet(1);
		int nos = sh2.getRows();
		//create array for methods in myAction class
		MyActions a = new MyActions();
		Method m[] = a.getClass().getMethods();
		for (int i = 0; i < nor; i++) {
			String tname = sh1.getCell(0, i).getContents();
			String mode = sh1.getCell(2, i).getContents();
			if (mode.equalsIgnoreCase("yes")) {
				for (int j = 0; j < nos; j++) {
					String tid = sh2.getCell(0, j).getContents();
					if (tname.equalsIgnoreCase(tid)) {
						String taction = sh2.getCell(2, j).getContents();
						String objdec = sh2.getCell(3, j).getContents();
						String testdata = sh2.getCell(4, j).getContents();
						String criteria = sh2.getCell(5, j).getContents();
						System.out.println(taction + "," + objdec + ","
								+ testdata + "," + criteria);
						for (int k = 0; k < m.length; k++) {
							if (m[k].getName().equals(taction)) {
								m[k].invoke(a, objdec, testdata, criteria);
								break;
							}

						}

					}

				}

			}

		}

		wb.close();
	}

}
