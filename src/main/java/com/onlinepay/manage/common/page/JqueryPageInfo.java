package com.onlinepay.manage.common.page;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * Created by tom on 17/7/11.
 */
public class JqueryPageInfo<T> {
    private Integer draw;// 绘制计数器。这个是用来确保Ajax从服务器返回的是对应的
    private Long recordsTotal;// 即没有过滤的记录数（数据库里总共记录数）
    private Long recordsFiltered;// 过滤后的记录数（如果有接收到前台的过滤条件，则返回的是过滤后的记录数）
    private Integer start;// 第一条数据的起始位置，比如0代表第一条数据
    private Integer length;// 告诉服务器每页显示的条数，这个数字会等于返回的
    private List<T> data;
    private Integer pageNum;
    private String code;
    /**
     * 2017/06/07新增
     * 用于返回额外数据字段：如统计、切换
     */
    private Map<String, Object> map;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
