package com.liferay.portal.hackathon.raspberrypi.internal;

import static com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Command.TURN_OFF;
import static com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Command.TURN_ON;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.hackathon.raspberrypi.RaspberryPiService;
import com.liferay.portal.hackathon.raspberrypi.configuration.RaspberryPiServiceConfiguration;
import com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Color;
import com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Command;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Igor Arouca
 */
@Component (immediate = true, service = RaspberryPiService.class)
public class RaspberryPiServiceImpl implements RaspberryPiService {

	@Override
	public void turnOff(Color color) {
		openSocket().ifPresent(s -> sendCommand(s, TURN_OFF, color.toString()));
	}

	@Override
	public void turnOn(Color color) {
		openSocket().ifPresent(s -> sendCommand(s, TURN_ON, color.toString()));
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		RaspberryPiServiceConfiguration configuration =
			ConfigurableUtil.createConfigurable(
				RaspberryPiServiceConfiguration.class, properties);

		setHostName(configuration.hostName());
		_port = configuration.port();
	}

	protected InetAddress getLocalhost() {
		try {
			return InetAddress.getLocalHost();
		}
		catch (UnknownHostException uhe) {
			_log.error(">>> Error retrieving localhost address", uhe);

			return InetAddress.getLoopbackAddress();
		}
	}

	protected Optional<Socket> openSocket() {
		try {
			return Optional.of(new Socket(_hostName, _port));
		}
		catch (IOException ioe) {
			_log.error(
				">>> Error opening socket on: " + _hostName + StringPool.COLON +
					_port,
				ioe);
		}

		return Optional.<Socket>empty();
	}

	protected void sendCommand(
		Socket socket, Command command, String... params) {

		if (_log.isInfoEnabled()) {
			StringBundler msg = new StringBundler(6);

			msg.append(">>> Sent command: ");
			msg.append(command);
			msg.append(StringPool.SPACE);
			msg.append(StringPool.DASH);
			msg.append(StringPool.SPACE);
			msg.append(Arrays.toString(params));

			_log.info(msg.toString());
		}

		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true))
		{
			out.println(
				command.toString() + StringPool.SPACE +
				StringUtil.merge(params, StringPool.SPACE));
		}
		catch (IOException ioe) {
			_log.error(">>> Error retrieving socket output stream");
		}
	}

	protected void setHostName(String hostName) {
		try {
			_hostName = InetAddress.getByName(hostName);
		}
		catch (UnknownHostException uhe) {
			_hostName = getLocalhost();
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		RaspberryPiServiceImpl.class);

	private InetAddress _hostName;
	private int _port;

}