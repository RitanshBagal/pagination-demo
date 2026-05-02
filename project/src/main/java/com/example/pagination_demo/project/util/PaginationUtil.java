package com.example.pagination_demo.project.util;

import com.example.pagination_demo.project.response.PaginatedResponse;
import org.springframework.data.domain.Page;


public class PaginationUtil {

    public static <T> PaginatedResponse<T> buildResponse(Page<T> page) {

        PaginatedResponse<T> response = new PaginatedResponse<>();

        response.setData(page.getContent());
        response.setCurrentPage(page.getNumber());
        response.setTotalPages(page.getTotalPages());
        response.setTotalItems(page.getTotalElements());
        response.setPageSize(page.getSize());
        response.setHasNext(page.hasNext());
        response.setHasPrevious(page.hasPrevious());

        return response;
    }
}