package com.taotao.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * EasyUIDataGridResult
 *
 * @author Yang
 * @date 2018/7/17
 */
public class EasyUIDataGridResult implements Serializable {
    private long total;
    private List rows;

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

    public EasyUIDataGridResult() {
    }

    public EasyUIDataGridResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
