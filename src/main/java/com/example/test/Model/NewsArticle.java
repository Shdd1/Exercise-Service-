package com.example.test.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message = "id Cannot be null ")
    private int id;
    @NotNull(message = "title Cannot be null")
    @Size(max = 100,message = "title Maximum length of 100 characters. ")
    private String title;
    @NotNull(message = "author can not be null")
    @Size(min = 4,max = 20,message ="author Must be more than 4 characters. " )
    private String author;
    @NotNull(message = "content  can not be null")
    @Size(min =100,message = "content Must be more than 200 characters. ")
    private String content;
    @NotNull(message = "category can not be null")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "category must be either politics' sports 'technology")
    private String category;
    @NotNull(message = "imageUrl can not be null")
    private String imageUrl;
    @AssertFalse(message = " Must be by default false.")
    private Boolean  isPublished;
    @PastOrPresent(message = "should be a date in the past or the present. ")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date  publishDate;

}
