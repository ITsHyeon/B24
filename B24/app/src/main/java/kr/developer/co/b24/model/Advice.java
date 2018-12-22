package kr.developer.co.b24.model;


public class Advice {
    Member member;
    String comment;
    int likeCount;
    int age;
    int category;

    public Advice() {
    }

    public Advice(Member member, String comment, int likeCount, int age, int category) {
        this.member = member;
        this.comment = comment;
        this.likeCount = likeCount;
        this.age = age;
        this.category = category;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
