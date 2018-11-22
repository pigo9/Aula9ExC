class Rectangle {

    final int width;
    final int height;
    
    
    //Exercicio A
    
    Rectangle(int width, int height) {
          this.width = width;
          this.height = height;
    }
    
    //A.1
    
    Rectangle(int l){
    	this.width=l;
    	this.height=l;
    }
    
    //A.2
    
    int area(){
    	return width*height;
    }
    
    int perimeter(){
    	return width*2+height*2;
    }
    
    double diagonal(){
    	return (Math.sqrt(Math.pow(width,2) + Math.pow(height,2)));
    }
    
    boolean isSquare(){
    	if(width==height){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
    //A.3.a
    
    Rectangle scale (int s){
    	if(s==1){
    		return this;
    	} else {
    		return new Rectangle(this.width*s,this.height*2);
    	}
    }
    
    //A.3.b
    
    Rectangle sum(int width, int height){
    	return new Rectangle(this.width+width,this.height+height);
    	}

    
    //A.4
    
    boolean isItBiggerThan(Rectangle r){
    	return (this.area() > r.area());
    }
    
    //A.5
    
    static Rectangle max(Rectangle a, Rectangle b) { 
    	if(a.area()>=b.area()){
    		return a;
    	} else {
    		return b;
    	}
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}