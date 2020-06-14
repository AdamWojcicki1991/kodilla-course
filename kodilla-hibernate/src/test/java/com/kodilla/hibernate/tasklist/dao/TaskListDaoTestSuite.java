package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "TaskList: Learn Hibernate";

    @Test
    public void testFindByListName() {
        //GIVEN
        TaskList taskList = new TaskList("ToDoList", DESCRIPTION);
        taskListDao.save(taskList);
        String taskListName = taskList.getListName();
        //WHEN
        List<TaskList> readTaskLists = taskListDao.findByListName(taskListName);
        //THEN
        assertEquals(1, readTaskLists.size());
        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
