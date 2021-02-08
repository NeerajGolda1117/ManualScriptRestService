package com.manuscript.configuration.services;





import org.springframework.boot.context.properties.ConfigurationProperties;

import com.manuscript.configuration.entities.Articles;




@ConfigurationProperties("articleser")
public interface ArticleService {

	public Articles findId(int articleId);
	
	public void insertOrUpdateArticleDetails(Articles article);
	
	public void deleteArticleDetails(int articleId);
	
	
}
