package com.dashboard.models.JPA;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Validated
@Table(name="task")
@NoArgsConstructor
@RequiredArgsConstructor
public class Task{

    @Id
    @GeneratedValue
    private Integer id;

    @Column @NonNull
    private String taskname;

    @Column @NonNull
    private String description;

    @Column
    @NonNull
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column
    private int percentage = 0;

    @Column @NotNull @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_READY;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> assignedTo;
}

