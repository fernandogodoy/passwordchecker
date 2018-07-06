package br.com.fsg.passwordchecker;

import java.util.List;

import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;

import br.com.fsg.passwordchecker.additions.AdditionChecker;

/**
 * 
 * @author Fernando-Godoy
 *
 */
@Component
public class Factory {

	public List<String> additionFactory() {
		var bdr = new SimpleBeanDefinitionRegistry();
		var s = new ClassPathBeanDefinitionScanner(bdr);
		var tf = new AssignableTypeFilter(AdditionChecker.class);
		s.addIncludeFilter(tf);
		s.scan("br.com.fsg.passwordchecker.additions");
		var beans = bdr.getBeanDefinitionNames();
		return List.of(beans);
	}

}
