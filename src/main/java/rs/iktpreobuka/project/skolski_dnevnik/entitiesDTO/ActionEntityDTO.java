package rs.iktpreobuka.project.skolski_dnevnik.entitiesDTO;


public class ActionEntityDTO {
	
	private String test;
	
	private String oral_exam;
	
	private String drawing;
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String getOral_exam() {
		return oral_exam;
	}
	public void setOral_exam(String oral_exam) {
		this.oral_exam = oral_exam;
	}
	public String getDrawing() {
		return drawing;
	}
	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}
	public ActionEntityDTO( String test, String oral_exam, String drawing) {
		super();
		
		this.test = test;
		this.oral_exam = oral_exam;
		this.drawing = drawing;
	}
	public ActionEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
