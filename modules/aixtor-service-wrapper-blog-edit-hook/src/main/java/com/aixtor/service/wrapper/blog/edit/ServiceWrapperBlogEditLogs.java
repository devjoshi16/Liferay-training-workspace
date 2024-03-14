package com.aixtor.service.wrapper.blog.edit;



import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceWrapper;
//import com.liferay.blogs.service.BlogsEntryLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector;
import org.osgi.service.component.annotations.Component;

/**
 * @author dev.joshi
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class ServiceWrapperBlogEditLogs extends BlogsEntryLocalServiceWrapper {

	private final Log log= LogFactoryUtil.getLog(ServiceWrapperBlogEditLogs.class);
	public ServiceWrapperBlogEditLogs() {
		super(null);
	}


	@Override
	public BlogsEntry addEntry(long userId, String title, String subtitle,
							   String description, String content, int displayDateMonth,
							   int displayDateDay, int displayDateYear, int displayDateHour,
							   int displayDateMinute, boolean allowPingbacks,
							   boolean allowTrackbacks, String[] trackbacks,
							   String coverImageCaption, ImageSelector coverImageImageSelector,
							   ImageSelector smallImageImageSelector, ServiceContext serviceContext)
			throws PortalException {

//		title = title + " : Surekhatech";

		log.info("New blog addedd With name:"+title);
		return super.addEntry(userId, title, subtitle, description, content,
				displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
				displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
				coverImageCaption, coverImageImageSelector, smallImageImageSelector,
				serviceContext);

	}

	@Override
	public BlogsEntry addEntry(
			String externalReferenceCode, long userId, String title,
			String subtitle, String urlTitle, String description,
			String content, java.util.Date displayDate, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("New blog addedd With name:"+title);

		return super.addEntry(
				externalReferenceCode, userId, title, subtitle, urlTitle,
				description, content, displayDate, allowPingbacks, allowTrackbacks,
				trackbacks, coverImageCaption, coverImageImageSelector,
				smallImageImageSelector, serviceContext);
	}

	@Override
	public BlogsEntry addEntry(
			String externalReferenceCode, long userId, String title,
			String subtitle, String urlTitle, String description,
			String content, int displayDateMonth, int displayDateDay,
			int displayDateYear, int displayDateHour, int displayDateMinute,
			boolean allowPingbacks, boolean allowTrackbacks,
			String[] trackbacks, String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("New blog added With name:"+title);

		return super.addEntry(
				externalReferenceCode, userId, title, subtitle, urlTitle,
				description, content, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute, allowPingbacks,
				allowTrackbacks, trackbacks, coverImageCaption,
				coverImageImageSelector, smallImageImageSelector, serviceContext);
	}

	@Override
	public BlogsEntry updateEntry(
			long userId, long entryId, String title, String content,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("blog updated With name:"+title);

		return super.updateEntry(
				userId, entryId, title, content, serviceContext);
	}

	@Override
	public BlogsEntry updateEntry(
			long userId, long entryId, String title, String subtitle,
			String description, String content, java.util.Date displayDate,
			boolean allowPingbacks, boolean allowTrackbacks,
			String[] trackbacks, String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("blog updated With name:"+title);

		return super.updateEntry(
				userId, entryId, title, subtitle, description, content, displayDate,
				allowPingbacks, allowTrackbacks, trackbacks, coverImageCaption,
				coverImageImageSelector, smallImageImageSelector, serviceContext);
	}

	@Override
	public BlogsEntry updateEntry(
			long userId, long entryId, String title, String subtitle,
			String description, String content, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("blog updated With name:"+title);

		return super.updateEntry(
				userId, entryId, title, subtitle, description, content,
				displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
				displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
				coverImageCaption, coverImageImageSelector, smallImageImageSelector,
				serviceContext);
	}

	@Override
	public BlogsEntry updateEntry(
			long userId, long entryId, String title, String subtitle,
			String urlTitle, String description, String content,
			java.util.Date displayDate, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("blog updated With name:"+title);

		return super.updateEntry(
				userId, entryId, title, subtitle, urlTitle, description, content,
				displayDate, allowPingbacks, allowTrackbacks, trackbacks,
				coverImageCaption, coverImageImageSelector, smallImageImageSelector,
				serviceContext);
	}

	@Override
	public BlogsEntry updateEntry(
			long userId, long entryId, String title, String subtitle,
			String urlTitle, String description, String content,
			int displayDateMonth, int displayDateDay, int displayDateYear,
			int displayDateHour, int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
					smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {
		log.info("blog updated With name:"+title);

		return super.updateEntry(
				userId, entryId, title, subtitle, urlTitle, description, content,
				displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
				displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
				coverImageCaption, coverImageImageSelector, smallImageImageSelector,
				serviceContext);
	}


}