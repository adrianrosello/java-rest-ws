package programmers.tips.rest.cxf;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class Main {

	public static void main(String[] args) {
		 
		   JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		   sf.setResourceClasses(StudentApiImpl.class);
		   sf.setResourceProvider(StudentApiImpl.class, new SingletonResourceProvider(new StudentApiImpl()));
		   sf.setAddress("http://localhost:9000/");
		   sf.setProvider(new JacksonJaxbJsonProvider());
		    
		   BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
		   JAXRSBindingFactory factory = new JAXRSBindingFactory();
		   factory.setBus(sf.getBus());
		   manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
		    
		   sf.create();
		}

}
