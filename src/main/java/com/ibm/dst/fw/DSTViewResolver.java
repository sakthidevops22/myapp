package com.ibm.dst.fw;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * Resolves CNP view .. So far no setter 
 * @author SUDDUTT1
 *
 */
public class DSTViewResolver implements ViewResolver {

	private static Map<String, View> viewMap = new HashMap<String, View>(4);

	public DSTViewResolver() {
		super();
		if (viewMap.isEmpty()) {
			viewMap.put(DSTFmwkConstants.AJAX_VIEW, new DSTAjaxView());
			viewMap.put(DSTFmwkConstants.JSP_VIEW, new DSTBaseView());
		}
	}

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		// TODO Auto-generated method stub
		View resolvedViewObj = viewMap.get(viewName);
		return (resolvedViewObj == null ? viewMap
				.get(DSTFmwkConstants.JSP_VIEW) : resolvedViewObj);
	}
}
