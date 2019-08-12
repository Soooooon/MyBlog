package com.example.myblog.controller.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Pager<T> {

    //允许的最大页数
    public static int MAX_PAGE_SIZE = 500;

    //批处理时每次页数
    public static int HANDLE_PAGE_SIZE = 500;

    //当前页码。 1基
    private long page;


    private long pageSize;

    //总条目数
    private long totalItems;

    //总页数
    private long totalPages;

    private List<T> data;


    public Pager(long page, long pageSize, long totalItems, List<T> data) {

        if (pageSize <= 0) {
            pageSize = 10;
        }

        this.page = page;

        this.pageSize = pageSize;

        this.totalItems = totalItems;

        this.totalPages = (long) Math.ceil(this.totalItems * 1.0 / this.pageSize);

        this.data = data;

    }


    public Pager(Pager pager) {


        this.page = pager.getPage();

        this.pageSize = pager.getPageSize();

        this.totalItems = pager.getTotalItems();

        if (pageSize <= 0) {
            pageSize = 10;
        }

        this.totalPages = (long) Math.ceil(this.totalItems * 1.0 / this.pageSize);

    }


}
