package com.sun.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sun.entity.Student;
import com.sun.entity.Table;
import com.sun.entity.TableInfo;
import com.sun.service.ITableInfoService;
import com.sun.utils.ExcelUtil;
import com.sun.utils.ToBeanUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author wilson
 */
@RestController
@RequestMapping("table")
public class TableInfoController {
    @Resource
    private ITableInfoService iTableInfoService;

    @GetMapping("list")
    public List<Map> getAllTableInfo(String dataBase){
        return iTableInfoService.listAllTableInfo(dataBase);
    }
    @GetMapping("listTableColumn")
    public List<Map> listTableColumn(String dataBase, String tableName){
        return iTableInfoService.listTableColumn(dataBase,tableName);
    }
    @GetMapping("download")
    public void download(HttpServletResponse response,String dataBase) throws IOException {

        List<Map> list = iTableInfoService.listAllTableInfo(dataBase);
        List<TableInfo> tableInfo = new ArrayList<>();
        list.forEach(x->{
            tableInfo.add(ToBeanUtil.mapToBean(x,new TableInfo()));
        });

        Map<String, List<TableInfo>> map = tableInfo.stream().collect(Collectors.groupingBy(TableInfo::getTABLE_NAME));

        List<List<Table>> allTables = new ArrayList<>();
        map.values().forEach(x->{
            List<Table> tables = new ArrayList<>();
            AtomicInteger j= new AtomicInteger(1);
            x.forEach(y->{
                Table table = null;
                table = new Table();
                table.setIndex(j.getAndIncrement());
                table.setColumnComment(y.getCOLUMN_COMMENT());
                table.setColumnKey(y.getCOLUMN_KEY());
                table.setColumnName(y.getCOLUMN_NAME());
                table.setColumnType(y.getCOLUMN_TYPE());
                table.setIsNullable(y.getIS_NULLABLE());
                table.setTableName(y.getTABLE_NAME());
                tables.add(table);
            });
            allTables.add(tables);
            });

        try {
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            //String fileName = URLEncoder.encode("视频图库数据库", "UTF-8");
//            String fileName = "/Users/wilson/测试.xlsx";
//            ExcelWriter excelWriter = EasyExcel.write(fileName).build();
//            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//           for(int i=0;i<allTables.size();i++){
//            WriteSheet writeSheet = EasyExcel.writerSheet(i, allTables.get(i).get(0).getTableName()).head(Table.class).build();
//            excelWriter.write(allTables.get(i), writeSheet);
//
//
//          }
           // excelWriter.finish();
            String fileName = "/Users/wilson/测试.xlsx";
            ExcelUtil.repeatedWrite(fileName,"测试",Table.class, allTables.stream().collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取map中第一个数据值
     *
     * @param map 数据源
     * @return
     */
    private static List<TableInfo> getFirstOrNull(Map<String, List<TableInfo>> map) {
        List<TableInfo> obj = null;
        for (Map.Entry<String, List<TableInfo>> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;

    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws Exception{
        String fileName="报表";
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        List<Student> studentList=new ArrayList<Student>();
        Student student=new Student("1","张三","2000-01-01");
        studentList.add(student);
        //这里 需要指定写用哪个class去写
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "学生信息1").head(Student.class).build();
        excelWriter.write(studentList, writeSheet);
        writeSheet = EasyExcel.writerSheet(1, "学生信息2").head(Student.class).build();
        excelWriter.write(studentList, writeSheet);
        //千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }
}
