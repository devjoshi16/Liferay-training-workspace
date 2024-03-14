package com.aixtor.custom.login.portlet;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"key=login.events.post"
	},
	service = LifecycleAction.class
)

public class CustomLoginPostAction implements LifecycleAction{
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		System.out.println("login.event.post=" + lifecycleEvent);
		try {
			lifecycleEvent.getResponse().sendRedirect("http://localhost:8080/success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
