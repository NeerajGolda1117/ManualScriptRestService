package com.manuscript.configuration.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manuscript.configuration.entities.Articles;
import com.manuscript.configuration.exceptions.ManuscriptException;
import com.manuscript.configuration.repositories.ArticleRepository;




@Service
public class ArticleServiceImplementation implements ArticleService {

	
	Logger log = LoggerFactory.getLogger(ArticleServiceImplementation.class);
	
	private ArticleRepository articleres;
	
	@Autowired
	 public ArticleServiceImplementation(ArticleRepository tempres) {
		articleres = tempres;
	}
	

	
	@Override
	public Articles findId(int articleId)   {
		
		Optional<Articles> res = articleres.findById(articleId);
		
		
		

		
		
		try {
			if (res.isPresent()) {
				
				log.info("Article Details : "+ res.get().toString());
				return res.get();
			}
			
			
		} catch (Exception e) {
			
			
			log.error( "BOOOMMM! Did not find employee id " + articleId ,new ManuscriptException("Did not find employee id " + articleId).toString());
		
		
		}
		return null;
		


		

	}



	@Override
	public boolean insertOrUpdateArticleDetails(Articles article) {
		
		Articles res;
		
		try {
			 res = articleres.save(article);
			 log.info(res.toString());
			if (res.equals(article)) {
				log.info("Details got inserted" + res.toString());
				return true;
			}
			
			
		} catch (Exception e) {
			
			
			log.error( "BOOOMMM! Did not inset article " + article.toString() ,new ManuscriptException("Did not inset article " + article.toString()).toString());
		
		return false;
		}
		return false;
	}



	@Override
	public boolean deleteArticleDetails(int articleId) {
		
		 
		
		 
			try {
				articleres.deleteById(articleId);
				
				log.info("Article details got deleted with articleid" + articleId);
				return true;
				
			} catch (Exception e) {
				
				
				log.error( "BOOOMMM! Did not delete the Article with articleid  "+articleId ,new ManuscriptException("Did not delete the Article with articleid " + articleId).toString());
			
			return false;
			}

	}
	


}
