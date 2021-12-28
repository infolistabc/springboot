package com.sun.es.service.impl;

import com.sun.es.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author qiansl
 * @version 1.0
 * @date 2021/12/28 10:25 上午
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EsServiceImplTest {

    @Resource
    EsService esService;



    @Test
    public void createIndex() throws IOException {
        //创建文档索引
        IndexRequest indexRequest = new IndexRequest("posts");
        //文档id
        indexRequest.id("7");
        String jsonString = "{" +
                "\"user\":\"test\"," +
                "\"postDate\":\"2013-01-26\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        //文档内容
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse resp = esService.createIndex(indexRequest);
        log.info("创建索引返回结果：{}",resp);
    }

    /**
     * 更新文档
     * @throws IOException
     */
    @Test
    public void updateIndex() throws IOException {
        //创建文档索引
        UpdateRequest updateRequest = new UpdateRequest("posts" ,"7");
        //文档id
        String jsonString = "{" +
                "\"user\":\"test\"," +
                "\"postDate\":\"2013-01-26\"," +
                "\"message\":\"update test\"" +
                "}";
        //文档内容
        updateRequest.doc(jsonString, XContentType.JSON);
        UpdateResponse resp = esService.update(updateRequest);
        log.info("更新返回结果：{}",resp);
    }

    /**
     * 删除
     * @throws IOException
     */
    @Test
    public void delete() throws IOException {
        //创建文档索引
        DeleteRequest deleteRequest = new DeleteRequest("posts" ,"7");
        //文档内容
        DeleteResponse resp = esService.delete(deleteRequest);
        log.info("删除返回结果：{}",resp);
    }

    /**
     * 删除
     * @throws IOException
     */
    @Test
    public void deleteContext() throws IOException {
        //创建文档索引
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest("posts");
        deleteByQueryRequest.setQuery(new RangeQueryBuilder("postDate").from("2013-01-29").to("2013-01-30"));
        //文档内容
        BulkByScrollResponse resp = esService.deleteByContext(deleteByQueryRequest);
        log.info("删除返回结果：{}",resp);
    }



    /**
     * 查询某个文档库，多个文档库用逗号隔开
     * @throws IOException
     */
    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("posts");
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 查询所有内容
     * @throws IOException
     */
    @Test
    public void searchByContext() throws IOException {
        SearchRequest searchRequest = new SearchRequest("posts");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 查询所有user字段且包含test的文档
     * @throws IOException
     */
    @Test
    public void searchByColumn() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("user","test"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 根据ID查询数据
     * @throws IOException
     */
    @Test
    public void searchById() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("_id",1));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 根据时间段进行数据查询
     * @throws IOException
     */
    @Test
    public void searchTime() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //时间查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.rangeQuery("postDate").from("2013-01-28").to("2013-01-29"));
        searchSourceBuilder.query(boolQueryBuilder);

        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }


}