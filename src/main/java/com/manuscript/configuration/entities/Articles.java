package com.manuscript.configuration.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Articles {
	
	@Id
	@Column(name="article_id")
	@ApiModelProperty(notes = "Unique Article ID")
	private int articleId;
	
	@Column(name="title")
	@ApiModelProperty(notes = " Article Title")
	private String title;

	@ApiModelProperty(notes = "Article Short Title")
	@Column(name="short_title")
	private String shortTitle;

	@ApiModelProperty(notes = "Author Name who wrote this article")
	@Column(name="author_name")
	private String authorName;

	@ApiModelProperty(notes = "Email address of Author ")
	@Column(name="author_email_adress")
	private String authorEmailAddress;
	
	@Column(name="pages")
	@ApiModelProperty(notes = "No of Pages in Manuscript")
	private int pages;
   
	@Column(name="is_active")
	@ApiModelProperty(notes = "shows whether author is active or not")
	private boolean isActive;
	
	@Column(name="is_published")
	@ApiModelProperty(notes = "shows whether manuscript is published or not")
	private boolean isPublished;
	
	
	
	public Articles()
	{
		
	}

	public Articles(int articleId, String title, String shortTitle, String authorName, String authorEmailAddress,
			int pages, boolean isActive, boolean isPublished) {
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

	public void setAuthorEmailAdress(String authorEmailAddress) {
		this.authorEmailAddress = authorEmailAddress;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(boolean isPublished) {
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
