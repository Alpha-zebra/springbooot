package com.how2java.springboot.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class Page4Navigator<T> {

    Page<T> page4jpa;
    int navigatePages;

    int totalPages;
    int number;
    long totalElements;
    int size;
    int numberofElements;
    List<T> content;
    boolean isHasContent;
    boolean first;
    boolean last;
    boolean isHasNext;
    boolean isHasPrevious;
    int[] navigatepageNums;

    public Page4Navigator() {
    }

    public Page4Navigator(Page<T> page4jpa,int navigatePages){
        this.page4jpa=page4jpa;
        this.navigatePages=navigatePages;

        totalPages =page4jpa.getTotalPages();
        number=page4jpa.getNumber();
        totalElements=page4jpa.getTotalElements();
        size=page4jpa.getSize();
        numberofElements=page4jpa.getNumberOfElements();
        content=page4jpa.getContent();
        isHasContent=page4jpa.hasContent();
        first=page4jpa.isFirst();
        last=page4jpa.isLast();
        isHasNext=page4jpa.hasNext();
        isHasPrevious=page4jpa.hasPrevious();
        
        calcNavigatepageNums();
    }

    private void calcNavigatepageNums() {
        int navigatepageNums[];
        int totalPages=getTotalPages();
        int num=getNumber();

        if (totalPages<=navigatePages){
            navigatepageNums=new int[totalPages];
            for (int i=0;i<totalPages;i++){
                navigatepageNums[i]=i+1;
            }
        }else {
            navigatepageNums=new int[navigatePages];
            int startNum=num-navigatePages/2;
            int endNum=num+navigatePages/2;

            if (startNum<1){
                startNum=1;
                for (int i=0;i<navigatePages;i++){
                    navigatepageNums[i]=startNum++;
                }
            }else if (endNum>totalPages){
                endNum=totalPages;
                for (int i=navigatePages-1;i>=0;i--){
                    navigatepageNums[i]=endNum--;
                }
            }else {
                for (int i=0;i<navigatePages;i++){
                    navigatepageNums[i]=startNum++;
                }
            }

        }
        this.navigatepageNums=navigatepageNums;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberofElements() {
        return numberofElements;
    }

    public void setNumberofElements(int numberofElements) {
        this.numberofElements = numberofElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isHasContent() {
        return isHasContent;
    }

    public void setHasContent(boolean hasContent) {
        isHasContent = hasContent;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean hasNext) {
        isHasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return isHasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        isHasPrevious = hasPrevious;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }
}
