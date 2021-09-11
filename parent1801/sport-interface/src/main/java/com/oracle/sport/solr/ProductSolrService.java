package com.oracle.sport.solr;

import cn.itcast.common.page.Pagination;

public interface ProductSolrService {

	public Pagination selectProductsSolr(String keyword,Integer pageNo,Integer pageSize);
}
