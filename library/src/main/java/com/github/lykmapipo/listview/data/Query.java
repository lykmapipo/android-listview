package com.github.lykmapipo.listview.data;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Data query builder
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class Query {
    // specific search query condition
    String q;

    // specific page condition
    Long page = 1L;

    // specific limit condition
    Long limit = 10L;

    /**
     * Instantiate default query
     *
     * @return {@link Query}
     * @since 0.1.0
     */
    public static synchronized Query create() {
        Query query = new Query();
        query.page(1L);
        query.limit(10L);
        return query;
    }

    /**
     * Create default query map
     *
     * @return {@link Map}
     * @since 0.1.0
     */
    public static synchronized Map<String, String> defaultQueryMap() {
        Query query = create();
        return query.toQueryMap();
    }

    /**
     * Convert {@link Query} to valid query map for use with api calls or database querying
     *
     * @return {@link Map}
     * @since 0.1.0
     */
    public Map<String, String> toQueryMap() {
        // initialize query map
        HashMap<String, String> queryMap = new HashMap<String, String>();

        // handle search query condition
        if (!TextUtils.isEmpty(q)) {
            queryMap.put("q", q);
        }

        // handle page condition
        queryMap.put("page", String.valueOf(page == null ? 1L : page));

        // handle limit condition
        queryMap.put("limit", String.valueOf(limit == null ? 10L : limit));

        // return query map
        return queryMap;
    }

    /**
     * Append search query condition
     *
     * @param q valid search query
     * @return {@link Query}
     * @since 0.1.0
     */
    public Query search(String q) {
        this.q = q;
        return this;
    }

    /**
     * Append page query condition
     *
     * @param page valid page number
     * @return {@link Query}
     * @since 0.1.0
     */
    public Query page(Long page) {
        this.page = page;
        return this;
    }

    /**
     * Append page query condition
     *
     * @param limit valid page number
     * @return {@link Query}
     */
    public Query limit(Long limit) {
        this.limit = limit;
        return this;
    }
}
