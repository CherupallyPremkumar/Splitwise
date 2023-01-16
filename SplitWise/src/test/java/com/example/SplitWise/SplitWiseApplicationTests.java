package com.example.SplitWise;

import com.example.SplitWise.Strategy.ExpenseSplitType;
import com.example.SplitWise.controller.GroupController;
import com.example.SplitWise.controller.UserController;
import com.example.SplitWise.model.Expense;
import com.example.SplitWise.model.Group;
import com.example.SplitWise.model.Split;
import com.example.SplitWise.model.User;
import com.example.SplitWise.service.GroupManager;
import com.example.SplitWise.service.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class SplitWiseApplicationTests {
	@Autowired
	UserManager userController;



	@Autowired
	GroupManager groupManager;
	GroupController groupController;
	User user1=new User("U1001","premkumar");
	User user2=new User("U1002","vaishnavi");
	User user3=new User("U1003","shivani");
	User user4=new User("U1004","dhanu");

	@Test
	void Test() {
		userController.craeteUser(user1.getUserId(),user1.getUserName());
		userController.craeteUser(user2.getUserId(),user2.getUserName());
		userController.craeteUser(user3.getUserId(),user3.getUserName());
		userController.craeteUser(user4.getUserId(),user4.getUserName());
		assertEquals(user1.getUserId(),userController.getUser(user1.getUserId()).getUserId());
	}
	@Test
	void TestTwo()
	{

		groupManager.createGroup("G1001","GOA",user2);
		Group group=groupManager.getGroup("G1001");
		groupManager.addUserToGroup("G1001",user1);
        groupManager.addUserToGroup("G1001",user4);
		groupManager.SplitListUserPercentage("G1001",user2,50);
		groupManager.SplitListUserPercentage("G1001",user3,50);

		groupManager.createExpense("G1001","Exp1001","Dinner",1500, ExpenseSplitType.EQUAL,user2);
		System.out.println(group.toString());
		assertEquals("LONGDRIVE",group.getGroupName());

	}



}
