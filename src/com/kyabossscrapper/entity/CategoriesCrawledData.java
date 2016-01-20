/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kyabossscrapper.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Nitesh Shah
 */
@Entity
@Table(name = "categories_crawled_data")
public class CategoriesCrawledData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATEGORY_DATA_ID")
    private Integer categoryDataId;
    @Lob
    @Column(name = "CATEGORY_URL")
    private String categoryUrl;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;

    public CategoriesCrawledData() {
    }

    public CategoriesCrawledData(Integer categoryDataId) {
        this.categoryDataId = categoryDataId;
    }

    public CategoriesCrawledData(Integer categoryDataId, String title) {
        this.categoryDataId = categoryDataId;
        this.title = title;
    }

    public Integer getCategoryDataId() {
        return categoryDataId;
    }

    public void setCategoryDataId(Integer categoryDataId) {
        this.categoryDataId = categoryDataId;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
