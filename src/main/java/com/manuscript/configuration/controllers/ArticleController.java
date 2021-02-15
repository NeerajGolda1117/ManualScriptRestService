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
		  public boolean insertArticleDetails(@RequestBody Articles articledetails)
		  {
			  log.info("Details are Updating");

			boolean res	=  articleser.insertOrUpdateArticleDetails(articledetails);


			  if (res)
			  {
				  log.info("Article got Updated with articleId " +articledetails.getArticleId());
				  return true;

			  }
			  else {
				  log.info("Article did not got Updated with articleId " + articledetails.getArticleId());
			  }
             return false;
		  }

		  
		  @PostMapping("delete/{articleId}")
		  @ApiOperation(value = "delete an Article",
				  notes= "Provide an articleId to delete article details",
				  response= Articles.class)
		  public int deleteArticleDetails(@PathVariable int articleId)
		  {
			  log.info(articleId +" article is getting delete");

			  boolean res = articleser.deleteArticleDetails(articleId);
			   if (res)
			   {
				   log.info("Article got deleted with articleId " +articleId);

			   }
			   else {
				   log.info("Article did not got deleted with articleId " + articleId);
			   }
			  return articleId;
		  }
}
