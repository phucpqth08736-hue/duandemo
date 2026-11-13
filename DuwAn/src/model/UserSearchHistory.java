/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class UserSearchHistory {

    private int searchId;
    private Integer userId;
    private String searchKeyword;
    private String appliedFiltersJson;
    private Date createdAt;

    public UserSearchHistory() {
    }

    public UserSearchHistory(int searchId, Integer userId, String searchKeyword, String appliedFiltersJson, Date createdAt) {
        this.searchId = searchId;
        this.userId = userId;
        this.searchKeyword = searchKeyword;
        this.appliedFiltersJson = appliedFiltersJson;
        this.createdAt = createdAt;
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getAppliedFiltersJson() {
        return appliedFiltersJson;
    }

    public void setAppliedFiltersJson(String appliedFiltersJson) {
        this.appliedFiltersJson = appliedFiltersJson;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
