package com.bbcalife.bbcalife.exceptions.articles;


import com.bbcalife.bbcalife.exceptions.common.NoSuchElementException;

/**
 * Exception indicating that the user is not found.
 * Sets the appropriate message using MessageSource (the messages are in src/main/resources/messages).
 */
public class ArticleCategoryNotFoundException extends NoSuchElementException {
    public ArticleCategoryNotFoundException() {
        super("Категорията не е намерена!");
    }
}