package com.liferay.portal.hackathon.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
	immediate=true,
	property={
		"javax.portlet.name=com_liferay_portal_hackathon_portlet_LightportletPortlet",
		"mvc.command.name=/hackathon/turn_off_green"
	},
	service=MVCActionCommand.class
)
public class TurnOffGreenAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

	}
}
