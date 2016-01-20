/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.dao;

import com.kyabossscrapper.entity.CategoriesCrawledData;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 *
 * @author Nitesh Shah
 */
public class KyaBossDaoImpl implements KyaBossDao {

    private SimpleJdbcInsert launchDataInsert;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertCategoriesCrawledData(CategoriesCrawledData objCategoriesCrawledData) {

        String SQL = "insert into categories_crawled_data (CATEGORY_URL, TITLE, IMAGE_URL) values (?,?,?)";

        try {

            jdbcTemplateObject.update(SQL, objCategoriesCrawledData.getCategoryUrl(), objCategoriesCrawledData.getTitle(), objCategoriesCrawledData.getImageUrl());

            System.out.println("CategoriesCrawled Table Data inserted");

        } catch (Exception e) {
        }
    }
}
