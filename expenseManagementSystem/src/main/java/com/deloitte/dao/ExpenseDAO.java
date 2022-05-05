package com.deloitte.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.deloitte.entities.Expense;
import com.deloitte.entities.ExpenseCount;
import com.deloitte.util.HibernateHelper;

public class ExpenseDAO {

	// default constructor
	public ExpenseDAO() {

	}

	/**
	 * This method saves the expense made in the database
	 * 
	 * @param Expense
	 * @return int expenseId
	 * @author Group 2
	 */
	public static int saveExpense(Expense e) {
		// Hibernate Session object is created for saving expense into database
		Session s = HibernateHelper.getInstance().openSession();
		int expenseId = 0;
		try {
			Transaction tx = s.beginTransaction();
			// Each expdense is saved against a unique expense ID
			expenseId = (int) s.save(e);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			s.close();
		}
		return expenseId;

	}

	/**
	 * This method fetches the expense from database by the specific user ID
	 * 
	 * @param
	 * @return List of expenses by the user
	 * @author Group 2
	 */
	public static List<Expense> fetchExpenseByUserId(Integer userId) {
		Session s = HibernateHelper.getInstance().openSession();

		// Creating a list to save all expenses made by one user
		List<Expense> eList = null;
		try {

			// Query to get expenses against an user ID
			Query<Expense> query = s.createQuery("from Expense as e where e.user.userId =:uid", Expense.class);

			query.setParameter("uid", userId);

			// Saving the fetched expense list in eList
			eList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return eList;
	}

	/**
	 * This method fetches the last 10 expenses from database by the specific user
	 * ID
	 * 
	 * @param
	 * @return List of last 10 expenses by the user
	 * @author Group 2
	 */
	public static List<Expense> fetchLast10Expense(Integer userId) {
		// Creating a list to save last 10 expenses made by one user
		List<Expense> eList = fetchExpenseByUserId(userId);
		// Checking if list size is < 10
		if (eList.size() < 10)
			// Hence, return the complete existing list
			return eList;
		// If list size is >=10, return last 10 expenses only
		return eList.subList(eList.size() - 10, eList.size());
	}

	/**
	 * This method fetches the ID that has to be further deleted
	 * 
	 * @param
	 * @return Expense
	 * @author Group 2
	 */
	public static Expense fetchExpenseById(Integer expenseId) {
		Session s = HibernateHelper.getInstance().openSession();

		Expense ex = null;
		try {
			// Query to get expense ID which needs to be deleted
			Query<Expense> query = s.createQuery("from Expense as e where e.expenseId =:eid", Expense.class);

			query.setParameter("eid", expenseId);

			ex = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return ex;
	}

	/**
	 * This method deletes a specific expense
	 * 
	 * @param
	 * @author Group 2
	 */
	public static void deleteExpense(Expense e) {
		Session s = HibernateHelper.getInstance().openSession();

		try {
			Transaction tx = s.beginTransaction();
			s.delete(e);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			s.close();
		}

	}

	/**
	 * This method fetches the expense from database by the specific expense type
	 * 
	 * @param
	 * @return List of expenses by the user of specific expense type
	 * @author Group 2
	 */
	public static List<Expense> fetchExpenseByExpenseType(String expenseType, Integer userId) {
		Session s = HibernateHelper.getInstance().openSession();

		List<Expense> eList = null;
		try {

			Query<Expense> query = s.createQuery("from Expense as e where e.user.userId =:uid and e.type= :etype",
					Expense.class);

			query.setParameter("uid", userId);

			query.setParameter("etype", expenseType);

			eList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return eList;
	}

	/**
	 * This method fetches the last 10 expenses of specific Expense Type from
	 * database by the specific user ID
	 * 
	 * @param
	 * @return List of last 10 expenses of specific Expense Type by the user
	 * @author Group 2
	 */
	public static List<Expense> fetchLast10ExpenseType(String expenseType, Integer userId) {
		List<Expense> eList = fetchExpenseByExpenseType(expenseType, userId);
		if (eList.size() < 10)
			return eList;
		return eList.subList(eList.size() - 10, eList.size());
	}

}
