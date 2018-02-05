import fr.m2i.formation.bean.Style;
import fr.m2i.formation.dao.StyleDao;

public class StyleTest {

	public static void main(String[] args) {
		StyleDao sdao = new StyleDao();
		Style s = new Style("Test");
		Style s2 = new Style("Huitres");
		try {
			int id1 = sdao.addStyle(s);
			int id2 = sdao.addStyle(s2);
			Style s3 = sdao.getStyle(id1);
			s3.setLibelle("fdjhfjsdflsd");
			sdao.updateStyle(s3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s.getId());
	}

}
