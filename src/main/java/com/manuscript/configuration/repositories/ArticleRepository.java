package com.manuscript.configuration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.manuscript.configuration.entities.Articles;


@Repository
public interface ArticleRepository extends JpaRepository<Articles, Integer> {

}
