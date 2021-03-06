import java.util.ArrayList;

public class Cublet implements CubeComponent {

	private ArrayList<Face> faces;
	private Matrix location;
	
	public Cublet(Matrix location, ArrayList<Face> faces){
		
		this.location = location;
		this.faces = faces;
		
	}
	
	@Override
	public void applyTransformation(Matrix transformation){
		
		for(Face f : faces)
			f.applyTransformation(transformation);
		
	}
	
	@Override
	public void setColor(int[] colorScheme){
		
		for(Face f : faces)
			f.setColor(colorScheme);
		
	}
	
	public void rotateData(Matrix transformation){
		
		//System.out.println(location);
		this.location = transformation.multiply(location);
		//System.out.println(location);
		
	}
	
	public void rotate(Vector pivot, Vector axis, float radians){
		
		for(Face f : faces)
			f.rotate(pivot, axis, radians);
		
	}
	
	public ArrayList<Face> getFaces() {
		
		return faces;
		
	}
	
	public Matrix getLocation(){
		
		return location;
		
	}
	
	public boolean isOnSector(int[] sector){
		
		return (int) getLocation().m()[sector[0]][0] == sector[1];
		
	}
	
}
