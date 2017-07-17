package com.my.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.my.common.modules.sys.utils.DictUtils;
import com.my.common.utils.Utils;

import java.util.Date;

/**
 * Created by conan on 2017/5/24.
 */
@JsonIgnoreProperties(value = {"rows", "sortBy", "delFlag", "start"})
public abstract class DataEntity {
    protected String id;

    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate;
    //创建人
    protected String createBy;
    //修改人
    protected String updateBy;

    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate;

    //删除标识(0:未删除1：删除)
    protected String delFlag = "0";
    //分页开始
    protected Integer start;
    //分页数量
    protected Integer rows;

    protected String remarks;

    protected String query;

    protected String orderBy;


    public DataEntity() {
        this.rows = Integer.valueOf(DictUtils.getDictValue("page_rows", "page", "10"));
    }

    public DataEntity(String id) {
        this.id = id;
        this.rows = Integer.valueOf(DictUtils.getDictValue("page_rows", "page", "10"));
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if (rows != null) {
            this.rows = rows;
        }
    }


    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        this.setId(Utils.uuid());
        this.updateDate = new Date();
        this.createDate = new Date();
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        this.updateDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setPager(int pageNum, int pageSize) {
        this.rows = pageSize;
        this.start = (pageNum - 1) * pageSize;

    }
}
