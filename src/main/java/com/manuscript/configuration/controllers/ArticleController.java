package com.manuscript.configuration.controllers;


import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.manuscript.configuration.entities.Articles;
import com.manuscript.configuration.exceptions.ManuscriptException;
import com.manuscript.configuration.services.ArticleService;


@RestController
@RequestMapping("/article")
public class ArticleController {

	Logger log = LoggerFactory.getLogger(ArticleController.class);
	
	   private ArticleService articleser;
	   

	   
	   @Autowired
	    public ArticleController(ArticleService tempser) {
		articleser = tempser;
	}
	  
	  
		
		  @PostMapping("details/{articleId}")
		  @ApiOperation(value = "Fetch an Article details",
				  notes= "Provide an articleId to fetch article details",
				  response = Articles.class)
		  public Articles getArticleDetails(@PathVariable int articleId) { 
	      
	      
	      log.info("Started fetching single data");

	      	Articles articles = articleser.findId(articleId);
		  
		  return articles;
		  
		  }
		  
		  @PostMapping("api1")
		  @ApiOperation(value = "Optional API ",
				  notes= "Doesn't have to provide anything",
				  response = String.class)
		  public void api1()
		  {
			  log.info("API is not available");
			  
		  }
		  
		  @PostMapping("savedetails")
		  @ApiOperation(value = "Save Article details in database",
				  notes= "Provide an article details to store article details",
				response = Articles.class)
		  public void insertArticleDetails(@RequestBody Articles articledetails)
		  {
			  log.info("Details are Updating");
			  
			  articleser.insertOrUpdateArticleDetails(articledetails);
			  
		  }

		  
		  @PostMapping("delete/{articleId}")
		  @ApiOperation(value = "delete an Article",
				  notes= "Provide an articleId to delete article details",
				  response= Articles.class)
		  public void deleteArticleDetails(@PathVariable int articleId)
		  {
			  log.info(articleId +"article is getting delete");
			   articleser.deleteArticleDetails(articleId);
		  }
}
