package x01wp01.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		new Main().executar();
	}

	private void executar() {
		/*Robot robot = new Robot(new User("1613056", "k19982011"));
		robot.executeTask();*/
		  EntityManagerFactory factory = Persistence.
		          createEntityManagerFactory("x01wp01");

		    factory.close();
	}
}
