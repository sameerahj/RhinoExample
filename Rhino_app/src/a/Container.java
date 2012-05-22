package a;

import org.mozilla.javascript.ScriptableObject;

@SuppressWarnings("serial")
public class Container extends ScriptableObject{

	private String name;
	private int size;
	private int usage;
	
	
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return "Container";
	}

	public void jsConstructor(String name,int size){
		//this is the constructor which is mapped when javascript object is created
		
		this.name =name;
		this.size = size;
		this.usage =0;
		
		
	}
	
	
	
	public int jsGet_Usage(){
	// age is a dynamic property	
		return ++usage;
				
	}
	
	public void jsFunction_setSize(int size){
		//this is a function
		this.size = size;
		
		
	}

	public String jsFunction_setName(String name) {
		this.name = name;
		return name;
	}

	public String jsFunction_getName() {
		return name;
	}

	public int jsFunction_getSize() {
		return size;
	}
	
}
