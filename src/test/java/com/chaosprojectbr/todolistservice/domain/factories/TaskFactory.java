package com.chaosprojectbr.todolistservice.domain.factories;

import com.chaosprojectbr.todolistservice.domain.entities.Task;
import com.chaosprojectbr.todolistservice.domain.entities.enums.STATUS;
import org.bson.types.ObjectId;

public class TaskFactory {

    public static Task sample() {
        return new Task(
                new ObjectId("64b45961891b2061faf012d4"),
                "dummy",
                "dummy",
                "dummy",
                STATUS.TODO
        );
    }
}
