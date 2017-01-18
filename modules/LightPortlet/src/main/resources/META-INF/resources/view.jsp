<%@ include file="init.jsp" %>


<aui:button-row>
	<liferay-portlet:actionURL name="/hackathon/turn_on_green" var="turnOnGreenURL" />

	<aui:button onClick="<%= turnOnGreenURL %>" name="turn-on-green" value="turn-on-green" >
	</aui:button>

	<liferay-portlet:actionURL name="/hackathon/turn_off_green" var="turnOffGreenURL" />

	<aui:button onClick="<%= turnOffGreenURL %>" name="turn-off-green" value="turn-off-green" >
	</aui:button>

	<liferay-portlet:actionURL name="/hackathon/turn_on_red" var="turnOnRedURL" />

	<aui:button onClick="<%= turnOnRedURL %>" name="turn-on-red" value="turn-on-red" >
	</aui:button>

	<liferay-portlet:actionURL name="/hackathon/turn_off_red" var="turnOffRedURL" />

	<aui:button onClick="<%= turnOffRedURL %>" name="turn-off-red" value="turn-off-red" >
	</aui:button>
</aui:button-row>
