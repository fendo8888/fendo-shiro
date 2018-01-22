/**
 * projectName: fendo-plus-boot
 * fileName: PaginationResult.java
 * packageName: com.fendo.shiro.common.utils
 * date: 2018-01-18 16:45
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.shiro.common.utils;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: PaginationResult
 * @packageName: com.fendo.shiro.common.utils
 * @description: bootstrap-table数据
 * @data: 2018-01-18 16:45
 **/
public class PaginationResult {

    private long total;

    private List<?> rows;

    public PaginationResult(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PaginationResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
