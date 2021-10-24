package com.wxc.common.params;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

@Data
public class CommonPage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public static <T>CommonPage<T> restPage(IPage<T> list){
        CommonPage<T> result = new CommonPage<>();
        result.setList(list.getRecords());
        result.setTotal(list.getTotal());
        result.setPageSize((int) list.getSize());
        result.setTotalPage((int) list.getPages());
        result.setPageNum((int) list.getCurrent());
        return result;
    }
    /**
     * 将SpringData分页后的list转为分页信息
     */
//    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
//        CommonPage<T> result = new CommonPage<T>();
//        result.setTotalPage((int) pageInfo.getTotal());
//        result.setPageNum((int) pageInfo.getPages());
//        result.setPageSize((int) pageInfo.getSize());
//        result.setTotal(pageInfo.getTotal());
//        result.setList(pageInfo.getRecords());
//        return result;
//    }
}
