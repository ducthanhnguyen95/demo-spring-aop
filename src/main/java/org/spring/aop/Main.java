package org.spring.aop;

import org.spring.aop.configuration.ProjectConfig;
import org.spring.aop.model.Comment;
import org.spring.aop.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");
        service.publishComment(comment);
        System.out.println(service.getClass());
    }
}
