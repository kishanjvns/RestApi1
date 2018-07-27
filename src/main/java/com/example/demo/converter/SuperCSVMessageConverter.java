package com.example.demo.converter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

@Component
public class SuperCSVMessageConverter extends AbstractHttpMessageConverter<Object> {

	private static final String TEXT_CSV = "text/csv";

	public SuperCSVMessageConverter() {
		super(MediaType.valueOf(TEXT_CSV));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println(clazz.getName());
		try {
			
			
			Class targetClass = Class.forName(clazz.getName());
			
			Class superClass=targetClass.getSuperclass();
			while( superClass !=null){				
				Method[] methods = superClass.getDeclaredMethods();
				for (Method method : methods) {
					if (isSetter(method))
						System.out.println("Public method found: " + method.toString());
				}
				 superClass=targetClass.getSuperclass();				
			}
			
			/*Object targetObject = targetClass.newInstance();
			ArrayList<Method> list = new ArrayList<Method>();
			Method[] methods = targetClass.getDeclaredMethods();
			
			Class superClass= targetClass.getSuperclass();
			for (Method method : methods)
				if (isSetter(method))
					list.add(method);
			System.out.println(list);
			Method[] methods2 = targetClass.getDeclaredMethods();
			for (Method method : methods2) {
				if (isSetter(method))
					System.out.println("Public method found: " + method.toString());
			}*/

		} catch (ClassNotFoundException e) {
			// Model not mapped
			e.printStackTrace();
		}
		System.out.println(clazz.getClass());
		return null;
	}

	@Override
	protected void writeInternal(Object t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub

	}

	public static boolean isSetter(Method method) {
		return Modifier.isPublic(method.getModifiers()) && method.getReturnType().equals(void.class)
				&& method.getParameterTypes().length == 1 && method.getName().matches("^set[A-Z].*");
	}
}