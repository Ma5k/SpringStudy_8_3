package com.wisely.ch8_3.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wisely.ch8_3.domain.Person;
/**
 * ��postman��ʹ��get��ʽ����		localhost:8080/people	��ȡ����person
 * ��postman��ʹ��get��ʽ����		localhost:8080/people/1	��ȡidΪ1��person
 * ��postman��ʹ��get��ʽ����		localhost:8080/people/?page=0&size=2	��ҳ��ѯ��ȡperson��1ҳÿҳ����Ϊ2
 * ��postman��ʹ��get��ʽ����		localhost:8080/people/search/nameStartsWith?name=��	��ѯname��ͷΪ��������person
 * ��postman��ʹ��get��ʽ����		localhost:8080/people/?sort=age,desc	����age���Ե����ѯ����person
 * ��postman��ʹ��post��ʽ����	localhost:8080/people	����body->raw->json->д������Ϊ{"name":"haha","address":"����","age":"18"}	
 * 													�����µ�person�����ݿ�
 * ��postman��ʹ��put��ʽ����		localhost:8080/people/1	{"name":"haha","address":"����","age":"18"}	����idΪ1��person
 * ��postman��ʹ��delete��ʽ����	localhost:8080/people/1	ɾ��idΪ1��person
 * @author Mask
 *	ʵ����Ŀ��ʹ��jQuery:$.ajax�ķ�ʽ��ʹ��
 *	��AngularJS:$http��ʹ��
 */
@RepositoryRestResource(path = "people")	//���ƽڵ�·��
public interface PersonRepository extends JpaRepository<Person, Long>{
	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	Person findByNameStartsWith(@Param("name")String name);
}