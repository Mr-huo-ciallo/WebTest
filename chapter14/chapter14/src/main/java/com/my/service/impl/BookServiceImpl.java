package com.my.service.impl;

import com.my.dao.BookMapper;
import com.my.domain.Book;
import com.my.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }
}

