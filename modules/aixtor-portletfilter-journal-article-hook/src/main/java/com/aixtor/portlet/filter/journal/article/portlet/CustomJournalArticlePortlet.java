package com.aixtor.portlet.filter.journal.article.portlet;

import com.aixtor.portlet.filter.journal.article.constants.CustomJounalArticlePortletKeys;

import com.liferay.journal.constants.JournalContentPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author dev.joshi
 */
@Component(
		immediate = true,
		property = {
		"javax.portlet.name=" + JournalContentPortletKeys.JOURNAL_CONTENT,
//				"service.ranking:Integer=1"

		},
		service = PortletFilter.class
)
public class CustomJournalArticlePortlet implements RenderFilter {

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
		log.info("-----------------init method called------------");
	}
	@Override
	public void destroy() {
		log.info("------------destroy method called----------------");
	}
	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
			throws IOException, PortletException {
		log.info("----------doFilter method called---------------");

//		RenderResponseWrapper renderResponseWrapper = new BufferedRenderResponseWrapper(response);
//
//
//		String text = renderResponseWrapper.toString();
//
//		if (text != null) {
//			String interestingText = "<input  class=\"field form-control\"";
//
//			int index = text.lastIndexOf(interestingText);
//
//			if (index >= 0) {
//				String newText1 = text.substring(0, index);
//				String newText2 = "\n<p> Dev's filter Added by Blogs Render Filter!</p>\n";
//				String newText3 = text.substring(index);
//
//				String newText = newText1 + newText2 + newText3;
//
//				response.getWriter().write(newText);
//			}
//		}
		PrintWriter printWriter = response.getWriter();

		printWriter.println(
				"<h2 style='color:blue'>Added Journel Artical by Portlet Filter..!</h2><br />"+
						"<h2 style='color:blue'>This is print After content publish..!</h2><br />");
		chain.doFilter(request, response);
//		chain.doFilter(request, renderResponseWrapper);

	}

	private final Log log = LogFactoryUtil.getLog(PortletFilter.class);
}