package others;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

/**
 * @Author: yangllong
 * @DATE: 2020/7/25 16:53
 */
public class ReadExcel<T> {
    public static void main(String args[]) {
        try {
            long stime=System.currentTimeMillis();
            boolean flag=false;//设置检查标记
            long count=0;//设置计数

            Workbook bookResource = Workbook.getWorkbook(new File("resource.xls"));//打开表1
            Workbook bookKeyWordLib = Workbook.getWorkbook(new File("keyWordLibNew.xls"));//打开表2

            Workbook wb = Workbook.getWorkbook(new File("resourceWrite.xls"));//打开表3
//            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File("resourceWrite.xls"),
                    wb);
//            // 添加一个工作表
            WritableSheet sheet3 = book.getSheet(0);


            // 获得第一个工作表对象
            Sheet sheet1 = bookResource.getSheet(0);
            Sheet sheet2 = bookKeyWordLib.getSheet(0);

            // 得到第一列第一行的单元格
            //行数    sheet1.getRows();
            //列数    sheet1.getColumns();

            for(int i=1;i<sheet1.getRows();i++)//对表1的每行进行循环
            {

                flag=false;//标记为false表示该行没有被检查或者检查过但是没有填值
                for(int columns=0;columns<sheet2.getColumns();columns++)//取表2的列数作为限制
                {
                    if(flag)
                    {
                        break;
                    }//该行检查过并且已经有值  检查下一行

                    for(int rows=1;rows<sheet2.getColumn(columns).length-1;rows++)//取表2每列的行数作为限制条件
                    {
                        if(sheet1.getCell(11, i).getContents().contains(
                                sheet2.getCell(columns, rows).getContents()))//匹配对应单元格的内容
                        {


                            sheet3.addCell(
                                    new Label(9, i, new String(((Integer)(columns+1)).toString())));//设置对应单元格内容
                            System.out.println(columns+" "+rows);
                            count++;
                            flag=true;//标记为true
                            break;
                        }

                    }
                }
            }
            book.write();

            System.out.println(count);

            bookResource.close();
            bookKeyWordLib.close();
            book.close();
            wb.close();//关闭所有表 否侧表格会损坏
            long etime=System.currentTimeMillis();
            System.out.println(etime-stime);
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }
}
