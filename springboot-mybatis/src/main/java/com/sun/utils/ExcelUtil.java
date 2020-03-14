package com.sun.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sun.entity.Table;

import java.util.List;

/**
 * @author wilson
 */
public class ExcelUtil {
    /**
     * 单个Excel导出
     * @param fileName 文件全路径（包含文件的名称）
     * @param sheetName 工作表名称
     * @param head  导出表格的对象
     * @param data  写入表格数据
     */
    public static void write(String fileName, String sheetName, Class head, List data){
        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet(sheetName).head(head).build();
        excelWriter.write(data, writeSheet);
        //关闭流
        excelWriter.finish();
    }

    /**
     * 单个Excel，多个sheet导出
     * @param fileName 文件全路径（包含文件的名称）
     * @param sheetName 工作表名称
     * @param head 导出表格的对象
     * @param data 写入表格数据
     */
    public static void repeatedWrite(String fileName, String sheetName, Class head, List<List<?>> data){
        ExcelWriter excelWriter = EasyExcel.write(fileName, head).build();
        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
        for (int i = 0; i < data.size(); i++) {
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetName+i).build();
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            excelWriter.write(data.get(i), writeSheet);
        }
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }
}
