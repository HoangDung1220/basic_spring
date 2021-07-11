package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

	
   /*  @Query(value = "SELECT u FROM product u inner join category on u.id_category=category.id",nativeQuery =true)
     public List<ProductEntity> findAll();
     
     @Query(value="select *from product order by rand() limit 9",nativeQuery=true)
     public List<ProductEntity> getTop9();*/
	
	 @EntityGraph(attributePaths = "category")
	//@Query(value="select *from product order by rand() limit 8", nativeQuery=true)
	public List<ProductEntity> findFirst10ByOrderByName();
}