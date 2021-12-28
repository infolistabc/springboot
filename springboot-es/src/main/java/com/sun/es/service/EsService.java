package com.sun.es.service;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;

import java.io.IOException;

/**
 * @author qiansl
 * @version 1.0
 * @date 2021/12/27 11:30 上午
 * @description
 */
public interface EsService {

    SearchResponse search(SearchRequest searchRequest) throws IOException;

    IndexResponse createIndex(IndexRequest indexRequest) throws IOException;

    UpdateResponse update(UpdateRequest updateRequest) throws IOException;

    DeleteResponse delete(DeleteRequest deleteRequest) throws IOException;

    BulkByScrollResponse deleteByContext(DeleteByQueryRequest deleteByQueryRequest) throws IOException;
}
