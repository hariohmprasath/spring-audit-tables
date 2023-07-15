package com.demo.audittables;

import com.demo.audittables.entity.Todo;
import com.demo.audittables.entity.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class AuditTablesApplication {
    @Autowired
    private TodoRepository repository;

    @PostMapping("/todo/{description}")
    public Todo createTodo(@PathVariable String description) {
        return repository.save(new Todo(description));
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/todo/{id}/{description}")
    public Todo updateTodo(@PathVariable int id, @PathVariable String description) {
        Todo todo = repository.findById(id).orElse(null);
        if (todo != null) {
            todo.setDescription(description);
            return repository.save(todo);
        }
        return null;
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo (@PathVariable int id) {
        repository.deleteById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(AuditTablesApplication.class, args);
    }

}
