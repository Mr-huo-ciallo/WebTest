package com.my.dao;

import com.my.domain.Book;

/**
 * Created by guodi on 2024/6/1 上午11:27
 */
public interface BookMapper {
    public Book findBookById(Integer id);
}
