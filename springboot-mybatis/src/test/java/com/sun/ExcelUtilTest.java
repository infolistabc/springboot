package com.sun;

import com.sun.entity.Student;
import com.sun.entity.Table;
import com.sun.entity.TableInfo;
import com.sun.service.ITableInfoService;
import com.sun.utils.ExcelUtil;
import com.sun.utils.ToBeanUtil;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MybatisApplication.class)
@WebAppConfiguration
public class ExcelUtilTest {
    @Resource
    private ITableInfoService iTableInfoService;
    @Test
    public void testWrite(){
        List<Student> studentList=new ArrayList<Student>();
        Student student=new Student("1","张三","2000-01-01");
        studentList.add(student);
        String fileName = "/Users/wilson/学生.xlsx";
        ExcelUtil.write(fileName,"学生信息",Student.class,studentList);
    }
    @Test
    public void testRepeatedWrite(){
        String database = "viid";
        List<Map> list = iTableInfoService.listAllTableInfo(database);
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
        String fileName = "/Users/wilson/测试.xlsx";
        ExcelUtil.repeatedWrite(fileName,"测试",Table.class, allTables.stream().collect(Collectors.toList()));
    }
}
