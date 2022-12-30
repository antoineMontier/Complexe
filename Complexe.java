public class Complexe {
	//builder :

	  public Complexe(){
	    a = 0;
	    b = 0;
	  }

	  /**
	 * @real  x
	 * @imaginary y
	 */
	public Complexe(double x, double y){
	    a = x;
	    b = y;
	  }

	  public Complexe(double x){
	    a = x;
	    b = 0;
	  }

	  public Complexe(Complexe z){
	    a = z.getRe();
	    b = z.getIm();
	  }


	//parameters :

	  private double a = 0;
	  private double b = 0;

	//access :

	  public double getRe(){
	    return a;
	  }

	  public double getIm(){
	    return b;
	  }

	  public void setRe(double x){
	    a = x;
	  }

	  public void setIm(double x){
	    b = x;
	  }

	  public String toString(){

	    if(a != 0){
	      if(b > 0){
	        return a + " +" + b + "*i";
	      }else if(b < 0){
	        return a + " -" + (-b) + "*i";
	      }else if(b == 0){
	        return a + "";
	      }
	    }else if(a == 0){
	      if(b > 0){
	        return b + "*i";
	      }else if(b < 0){
	        return "-" + (-b) + "*i";
	      }else if(b == 0){
	        return a + "";
	      }
	    }

	  System.out.println("error string with the complexe (" + a + " + " + b + ")");
	  return "";
	  }

	//functions :

	  //comparaisons :

	  public boolean egal(Complexe z){
	    return z.getIm() == b && z.getRe() == a;
	  }
	  
	  public static boolean egal(Complexe a, Complexe b) {
		  return a.getRe() == b.getRe() && b.getIm() == a.getIm();
	  }

	  //additions :

	  public Complexe plus(Complexe x){
	    return new Complexe(a + x.getRe(), b + x.getIm());
	  }

	  public Complexe plus(double x){
	    return new Complexe(a + x, b + x);
	  }

	  public Complexe minus(Complexe x){
	    return new Complexe(a - x.getRe(), b - x.getIm());
	  }

	  public Complexe minus(double x){
	    return new Complexe(a - x, b - x);
	  }

	  //multiplication :

	  public Complexe mult(Complexe x){
	    return new Complexe(a*x.getRe() - b*x.getIm(), a*x.getIm() + b*x.getRe());
	  }

	  public static Complexe mult(Complexe y, Complexe x){
	    return new Complexe(y.getRe()*x.getRe() - y.getIm()*x.getIm(), y.getRe()*x.getIm() + y.getIm()*x.getRe());
	  }

	  public Complexe mult(double x){
	    return new Complexe(a*x, b*x);
	  }

	  public Complexe div(double x){
	    if(x == 0){
	        System.out.println("division by 0 is impossible with complexe : " + this + ")");
	        return new Complexe(this);
	      }
	    return new Complexe(a/x , b/x);
	  }

	  public Complexe div(Complexe x){
	    if(x.getIm() == 0 && x.getRe() == 0){
	        System.out.println("division by 0 is impossible with complexe : " + this + ")");
	        return new Complexe(this);
	      }
	      return new Complexe((a*x.getRe() + b*x.getIm())/(x.getRe()*x.getRe() + x.getIm()*x.getIm()) , (b*x.getRe() - a*x.getIm())/(x.getRe()*x.getRe() + x.getIm()*x.getIm()));
	  }

	   public Complexe puis(int n){
	    if(n == 0){
	      return new Complexe(1);
	    } else if(n == 1){
	      return new Complexe(this);
	    }else if(n > 1){
	      Complexe res1 = new Complexe(this);
	      Complexe res2 = new Complexe(res1);
	      for(int i = 1 ; i < n ; i++){
	        res2 = res2.mult(res1);
	      }
	      return res2;
	    }else{
	      int m = -n;
	      Complexe res1 = new Complexe(this);
	      Complexe res2 = new Complexe(res1);
	      Complexe one = new Complexe(1);
	      for(int i = 1 ; i < m ; i++){
	        res2 = res2.mult(res1);
	      }
	      return one.div(res2);
	    }
	  }

	  //conjugate :

 	  public Complexe conj(){
	      return new Complexe(a, -b);
	  }

	  //module :

	  public double mod(){
	    return Math.sqrt(a*a + b*b);
	  }
 
	  //angle :

	  public double arg(){	//to improve, this is not working perfectly
	    return atan2(b, a);
	}

  
}
