package com.news.RecievingService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.news.models.News;

@Repository
public interface INewsRepository extends CrudRepository<News, Long>  {

}
