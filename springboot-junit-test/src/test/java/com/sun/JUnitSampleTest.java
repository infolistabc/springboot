package com.sun;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=JunitTestApp.class)
public class JUnitSampleTest {
	@Test
	@Tag("fast")
	public void  testString() {
		//字符串判断
		String s = "abcde";
		Assertions.assertTrue(s.startsWith("ab"));
		Assertions.assertTrue(s.endsWith("de"));
		Assertions.assertEquals(5, s.length());
	}
	@Test
	@Tag("slow")
	public void testInt() {
		//整形判断
		int num = 50;
		Assertions.assertTrue(num>49);
		Assertions.assertTrue(num==50);
		Assertions.assertTrue(num<100);
	}
	@Test
	public void testArray() {
		//数组判断
		String [] array1 = {"a","b","c","d","e"};
		String [] array2 = {"a","b","c","d","e"};
		//比较两个数组的内容是否相当
		Assertions.assertArrayEquals(array1, array2);
		int [] arrNum1 = {1,2,3,4};
		int [] arrNum2 = {1,2,3,4};
		Assertions.assertArrayEquals(arrNum1, arrNum2);
	}
	@Test
	public void testDate() {
		//时间比较
		Date date1 = new Date();
		Date date2 = new Date(date1.getTime()+100);
		Date date3 = new Date(date1.getTime()-100);
		Assertions.assertTrue(date1.before(date2));
		Assertions.assertTrue(date1.after(date3));
	}
	@Test
	public void testList() {
		//list集合比较
		List<String> list1 = Arrays.asList("a","b,","c","d");
		Assertions.assertEquals("a", list1.get(0));
		Assertions.assertEquals(4, list1.size());
		//通过集合的下标获取最后一个元素，在进行比较
		Assertions.assertEquals("d", list1.get(list1.size()-1));
		List<String> list2 = Arrays.asList("a","b,","c","d");
		//比较的是两个集合的元素是否一致
		Assertions.assertEquals(list1, list2);
	}
	@Test
	public void testMap() {
		Map<String,Object> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Set<String> set = map.keySet();
		Assertions.assertEquals(3, map.size());
		//比较两个map集合的内容是否一致
		Assertions.assertTrue(set.containsAll(Arrays.asList("A","B","C")));
		//判断set集合是否包含A元素
		Assertions.assertTrue(set.contains("A"));
	}
}
