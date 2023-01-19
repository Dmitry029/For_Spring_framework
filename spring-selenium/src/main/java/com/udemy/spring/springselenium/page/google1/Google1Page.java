package com.udemy.spring.springselenium.page.google1;

import com.udemy.spring.springselenium.kelvin.annotation.Page;
import com.udemy.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
@Page
public class Google1Page extends Base {
    @Lazy
    @Autowired
    private Search1Component searchComponent;

    @Autowired
    private Search1Result searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
    }

    public Search1Component getSearchComponent() {
        return searchComponent;
    }

    public Search1Result getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.quit();
    }
}
