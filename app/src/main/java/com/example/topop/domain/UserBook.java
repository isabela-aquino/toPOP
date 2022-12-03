package com.example.topop.domain;

import java.util.Objects;

public class UserBook {
    private String userId;
    private String bookId;
    private BookStatusEnum status;

    public UserBook(String userId, String bookId, BookStatusEnum status) {
        this.userId = userId;
        this.bookId = bookId;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public BookStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBook)) return false;
        UserBook userBook = (UserBook) o;
        return getUserId().equals(userBook.getUserId())
                && getBookId().equals(userBook.getBookId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getBookId());
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "userId='" + userId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", status=" + status +
                '}';
    }
}
