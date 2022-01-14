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
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
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
        //indexRequest.id("7");
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
        SearchRequest searchRequest = new SearchRequest("mobile_index");
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 查询所有内容
     * @throws IOException
     */
    @Test
    public void searchByContext() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 匹配搜索-or条件查询
     * @throws IOException
     */
    @Test
    public void searchByMatchOr() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("title","小米电视4A"));
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 匹配搜索-and条件查询
     * @throws IOException
     */
    @Test
    public void searchByMatchAnd() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("title","小米电视4A").operator(Operator.AND));
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 短语搜索
     * @throws IOException
     */
    @Test
    public void searchByMatchPhrase() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("title","小米 4A").slop(2));
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * Query String 无需指定字段的全文搜索，同时也支持指定字段进行搜索匹配
     * @throws IOException
     */
    @Test
    public void searchByQueryString() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.queryStringQuery("3699").defaultField("price"));
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * Query String 多字段查询，也可以使用*匹配多个字段
     * @throws IOException
     */
    @Test
    public void searchByMultiMatch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("mobile_index");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("2639*","price","title"));
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 词条搜索/集合搜索
     * @throws IOException
     */
    @Test
    public void searchByTermQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.termQuery("title","vivo"));
        searchSourceBuilder.query(QueryBuilders.termsQuery("title","vivo","iphone"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 范围搜索
     * @throws IOException
     */
    @Test
    public void searchByRange() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.rangeQuery("price").lt(3000));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 不为空查询搜索
     * @throws IOException
     */
    @Test
    public void searchByNotBlank() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.existsQuery("title"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 前缀查询
     * @throws IOException
     */
    @Test
    public void searchByPrefix() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.prefixQuery("title","vi"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 通配符搜索
     * @throws IOException
     */
    @Test
    public void searchByWildcard() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.wildcardQuery("title","i*"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 正则搜索
     * @throws IOException
     */
    @Test
    public void searchByRegexp() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.regexpQuery("title","i.*"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * 模糊搜索
     * @throws IOException
     */
    @Test
    public void searchByFuzzy() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("title","vi").fuzziness(Fuzziness.TWO));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }

    /**
     * ids搜索
     * @throws IOException
     */
    @Test
    public void searchById() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("_id","-lQ8Un4BlEAo15wif5It"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = esService.search(searchRequest);
        log.info("查询返回结果：{}",response);
    }
}