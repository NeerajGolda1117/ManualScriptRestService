package com.manuscript.configuration.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Articles {
	
	@Id
	@Column(name="article_id")
	private int articleId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="short_title")
	private String shortTitle;

	@Column(name="author_name")
	private String authorName;
	
	@Column(name="author_email_adress")
	private String authorEmailAddress;
	
	@Column(name="pages")
	private int pages;
   
	@Column(name="is_active")
	private int isActive;
	
	@Column(name="is_published")
	private int isPublished;
	
	
	
	public Articles()
	{
		
	}

	public Articles(int articleId, String title, String shortTitle, String authorName, String authorEmailAddress,
			int pages, int isActive, int isPublished) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.shortTitle = shortTitle;
		this.authorName = authorName;
		this.authorEmailAddress = authorEmailAddress;
		this.pages = pages;
		this.isActive = isActive;
		this.isPublished = isPublished;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmailAddress() {
		return authorEmailAddress;
	}

	public void setAuthorEmailAdress(String authorEmailAdress) {
		this.authorEmailAddress = authorEmailAdress;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(int isPublished) {
		this.isPublished = isPublished;
	}

	public void setAuthorEmailAddress(String authorEmailAddress) {
		this.authorEmailAddress = authorEmailAddress;
	}

	@Override
	public String toString() {
		return "Articles [articleId=" + articleId + ", title=" + title + ", shortTitle=" + shortTitle + ", authorName="
				+ authorName + ", authorEmailAddress=" + authorEmailAddress + ", pages=" + pages + ", isActive="
				+ isActive + ", isPublished=" + isPublished + "]";
	} 
	
	


	
	
	
	
}
