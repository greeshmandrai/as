
package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="TODO")
public class Todo{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	 @Column(name="todoName")
         String todoName; 
	 
	 @Column(name="Status")
         boolean Status;
	    
    public String getTodoName() {
        return this.todoName;
    }
 
    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public int getId() {
        return this.id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public boolean isStatus() {
        return this.Status;
    }

   
    public void setStatus(boolean status) {
        this.Status = status;
    }
	 
    public Todo() {
             super();
     }	 
	 
}