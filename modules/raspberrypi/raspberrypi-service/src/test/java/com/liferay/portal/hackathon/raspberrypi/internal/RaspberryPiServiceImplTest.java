package com.liferay.portal.hackathon.raspberrypi.internal;

import static com.liferay.portal.hackathon.raspberrypi.configuration.RaspberryPiServiceConfiguration.DEFAULT_HOST_NAME;
import static com.liferay.portal.hackathon.raspberrypi.configuration.RaspberryPiServiceConfiguration.DEFAULT_PORT;
import static com.liferay.portal.hackathon.raspberrypi.constants.RaspberryPiServiceConstants.Color.RED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Igor Arouca
 */
public class RaspberryPiServiceImplTest {

	@Before
	public void setUp() {
		_rasberryPiService = new RaspberryPiServiceImpl();

		Map<String, Object> properties = new HashMap<>();

		properties.put("hostName", DEFAULT_HOST_NAME);
		properties.put("port", DEFAULT_PORT);

		_rasberryPiService.activate(properties);
	}

	@After
	public void tearDown() {
		_threadExecutor.shutdown();
	}

	@Test
	public void testTurnOn() throws InterruptedException {
		CountDownLatch latch = startServer();

		latch.await(1, TimeUnit.SECONDS);

		_rasberryPiService.turnOn(RED);

		String response = null;

		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(_socket.getInputStream()))) {

			response = in.readLine();
		}
		catch (Exception ioe) {
			ioe.printStackTrace();
		}

		Assert.assertEquals("turnon red", response);
	}

	protected CountDownLatch startServer() {
		_latch = new CountDownLatch(1);

		int defaultPort = Integer.parseInt(DEFAULT_PORT);

		Runnable startServer = () -> {
			try (ServerSocket serverSocket = new ServerSocket(defaultPort)) {
				_latch.countDown();

				_socket = serverSocket.accept();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		};

		_threadExecutor = Executors.newSingleThreadExecutor();

		_threadExecutor.submit(startServer);

		return _latch;
	}

	private CountDownLatch _latch;
	private RaspberryPiServiceImpl _rasberryPiService;
	private Socket _socket;
	private ExecutorService _threadExecutor;

}