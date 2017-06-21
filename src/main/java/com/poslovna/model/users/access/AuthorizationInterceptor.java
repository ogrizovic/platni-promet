package com.poslovna.model.users.access;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;

import com.poslovna.controller.Interceptable;
import com.poslovna.controller.auth.UserCtrl;

@Interceptor
public class AuthorizationInterceptor {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	

	public AuthorizationInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	@AroundInvoke
	public Object invoke(InvocationContext ctx) throws Exception {
		Object[] parameters = ctx.getParameters();
		HttpServletRequest request = (HttpServletRequest) parameters[0]; // nulti parametar metode koja se interceptuje mora biti HttpServletRequest
		User user = ((User) request.getSession().getAttribute("user"));

		ArrayList<Role> userRoles = (ArrayList<Role>) user.getRoles();
		
		if(ctx.getTarget() instanceof Interceptable){
			Interceptable targetClass = (Interceptable) ctx.getTarget();
			String methodName = ctx.getMethod().getName();
			HashMap<String, ArrayList<Permission>> methodPermissions = targetClass.getMethodPermissions();
			
			if (methodPermissions.containsKey(methodName)){ // da li ova metoda uopste ima permisije
				ArrayList<Permission> permsOfMethod = methodPermissions.get(methodName);
				Set<Permission> _permsOfMethod = new HashSet<Permission>(permsOfMethod);
				
				for(Role role : userRoles){
					Set<Permission> _permsOfRole = new HashSet<Permission>(role.getPermissions());
						
					if(_permsOfMethod.equals(_permsOfRole)){
						ctx.proceed();
					}
				}
			}
		}
		
		return null;
	}
	
/*	private String[] extractCredentials(String authHeader) {
		String authToken = authHeader.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
		String decodedString;
		try {
			decodedString = new String(Base64.decodeBase64(authToken), "UTF-8");
			String[] tokens = decodedString.split(":");
			
			return tokens;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}
