package com.liferay.portal.hackathon.raspberrypi.constants;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Igor Arouca
 */
public class RaspberryPiServiceConstants {

	public static enum Color {
		GREEN, RED;

		@Override
		public String toString() {
			return StringUtil.lowerCase(name());
		}

	}

	public static enum Command {

		TURN_ON, TURN_OFF;

		@Override
		public String toString() {
			return StringUtil.lowerCase(
				StringUtil.replace(
					name(), CharPool.UNDERLINE, StringPool.BLANK));
		}

	}

}