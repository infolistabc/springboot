package com.sun.es.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.es.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.snapshots.SnapshotShardsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @Test
    public void createIndex() throws IOException {
//        //创建文档索引
        IndexRequest indexRequest = new IndexRequest("twitter6");
//        //文档id
        String jsonString = "{" +
                "\"bbb\":\"tessst\"," +
                "\"postDate\":\"2013-01-26\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        //文档内容
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse resp =restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        log.info("创建索引返回结果：{}",resp);

//        CreateIndexRequest request = new CreateIndexRequest("twitter6ff");
//        request.settings(Settings.builder().put("index.number_of_shards", 3)
//                .put("index.number_of_replicas", 2));
//        String str = "{\n" +
//                "  \"properties\":{\n" +
//                "\t\"bbb\": {\n" +
//                "\t\t\"type\": \"text\",\n" +
//                "\t\t\"store\": \"true\"\n" +
//                "\t}\n" +
//                "  }\t\n" +
//                "}";
//        request.mapping(str, XContentType.JSON);
//
//        // 2、客户端执行请求 IndicesClient,请求后获得响应
//        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse);
    }

    @Test
    public void queryIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("twitter3");

        // 2、客户端执行请求 IndicesClient,请求后获得响应
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
        String[] indices = getIndexResponse.getIndices();
        System.out.println(JSONObject.toJSON(indices));
    }

    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("twitter3");

        // 2、客户端执行请求 IndicesClient,请求后获得响应
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
    }

    @Test
    public void putMapping() throws IOException {
        PutMappingRequest request = new PutMappingRequest("twitter3");
        request.source(
                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"message\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);
        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().putMapping(request, RequestOptions.DEFAULT);
        System.out.println(acknowledgedResponse.isAcknowledged());
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
        DeleteRequest deleteRequest = new DeleteRequest("blog8rr" ,"HLAOfYIBOBSYCKYbU5FC");
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
        searchSourceBuilder.query(QueryBuilders.termQuery("title","手机"));
        //searchSourceBuilder.query(QueryBuilders.termsQuery("title","vivo","iphone"));
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

    /**
     * 分页查询
     * @throws IOException
     */
    @Test
    public void scroll() throws IOException {
        //todo：初始化scroll
        //失效时间为1min
        Scroll scroll = new Scroll(TimeValue.timeValueMinutes(50L));
        SearchRequest searchRequest = new SearchRequest("mobile_index");
        //查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //searchSourceBuilder.query(QueryBuilders.matchQuery("title","小米电视4A"));
        //分页参数
        searchSourceBuilder.size(2);
        searchRequest.source(searchSourceBuilder);
        //封存快照
        searchRequest.scroll(scroll);

        SearchResponse response = esService.search(searchRequest);
        log.info("初始化scroll：{}",response);

        //todo：遍历
        SearchScrollRequest searchScrollRequest = new SearchScrollRequest();
        searchScrollRequest.scrollId(response.getScrollId());
        searchScrollRequest.scroll(scroll);

        SearchResponse scrollResp = esService.scroll(searchScrollRequest);
        log.info("查询返回结果：{}",scrollResp);
    }
}