package com.manuscript.configuration.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.manuscript.configuration.entities.Articles;
import com.manuscript.configuration.exceptions.ManuscriptException;
import com.manuscript.configuration.services.ArticleService;


@RestController
public class ArticleController {

	Logger log = LoggerFactory.getLogger(ArticleController.class);
	
	   private ArticleService articleser;
	   

	   
	   @Autowired
	    public ArticleController(ArticleService tempser) {
		articleser = tempser;
	}
	  
	  
		
		  @PostMapping("/article/details/{articleId}") 
		  public Articles getArticleDetails(@PathVariable int articleId) { 
	      
	      
	      log.info("Started fetching single data");

	      	Articles articles = articleser.findId(articleId);
		  
		  return articles;
		  
		  }
		  
		  @PostMapping("/api1")
		  public void api1()
		  {
			  log.info("API is not available");
			  
		  }
		  
		  @PostMapping("article/savedetails")
		  public void insertArticleDetails(@RequestBody Articles articledetails)
		  {
			  log.info("Details are Updating");
			  
			  articleser.insertOrUpdateArticleDetails(articledetails);
			  
		  }
		  
		  @PostMapping("article/delete/{articleId}")
		  public void deleteArticleDetails(@PathVariable int articleId)
		  {
			  log.info(articleId +"article is getting delete");
			   articleser.deleteArticleDetails(articleId);
		  }
}
