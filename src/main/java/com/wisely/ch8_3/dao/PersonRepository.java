package com.wisely.ch8_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wisely.ch8_3.domain.Person;
/**
 * 在postman中使用get方式访问		localhost:8080/people	获取所有person
 * 在postman中使用get方式访问		localhost:8080/people/1	获取id为1的person
 * 在postman中使用get方式访问		localhost:8080/people/?page=0&size=2	分页查询获取person第1页每页数量为2
 * 在postman中使用get方式访问		localhost:8080/people/search/nameStartsWith?name=王	查询name打头为“王”的person
 * 在postman中使用get方式访问		localhost:8080/people/?sort=age,desc	按照age属性倒序查询所有person
 * 在postman中使用post方式访问	localhost:8080/people	设置body->raw->json->写入数据为{"name":"haha","address":"杭州","age":"18"}	
 * 													保存新的person到数据库
 * 在postman中使用put方式访问		localhost:8080/people/1	{"name":"haha","address":"杭州","age":"18"}	更新id为1的person
 * 在postman中使用delete方式访问	localhost:8080/people/1	删除id为1的person
 * @author Mask
 *	实际项目中使用jQuery:$.ajax的方式来使用
 *	或AngularJS:$http来使用
 */
@RepositoryRestResource(path = "people")	//定制节点路径
public interface PersonRepository extends JpaRepository<Person, Long>{
	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	Person findByNameStartsWith(@Param("name")String name);
}