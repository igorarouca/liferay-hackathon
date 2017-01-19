package com.liferay.portal.hackathon.portlet.action;

import com.liferay.portal.hackathon.raspberrypi.RaspberryPiService;
import com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
	immediate=true,
	property={
		"javax.portlet.name=com_liferay_portal_hackathon_portlet_LightportletPortlet",
		"mvc.command.name=/hackathon/turn_on_red"
	},
	service=MVCActionCommand.class
)
public class TurnOnRedAction extends BaseMVCActionCommand {


	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		_raspberryPiService.turnOn(RaspberryPiServiceConstants.Color.RED);
	}

	@Reference
	private void setRaspberryPieService(RaspberryPiService raspberryPiService) {
		_raspberryPiService = raspberryPiService;
	}

	private RaspberryPiService _raspberryPiService;
}

