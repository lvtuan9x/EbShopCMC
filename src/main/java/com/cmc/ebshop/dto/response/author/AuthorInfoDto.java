package com.cmc.ebshop.dto.response.author;

import com.cmc.ebshop.dto.response.book.BookDto;
import com.cmc.ebshop.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorInfoDto {
    private Author author;
    private int numberOfBooks;
    private List<BookDto> top3BestSale;
}
