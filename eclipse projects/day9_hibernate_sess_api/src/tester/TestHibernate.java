package tester;
import static utils.HibernateUtils.*;

public class TestHibernate {

	public static void main(String[] args) {
		try
		{
			getSf();
			System.out.println("sf created.....");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			getSf().close();
			System.out.println("SF cleaned up...");
		}
	}

}
