package com.example.test.Service;

import com.example.test.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle>newsArticles=new ArrayList<>();



    public ArrayList<NewsArticle> getNewsArticles(){
        return newsArticles;
    }

    public void addNews(NewsArticle newsArticle){
      newsArticles.add(newsArticle);
    }

    public boolean updateNews(int id,NewsArticle newsArticle){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId()==id){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNews(int id){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId()==id){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean change(int id){
        for(int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getId()==id){
                newsArticles.get(i).setIsPublished(true);
                return true ;
            }
        }
        return true;

    }

    public ArrayList<NewsArticle> getpub(){
        ArrayList<NewsArticle>newsArticles1=new ArrayList<>();
       for(int i=0;i<newsArticles.size();i++){
           if(newsArticles.get(i).getIsPublished().equals(true)){
               newsArticles1.add(newsArticles.get(i));
           }

        }
        return newsArticles1;

    }
    public ArrayList<NewsArticle> getCategory(String catogray){
        ArrayList<NewsArticle>newsArticles1=new ArrayList<>();
        for (int i=0;i<newsArticles.size();i++){
            if(newsArticles.get(i).getCategory().equalsIgnoreCase(catogray)){
                newsArticles1.add(newsArticles.get(i));
            }
        }
        return newsArticles1;
    }


}
