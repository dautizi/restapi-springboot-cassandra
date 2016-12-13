package com.danieleautizi.restapi.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@Repository
public class CassandraTemplateCustom {

    @Autowired
    private CassandraOperations cassandraTemplate;

    public CassandraTemplateCustom() {}

    public <T> T create(T entity) {
        return cassandraTemplate.insert(entity);
    }

    public <T> void createList(List<T> entities) {
        cassandraTemplate.insert(entities);
    }

    public <T> T update(T entity) {
        return (T) cassandraTemplate.update(entity);
    }

    public <T> void updateList(List<T> entities) {
        cassandraTemplate.update(entities);
    }

    public <T> T update(T entity, Class<T> claz) {
        return (T) cassandraTemplate.update(entity);
    }

    public <T> T findById(Object id, Class<T> claz) {
        return cassandraTemplate.selectOneById(claz, id);
    }

    public <T> List<T> find(String statement, Class<T> claz) {
        return cassandraTemplate.select(statement, claz);
    }

    public <T> void deleteById(Object id, Class<T> claz) {
        cassandraTemplate.deleteById(claz, id);
    }

    public void delete(Object entity) {
        cassandraTemplate.delete(entity);
    }

    public <T> void delete(List<T> entities) {
        cassandraTemplate.delete(entities);
    }

    public <T> void deleteAll(Class<T> claz) {
        cassandraTemplate.deleteAll(claz);
    }

    public <T> List<T> findAll(Class<T> claz) {
        String className = claz.getSimpleName().toLowerCase();
        Select select = QueryBuilder.select().from(className);
        return (List<T>) cassandraTemplate.select(select, claz);
    }

    public <T> List<T> findAll(List<Object> ids, Class<T> claz) {
        return cassandraTemplate.selectBySimpleIds(claz, ids);
    }

    public <T> void truncate(Class<T> claz) {
        cassandraTemplate.truncate(claz.getName());
    }

    public <T> long getCount(Class<T> claz) {
        return cassandraTemplate.count(claz);
    }

    public <T> boolean exists(Object id, Class<T> claz) {
        return cassandraTemplate.exists(claz, id);
    }

}
