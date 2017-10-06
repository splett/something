package x01wp01.entity.task;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import x01wp01.entity.classTask.Class;
import x01wp01.entity.user.User;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private User user;
	
	@ManyToOne
    @JoinColumn(referencedColumnName = "id")
	private Class classTask;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Class getClassTask() {
		return classTask;
	}

	public void setClassTask(Class classTask) {
		this.classTask = classTask;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
