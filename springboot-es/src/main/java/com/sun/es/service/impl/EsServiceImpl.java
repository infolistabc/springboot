package com.sun.es.service.impl;

import com.sun.es.service.EsService;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.io.stream.BytesStreamOutput;
import org.elasticsearch.common.io.stream.NamedWriteableAwareStreamInput;
import org.elasticsearch.common.io.stream.NamedWriteableRegistry;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.indices.IndicesModule;
import org.elasticsearch.search.SearchModule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

/**
 * @author qiansl
 * @version 1.0
 * @date 2021/12/27 11:31 上午
 * @description
 */
@Service
public class EsServiceImpl implements EsService {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public SearchResponse search(SearchRequest searchRequest) throws IOException {
        return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }

    @Override
    public IndexResponse createIndex(IndexRequest indexRequest) throws IOException {
        return restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
    }

    @Override
    public UpdateResponse update(UpdateRequest updateRequest) throws IOException {
        return restHighLevelClient.update(updateRequest,RequestOptions.DEFAULT);
    }

    @Override
    public DeleteResponse delete(DeleteRequest deleteRequest) throws IOException {
        return restHighLevelClient.delete(deleteRequest,RequestOptions.DEFAULT);
    }

    @Override
    public BulkByScrollResponse deleteByContext(DeleteByQueryRequest deleteByQueryRequest) throws IOException {
        return restHighLevelClient.deleteByQuery(deleteByQueryRequest,RequestOptions.DEFAULT);
    }

    /**
     * 转换 String -> SearchRequest
     *
     *
     * @param content
     * @return
     * @throws IOException
     */
    private SearchRequest convertString2SearchRequest(String content) throws IOException {

        // base64解码
        byte[] s1 = Base64.getDecoder().decode(content);
        BytesStreamOutput bytesStreamOutput = new BytesStreamOutput();
        bytesStreamOutput.write(s1);

        // 设置解析器
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
        SearchModule searchModule = new SearchModule(Settings.EMPTY, false, Collections.emptyList());
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
        entries.addAll(indicesModule.getNamedWriteables());
        entries.addAll(searchModule.getNamedWriteables());
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(entries);

        // 转换成输入流
        StreamInput in = new
                NamedWriteableAwareStreamInput(bytesStreamOutput.bytes().streamInput(), namedWriteableRegistry);

        // 还原
        SearchRequest searchRequest = new SearchRequest(in);

        return searchRequest;
    }

    /**
     * 转换 String -> SearchScrollRequest
     *
     * @param content
     * @return
     * @throws IOException
     */
    private SearchScrollRequest convertString2SearchScrollRequest(String content) throws IOException {

        // base64解码
        byte[] s1 = Base64.getDecoder().decode(content);
        BytesStreamOutput bytesStreamOutput = new BytesStreamOutput();
        bytesStreamOutput.write(s1);

        // 设置解析器
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
        SearchModule searchModule = new SearchModule(Settings.EMPTY, false, Collections.emptyList());
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();
        entries.addAll(indicesModule.getNamedWriteables());
        entries.addAll(searchModule.getNamedWriteables());
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(entries);

        // 转换成输入流
        StreamInput in = new
                NamedWriteableAwareStreamInput(bytesStreamOutput.bytes().streamInput(), namedWriteableRegistry);

        // 还原
        SearchScrollRequest searchRequest = new SearchScrollRequest(in);

        return searchRequest;
    }


}
