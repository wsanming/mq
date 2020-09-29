package com.goktech.olala.core.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageNavigate implements Serializable {

    private static final long serialVersionUID = 1L;
    private int start; // start表示当前页开始的记录数,start=每页行数*(当前页数-1)
    private int end; // 当前页结束的记录行数
    private int totalCount; // 总行数
    private int rowsPerPage = 1; // 每页行数，默认10
    private int currentPage; // 当前页数
    private int pageListSize = 6;// 页码列表大小，默认9
    private List<Integer> pageNumList = new ArrayList<Integer>();

    public PageNavigate() {
        this.start = 0;
        this.end = 0;
        this.totalCount = 1;
        this.currentPage = 0;
    }
    public PageNavigate(int totalCount) {
        this.start = 0;
        this.end = 0;
        this.totalCount = 1;
        this.totalCount = totalCount;
    }
    public PageNavigate(int totalCount, int numPerPage) {
        this.start = 0;
        this.end = 0;
        this.totalCount = totalCount;
        currentPage = 1;
        if (numPerPage > 0) {
            rowsPerPage = numPerPage;
        }
    }
    /**
     * 执行翻页动作
     *
     * @param currentPage
     *            要翻到的目标页码
     * @return 返回翻页对象
     */
    public PageNavigate doPagination(int currentPage) {
        gotoPage(currentPage);
        return this;
    }

    // 设置起始数
    public int getStart() {
        start = rowsPerPage * (currentPage - 1);
        return start;
    }

    // 得到起始数
    public void setStart(int start) {
        if (start < 0) {
            this.start = 0;
        } else if (start >= this.totalCount) {
            this.start = this.totalCount - 1;
        } else {
            this.start = start;
        }
    }

    // 设置当前页的最后一行的在总记录中的顺序(从0开始)
    public void setEnd(int end) {
        this.end = end;
    }

    // 得到当前页的最后一行的在总记录中的顺序(从0开始)
    public int getEnd() {
        if (rowsPerPage * currentPage > this.totalCount) {
            end = this.totalCount - 1;
        } else {
            end = rowsPerPage * currentPage - 1;
        }
        return end;
    }

    // 以下4个方法供控制器(struts)调用

    // 判断能否到第一页;只要能到上一页，肯定就有第一页
    public boolean firstEnable() {
        return previousEnable();
    }

    // 判断能否到上一页
    public boolean previousEnable() {
        return currentPage > 1;// 只要不是第一页，就能到上一页
    }

    // 判断能否到下一页
    public boolean nextEnable() {
        return currentPage * rowsPerPage < this.totalCount;
    }

    // 判断能否到最后一页；只要有下一页，就肯定有最后一页.
    public boolean lastEnable() {
        return nextEnable();
    }

    // 跳到第一页
    public void firstPage() {
        currentPage = 1;
    }

    // 跳到上一页
    public void previousPage(int cPage) {
        currentPage = (cPage - 1) > 0 ? (cPage - 1) : 1;
    }

    // 跳到下一页
    public void nextPage(int cPage) {
        currentPage = cPage + 1;
        if (currentPage * rowsPerPage > this.totalCount) {
            lastPage();
        }
    }

    // 跳到最后一页
    public void lastPage() {
        if (this.totalCount % rowsPerPage == 0) {
            currentPage = this.totalCount / rowsPerPage;
        } else {
            currentPage = this.totalCount / rowsPerPage + 1;
        }
    }

    // 跳到指定的某一页
    public void gotoPage(int pageNumber) {
        if (pageNumber <= 1) {
            currentPage = 1;
        } else if (getTotalCount() < this.getRowsPerPage()) {
            currentPage = 1;
        } else if (pageNumber * rowsPerPage >= this.totalCount) {
            lastPage();
        } else {
            currentPage = pageNumber;
        }
    }

    // 设置总行数
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    // 得到总行数
    public int getTotalCount() {
        return totalCount;
    }

    // 设置每页行数
    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    // 得到每页行数
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    // 得到总页数
    public int getPages() {
        if (this.totalCount % rowsPerPage == 0)
            return this.totalCount / rowsPerPage;
        else
            return this.totalCount / rowsPerPage + 1;
    }

    // 得到当前页数
    public int getCurrentPage() {
        return currentPage;
    }

    // 设置当前页数
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageListSize() {
        return pageListSize;
    }

    // 设置页码列表大小
    public void setPageListSize(int pageListSize) {
        this.pageListSize = pageListSize;
    }

    // 得到页面列表
    public List<Integer> getPageNumList() {
        this.pageNumList.removeAll(this.pageNumList);// 设置之前先清空
        int totalPage = getPages();
        if (totalPage > this.pageListSize) {
            int halfSize = this.pageListSize / 2;
            int first = 1;
            int end = 1;
            if (this.currentPage - halfSize < 1) { // 当前页靠近最小数1
                first = 1;
                end = this.pageListSize;
            } else if (totalPage - this.currentPage < halfSize) { // 当前页靠近最大数
                first = totalPage - this.pageListSize + 1;
                end = totalPage;
            } else {
                first = this.currentPage - halfSize;
                end = this.currentPage + halfSize;
            }
            for (int i = first; i <= end; i++) {
                this.pageNumList.add(i);
            }
        } else {
            for (int i = 0; i < totalPage; i++) {
                this.pageNumList.add(i + 1);
            }
        }

        return pageNumList;
    }

}
