//package aixtor.dynamic.blogentry.hook.portlet;
//
//import aixtor.dynamic.blogentry.hook.constants.AixtorDynamicBlogentryHookPortletKeys;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//
//import javax.portlet.Portlet;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author dev.joshi
// */
//@Component(
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.header-portlet-css=/css/main.css",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=AixtorDynamicBlogentryHook",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/view.jsp",
//		"javax.portlet.name=" + AixtorDynamicBlogentryHookPortletKeys.AIXTORDYNAMICBLOGENTRYHOOK,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class AixtorDynamicBlogentryHookPortlet extends MVCPortlet {
//}