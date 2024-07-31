package com.example.test.Controller;

import com.example.test.ApiResponse.ApiResponse;
import com.example.test.Model.NewsArticle;
import com.example.test.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService newsArticle;

    @GetMapping("/get")
    public ResponseEntity getNews() {
        ArrayList<NewsArticle> newsArticles = newsArticle.getNewsArticles();
        return ResponseEntity.status(200).body(newsArticles);
    }

    @PostMapping("/add")
    public ResponseEntity addNews(@Valid @RequestBody NewsArticle newsArticle1, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsArticle.addNews(newsArticle1);
        return ResponseEntity.status(200).body(new ApiResponse("news added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateNews(@PathVariable int id, @Valid @RequestBody NewsArticle newsArticle1, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = newsArticle.updateNews(id, newsArticle1);
        if (isUpdate) {
            return ResponseEntity.status(200).body("News is update");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNews(@PathVariable int id) {
        boolean isDeleted = newsArticle.deleteNews(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("is deleted");
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));

    }

    @PutMapping("/change/{id}")
    public ResponseEntity publish(@PathVariable int id) {
        boolean ispublish = newsArticle.change(id);
        if (ispublish) {
            return ResponseEntity.status(200).body("is publish");
        }
        return ResponseEntity.status(400).body("not found");
    }

    @GetMapping("/getpub")
    public ResponseEntity getPublish() {
        return ResponseEntity.status(200).body(newsArticle.getpub());
    }

    @GetMapping("/get/{category}")
    public ResponseEntity getByCatogry(@PathVariable String category) {
        return ResponseEntity.status(200).body(newsArticle.getCategory(category));

    }


}
