package com.github.lykmapipo.listview.data;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Data query builder
 *
 * @author lally elias <lallyelias87@gmail.com>
 * @since 0.1.0
 */
public class Query {
    // query map data keys
    public static final String KEY_SEARCH = "q";
    public static final String KEY_PAGE = "page";
    public static final String KEY_LIMIT = "limit";
    public static final String KEY_FILTER = "filter";
    public static final String KEY_FIELDS = "fields";
    public static final String KEY_SORT = "sort";
    public static final String KEY_POPULATE = "populate";

    // specific search query condition
    String q;

    // specific page condition
    Long page = 1L;

    // specific limit condition
    Long limit = 10L;

    /**
     * Instantiate default {@link Query}
     *
     * @return {@link Query}
     * @since 0.1.0
     */
    @NonNull
    public static synchronized Query create() {
        Query query = new Query();
        query.page(1L);
        query.limit(10L);
        return query;
    }

    /**
     * Instantiate new {@link Query}
     *
     * @param page valid page
     * @return {@link Query}
     * @since 0.1.0
     */
    @NonNull
    public static synchronized Query create(@NonNull Long page) {
        Query query = new Query();
        query.page(page);
        query.limit(10L);
        return query;
    }

    /**
     * Instantiate new {@link Query}
     *
     * @param q    valid search term
     * @param page valid page
     * @return {@link Query}
     * @since 0.1.0
     */
    @NonNull
    public static synchronized Query create(@NonNull String q, @NonNull Long page) {
        Query query = new Query();
        query.search(q);
        query.page(page);
        query.limit(10L);
        return query;
    }

    /**
     * Create default query map
     *
     * @return {@link Map}
     * @since 0.1.0
     */
    @NonNull
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
    @NonNull
    public Map<String, String> toQueryMap() {
        // initialize query map
        HashMap<String, String> queryMap = new HashMap<String, String>();

        // handle search query condition
        if (!TextUtils.isEmpty(q)) {
            queryMap.put(KEY_SEARCH, q);
        }

        // handle page condition
        queryMap.put(KEY_PAGE, String.valueOf(page == null ? 1L : page));

        // handle limit condition
        queryMap.put(KEY_LIMIT, String.valueOf(limit == null ? 10L : limit));

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
    @NonNull
    public Query search(@NonNull String q) {
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
    @NonNull
    public Query page(@NonNull Long page) {
        this.page = page;
        return this;
    }

    /**
     * Append page query condition
     *
     * @param limit valid page number
     * @return {@link Query}
     */
    @NonNull
    public Query limit(@NonNull Long limit) {
        this.limit = limit;
        return this;
    }
}
