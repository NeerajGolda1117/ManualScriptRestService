package com.manuscript.configuration;

import com.manuscript.configuration.controllers.ArticleController;
import com.manuscript.configuration.entities.Articles;
import com.manuscript.configuration.repositories.ArticleRepository;
import com.manuscript.configuration.services.ArticleServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManuscriptSpringRestServiceApplicationTests {



	@Mock
	private ArticleServiceImplementation artser;

	@InjectMocks
	private ArticleController artcon;

	@Test
	void testCreate() {

		Articles article = new Articles();
		article.setArticleId(1234);
		article.setAuthorEmailAddress("sachin.dhodi@northgateps.com");
		article.setAuthorName("Sachin dhodi");
		article.setIsActive(true);
		article.setIsPublished(true);
		article.setTitle("Spring Boot");
		article.setShortTitle("Camel");
		article.setPages(15);


		when(artser.insertOrUpdateArticleDetails(article)).thenReturn(true);
		boolean res = artcon.insertArticleDetails(article);

		verify(artser).insertOrUpdateArticleDetails(article);

		assertTrue(res);

	}


	@Test
	public void testGetDetails()
	{
		Articles article = new Articles();
		article.setArticleId(2345);
		article.setAuthorEmailAddress("parth.patel@northgateps.com");
		article.setAuthorName("Sachin dhodi");
		article.setIsActive(true);
		article.setIsPublished(true);
		article.setTitle("Heaven in springboot");
		article.setShortTitle("Apache Camel");
		article.setPages(15);
		when(artser.findId(article.getArticleId())).thenReturn(article);

		Articles article1 = artcon.getArticleDetails(article.getArticleId());
		verify(artser).findId(article.getArticleId());
		assertEquals(article,article1);

	}

	@Test
	public void testDeleteDetails()
	{
		int articleId = 2345;

       when(artser.deleteArticleDetails(articleId)).thenReturn(true);
		int articleId1 = artcon.deleteArticleDetails(articleId);
		verify(artser).deleteArticleDetails(articleId);
		assertEquals(articleId,articleId1);

	}


}
