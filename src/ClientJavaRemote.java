import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import metier.BanqueRemote;
import metier.entities.Compte;

public class ClientJavaRemote {
	
	public static void main(String[] args) {
		try {
			
			String appName="BanqueEar" ;
			String moduleName="BanqueEjb" ;
			String beanName="BK" ;
			String remoteInterface =BanqueRemote.class.getName() ;
			String name= "ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+remoteInterface ;
			
			
			Context ctx = new InitialContext() ;
			BanqueRemote proxy = (BanqueRemote) ctx.lookup(name) ;
			
			 proxy.addCompte(new Compte()) ;
			proxy.addCompte(new Compte()) ;
			proxy.addCompte(new Compte()) ; 
			
			
      List<Compte> cptes = proxy.listComptes() ;
     
     
    	  
    	  
    	  Compte cp2 = proxy.getCompte(2L) ;
    	 

   proxy.verser(2L, 200);
   proxy.verser(3L, 550);
   proxy.virement(2L, 4L, 100);
   System.out.println(cp2.getSolde());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
