package com.liferay.portal.hackathon.raspberrypi.internal;

import static com.liferay.portal.hackathon.raspberrypi.configuration.RaspberryPiServiceConfiguration.DEFAULT_HOST_NAME;
import static com.liferay.portal.hackathon.raspberrypi.configuration.RaspberryPiServiceConfiguration.DEFAULT_PORT;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.Closeable;
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
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Igor Arouca
 */
@Ignore
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

		closeQuietly(_socket);
		closeQuietly(_serverSocket);
	}

	@Test
	public void testTurnOn() throws InterruptedException {
		CountDownLatch socketConnectionLatch = startServer();

		socketConnectionLatch.await(1, TimeUnit.SECONDS);

		_rasberryPiService.turnOn("red");
		Assert.assertEquals("turnon red", readResponse());

		_rasberryPiService.turnOn(Color.GREEN);
		Assert.assertEquals("turnon green", readResponse());
	}

	protected void closeQuietly(Closeable closeable) {
		try {
			closeable.close();
		}
		catch (IOException ignored) {
		}
	}

	protected String readResponse() {
		String response = null;

		try {
			BufferedReader in = new BufferedReader(
				new InputStreamReader(_socket.getInputStream()));

			response = in.readLine();
		}
		catch (Exception ioe) {
			ioe.printStackTrace();
		}

		return response;
	}

	protected CountDownLatch startServer() {
		CountDownLatch socketConnectionLatch = new CountDownLatch(1);

		int defaultPort = Integer.parseInt(DEFAULT_PORT);

		Runnable startServer = () -> {
			try {
				_serverSocket = new ServerSocket(defaultPort);

				socketConnectionLatch.countDown();

				_socket = _serverSocket.accept();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		};

		_threadExecutor = Executors.newSingleThreadExecutor();

		_threadExecutor.submit(startServer);

		return socketConnectionLatch;
	}

	private RaspberryPiServiceImpl _rasberryPiService;
	
	private ServerSocket _serverSocket;
	private Socket _socket;
	private ExecutorService _threadExecutor;

}